package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture示例（Java 8+）
 */
public class CompletableFutureDemo {
    
    /**
     * 模拟异步任务
     */
    public static CompletableFuture<String> fetchData(String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);  // 模拟网络延迟
                return "从 " + url + " 获取的数据";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("开始执行异步任务...");
        
        // 1. 基本使用
        CompletableFuture<String> future = fetchData("http://example.com");
        
        // 2. 链式调用
        future.thenAccept(data -> System.out.println("收到数据: " + data))
              .thenRun(() -> System.out.println("处理完成"));
        
        // 3. 组合多个Future
        CompletableFuture<String> future1 = fetchData("http://api1.com");
        CompletableFuture<String> future2 = fetchData("http://api2.com");
        
        // 等待所有任务完成
        CompletableFuture.allOf(future1, future2).join();
        
        System.out.println("任务1结果: " + future1.get());
        System.out.println("任务2结果: " + future2.get());
        
        // 4. 异常处理
        CompletableFuture<String> errorFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("模拟错误");
        });
        
        errorFuture.exceptionally(e -> {
            System.out.println("捕获异常: " + e.getMessage());
            return "默认值";
        }).thenAccept(System.out::println);
        
        // 等待所有任务完成
        Thread.sleep(2000);
        System.out.println("所有任务完成");
    }
}
