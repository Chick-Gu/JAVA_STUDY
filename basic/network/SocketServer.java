package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务器示例
 */
public class SocketServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("服务器已启动，监听端口8888...");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接");
            
            // 读取客户端消息
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("收到客户端消息: " + message);
            
            // 发送响应
            OutputStreamWriter out = new OutputStreamWriter(
                clientSocket.getOutputStream());
            out.write("收到消息: " + message + "\n");
            out.flush();
            
            // 关闭连接
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
