package network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

/**
 * HTTP客户端示例（Java 11+）
 */
public class HttpClientDemo {
    
    public static void main(String[] args) {
        // 创建HTTP客户端
        HttpClient client = HttpClient.newHttpClient();
        
        // 创建请求
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/octocat"))
            .header("Accept", "application/json")
            .GET()
            .build();
        
        // 发送请求并获取响应
        try {
            HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("状态码: " + response.statusCode());
            System.out.println("响应头: " + response.headers());
            System.out.println("响应体:");
            System.out.println(response.body());
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        // 异步请求
        System.out.println("\n--- 异步请求 ---");
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(body -> System.out.println("异步响应: " + body.substring(0, 100) + "..."))
            .join();
    }
}
