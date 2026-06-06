package concurrency;

/**
 * 同步机制示例
 * 演示synchronized关键字和线程安全问题
 */
public class SynchronizationDemo {
    
    /**
     * 非线程安全的计数器
     */
    public static class Counter {
        private int count = 0;
        
        // 不加同步的方法
        public void increment() {
            count++;
        }
        
        // 加同步的方法
        public synchronized void synchronizedIncrement() {
            count++;
        }
        
        public int getCount() {
            return count;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        
        // 创建100个线程，每个线程执行1000次递增
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    // counter.increment();          // 非同步，结果可能小于100000
                    counter.synchronizedIncrement(); // 同步，结果正确
                }
            });
            threads[i].start();
        }
        
        // 等待所有线程完成
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("最终计数: " + counter.getCount());
    }
}
