# 并发编程 (concurrency)

本文件夹包含Java多线程和并发编程的示例，涵盖线程创建、同步、线程池和异步编程。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `ThreadDemo.java` | 多线程基础示例，演示Thread和Runnable创建线程 |
| `ThreadPoolDemo.java` | 线程池示例，演示使用ExecutorService管理线程 |
| `SynchronizationDemo.java` | 同步示例，演示synchronized和volatile的使用 |
| `CompletableFutureDemo.java` | CompletableFuture示例，演示异步编程 |
| `CallableFutureDemo.java` | Callable和Future示例，演示获取线程返回值 |

## 线程生命周期

```
         ┌───────────────┐
         │     NEW       │ 创建线程对象
         └───────┬───────┘
                 │ start()
                 ▼
         ┌───────────────┐
         │   RUNNABLE    │──────────┐
         └───────┬───────┘          │
                 │                  │ wait()/sleep()/IO
                 ▼                  ▼
         ┌───────────────┐  ┌───────────────┐
         │   BLOCKED     │  │   WAITING     │
         └───────┬───────┘  └───────────────┘
                 │                  │
                 │ notify()/timeout│
                 ▼                  ▼
         ┌───────────────┐  ┌───────────────┐
         │ RUNNABLE ◀─────┴──│ TIMED_WAITING │
         └───────┬───────┘  └───────────────┘
                 │
                 │ run()完成
                 ▼
         ┌───────────────┐
         │  TERMINATED    │ 线程结束
         └───────────────┘
```

## 创建线程的方式

### 方式1: 继承Thread类

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程执行中...");
    }
}

MyThread thread = new MyThread();
thread.start();  // 调用start()而非run()
```

### 方式2: 实现Runnable接口 (推荐)

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程执行中...");
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();
```

### 方式3: 实现Callable接口 (有返回值)

```java
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        return 42;
    }
}

FutureTask<Integer> task = new FutureTask<>(new MyCallable());
new Thread(task).start();
Integer result = task.get();  // 获取返回值
```

### 方式4: 线程池 (推荐)

```java
ExecutorService executor = Executors.newFixedThreadPool(4);
executor.submit(() -> {
    System.out.println("线程池执行");
});
executor.shutdown();
```

## 线程同步

### synchronized关键字

```java
// 方法级别
public synchronized void method() {
    // 原子操作
}

// 代码块级别
public void method() {
    synchronized (this) {  // 锁对象
        // 原子操作
    }
}

// 静态方法 - 锁类对象
public static synchronized void staticMethod() {
    // 原子操作
}
```

### volatile关键字（扩展知识）

保证变量的可见性（一个线程修改后，其他线程立即看到）

```java
private volatile boolean running = true;

public void stop() {
    running = false;  // 修改对其他线程立即可见
}
```

**注意**: volatile不保证原子性（如i++）

### 线程安全类（扩展知识）

| 类 | 说明 |
|----|------|
| ConcurrentHashMap | 高效并发Map |
| CopyOnWriteArrayList | 读多写少场景 |
| BlockingQueue | 阻塞队列 |
| AtomicInteger | 原子整数 |

## 线程池

### 常用线程池

```java
// 固定大小线程池
ExecutorService fixed = Executors.newFixedThreadPool(4);

// 缓存线程池
ExecutorService cached = Executors.newCachedThreadPool();

// 单线程池
ExecutorService single = Executors.newSingleThreadExecutor();

// 调度线程池
ScheduledExecutorService scheduled = 
    Executors.newScheduledThreadPool(4);
```

### ThreadPoolExecutor

```java
ThreadPoolExecutor executor = new ThreadPoolExecutor(
    2,                      // 核心线程数
    4,                      // 最大线程数
    60,                     // 空闲线程存活时间
    TimeUnit.SECONDS,       // 时间单位
    new LinkedBlockingQueue<>(100),  // 任务队列
    new ThreadPoolExecutor.CallerRunsPolicy()  // 拒绝策略
);
```

**拒绝策略**:
- `AbortPolicy`: 抛出RejectedExecutionException
- `CallerRunsPolicy`: 由调用线程执行
- `DiscardPolicy`: 丢弃任务
- `DiscardOldestPolicy`: 丢弃最老的任务

## 同步工具（扩展知识）

| 工具 | 作用 |
|------|------|
| `CountDownLatch` | 倒计数，等待N个操作完成 |
| `CyclicBarrier` | 循环栅栏，等待N个线程到达 |
| `Semaphore` | 信号量，控制并发数量 |
| `Exchanger` | 交换数据 |
| `Phaser` | 阶段同步 |

**注意**：以上同步工具在实际代码中未演示，属于扩展知识

## 最佳实践

1. **优先使用线程池**而非直接创建Thread
2. **使用Callable获取返回值**
3. **线程安全的集合**替代Collections.synchronized*
4. **volatile用于状态标记**
5. **synchronized优先于Lock**（简单场景）
6. **使用ThreadLocal减少线程竞争**
7. **避免死锁**：按序获取锁、设置超时

## 常见问题

### 死锁

```java
// 线程1持有A锁，等待B锁
// 线程2持有B锁，等待A锁
// 造成死锁

// 解决方案：按固定顺序获取锁
```

### 竞态条件

```java
// 不安全：多个线程同时修改
count++;

// 安全：使用原子类
AtomicInteger count = new AtomicInteger();
count.incrementAndGet();
```
