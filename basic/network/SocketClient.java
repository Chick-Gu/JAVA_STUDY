package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Socket客户端示例
 */
public class SocketClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8888)) {
            System.out.println("已连接到服务器");
            
            // 发送消息
            OutputStreamWriter out = new OutputStreamWriter(
                socket.getOutputStream());
            out.write("Hello Server!\n");
            out.flush();
            
            // 接收响应
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("服务器响应: " + response);
            
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
