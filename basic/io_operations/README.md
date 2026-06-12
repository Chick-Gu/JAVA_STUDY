# IO操作 (io_operations)

本文件夹包含Java输入输出操作的示例，涵盖传统IO、NIO和对象序列化。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `FileDemo.java` | 文件操作示例，演示文件的创建、写入、读取和删除 |
| `NioSerializationDemo.java` | NIO和序列化示例，演示使用NIO进行文件操作以及对象的序列化和反序列化 |

## IO流分类

```
IO流
├─ 字节流
│   ├─ InputStream (输入)
│   │   ├─ FileInputStream
│   │   ├─ BufferedInputStream
│   │   └─ ObjectInputStream
│   └─ OutputStream (输出)
│       ├─ FileOutputStream
│       ├─ BufferedOutputStream
│       └─ ObjectOutputStream
└─ 字符流
    ├─ Reader (输入)
    │   ├─ FileReader
    │   ├─ BufferedReader
    │   └─ InputStreamReader
    └─ Writer (输出)
        ├─ FileWriter
        ├─ BufferedWriter
        └─ OutputStreamWriter
```

## 核心概念

### 1. 传统IO (java.io)

**字节流**: 处理二进制数据
```java
// 读取文件
FileInputStream fis = new FileInputStream("test.txt");
byte[] buffer = new byte[1024];
int length = fis.read(buffer);
fis.close();

// 写入文件
FileOutputStream fos = new FileOutputStream("test.txt");
fos.write("Hello".getBytes());
fos.close();
```

**字符流**: 处理文本数据
```java
// 读取文件
FileReader fr = new FileReader("test.txt");
BufferedReader br = new BufferedReader(fr);
String line = br.readLine();
br.close();

// 写入文件
FileWriter fw = new FileWriter("test.txt");
BufferedWriter bw = new BufferedWriter(fw);
bw.write("Hello");
bw.close();
```

### 2. NIO (java.nio)

**实际代码使用 NIO.2（Java 7+）的 Files 工具类：**
```java
// 读取所有行
List<String> lines = Files.readAllLines(Path.of("test.txt"));

// 读取所有字节
byte[] bytes = Files.readAllBytes(Path.of("test.txt"));

// 写入字符串（Java 11+）
Files.writeString(Path.of("test.txt"), "Hello");
```

**传统 NIO（FileChannel + ByteBuffer）：**
```java
// 使用NIO读取文件
FileInputStream fis = new FileInputStream("test.txt");
FileChannel channel = fis.getChannel();
ByteBuffer buffer = ByteBuffer.allocate(1024);
channel.read(buffer);
buffer.flip();  // 切换读模式
while(buffer.hasRemaining()) {
    System.out.print((char)buffer.get());
}
channel.close();
```

**传统IO vs NIO**:

| 特性 | 传统IO | NIO |
|------|--------|-----|
| 面向 | 流 | 缓冲区 |
| 阻塞 | 阻塞式 | 非阻塞式 |
| 模式 | 同步 | 同步/异步 |
| 适用 | 简单场景 | 高并发 |

**注意事项**：
- 实际代码使用 `Files.writeString()`，这是 **Java 11+** 的 API
- NIO.2（java.nio.file）比传统 NIO 更易用，推荐优先使用

### 3. 序列化 (Serialization)

将对象转换为字节流，便于存储或网络传输。

```java
// 序列化
Person p = new Person("张三", 20);
ObjectOutputStream oos = new ObjectOutputStream(
    new FileOutputStream("person.ser"));
oos.writeObject(p);
oos.close();

// 反序列化
ObjectInputStream ois = new ObjectInputStream(
    new FileInputStream("person.ser"));
Person p2 = (Person) ois.readObject();
ois.close();
```

**Serializable接口**:
```java
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    // 序列化版本号，用于版本兼容
}
```

**transient关键字**: 标记的属性不参与序列化

## 常用类速查

| 类 | 用途 |
|----|------|
| `File` | 文件和目录操作 |
| `FileInputStream`/`FileOutputStream` | 字节流文件读写 |
| `FileReader`/`FileWriter` | 字符流文件读写 |
| `BufferedReader`/`BufferedWriter` | 带缓冲的字符流 |
| `DataInputStream`/`DataOutputStream` | 基本数据类型读写 |
| `ObjectInputStream`/`ObjectOutputStream` | 对象序列化 |
| `ByteBuffer`/`CharBuffer` | NIO缓冲区 |

## 最佳实践

1. 使用`try-with-resources`自动关闭流
2. 大文件读写使用缓冲流提高性能
3. 序列化时使用`serialVersionUID`确保版本兼容
4. 高并发场景考虑使用NIO
5. 敏感数据考虑加密序列化
