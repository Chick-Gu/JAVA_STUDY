package concurrency;

import java.util.concurrent.*;

/**
 * Callable和Future示例
 */
public class CallableFutureDemo {
    
    /**
     * Callable任务（有返回值）
     */
    public static class SumTask implements Callable<Integer> {
        private int start;
        private int end;
        
        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
                Thread.sleep(10);  // 模拟耗时操作
            }
            return sum;
        }
    }
    
    /**
     * 使用Future获取异步结果
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // 提交Callable任务
        Future<Integer> future1 = executor.submit(new SumTask(1, 100));
        Future<Integer> future2 = executor.submit(new SumTask(101, 200));
        
        // 执行其他操作...
        System.out.println("任务已提交，等待结果...");
        
        // 获取结果（会阻塞直到任务完成）
        int result1 = future1.get();
        int result2 = future2.get();
        
        System.out.println("任务1结果: " + result1);
        System.out.println("任务2结果: " + result2);
        System.out.println("总和: " + (result1 + result2));
        
        // 关闭线程池
        executor.shutdown();
    }
}
