# 网络编程 (network)

本文件夹包含Java网络通信的基础示例，涵盖TCP Socket编程和HTTP通信。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `SocketClient.java` | Socket客户端示例，演示如何连接服务器并发送/接收消息 |
| `SocketServer.java` | Socket服务器端示例，演示如何监听端口并处理客户端连接 |
| `HttpClientDemo.java` | HTTP客户端示例，演示发送HTTP请求并处理响应 |

## 核心概念

### 1. TCP Socket通信

Socket是基于TCP的网络通信编程模型，提供可靠的、面向连接的通信。

```
客户端流程:
1. 创建Socket，指定服务器地址和端口
2. 获取输出流，发送数据
3. 获取输入流，接收数据
4. 关闭Socket

服务器流程:
1. 创建ServerSocket，绑定端口
2. 调用accept()等待客户端连接
3. 获取客户端Socket，进行通信
4. 关闭客户端Socket和ServerSocket
```

### 2. Socket API 详解

```java
// 客户端
Socket socket = new Socket("localhost", 8888);
OutputStream out = socket.getOutputStream();
InputStream in = socket.getInputStream();

// 服务器
ServerSocket serverSocket = new ServerSocket(8888);
Socket clientSocket = serverSocket.accept();
```

**常用方法**:
- `getInputStream()`: 获取输入流
- `getOutputStream()`: 获取输出流
- `close()`: 关闭Socket
- `setSoTimeout(int timeout)`: 设置超时时间

### 3. HTTP协议

HTTP是超文本传输协议，用于Web通信，是请求-响应模式。

```
HTTP请求格式:
请求方法 URL路径 HTTP版本
请求头
请求体

HTTP响应格式:
HTTP版本 状态码 状态描述
响应头
响应体
```

**常用请求方法**:
- `GET`: 获取资源
- `POST`: 提交数据
- `PUT`: 更新资源
- `DELETE`: 删除资源

**常见状态码**:
- `200 OK`: 请求成功
- `400 Bad Request`: 请求错误
- `404 Not Found`: 资源未找到
- `500 Internal Server Error`: 服务器错误

## 运行说明

### TCP Socket通信

1. 先运行 `SocketServer.java` 启动服务器
2. 再运行 `SocketClient.java` 连接服务器进行通信

### HTTP请求

运行 `HttpClientDemo.java` 发送HTTP GET/POST请求

## 注意事项

1. Socket操作可能抛出`IOException`，需要妥善处理
2. 使用`try-with-resources`确保资源正确关闭
3. 服务器应处理多个客户端连接（可使用线程池）
4. 注意设置合理的超时时间
5. 大数据量传输时应考虑使用缓冲流

## 扩展学习

- **NIO**: 使用`java.nio.channels.SocketChannel`实现非阻塞IO
- **URLConnection**: Java内置的HTTP客户端
- **第三方库**: Apache HttpClient、OkHttp、Retrofit
