package io_operations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * NIO和序列化示例
 */
public class NioSerializationDemo {
    
    /**
     * 可序列化的类
     */
    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    
    /**
     * 使用NIO读取文件
     */
    public static void readWithNIO(String path) throws IOException {
        Path filePath = Paths.get(path);
        
        // 读取所有行
        List<String> lines = Files.readAllLines(filePath);
        System.out.println("文件内容:");
        for (String line : lines) {
            System.out.println(line);
        }
        
        // 读取字节
        byte[] bytes = Files.readAllBytes(filePath);
        System.out.println("文件大小: " + bytes.length + " bytes");
    }
    
    /**
     * 使用NIO写入文件
     */
    public static void writeWithNIO(String path, String content) throws IOException {
        Path filePath = Paths.get(path);
        Files.writeString(filePath, content);
        System.out.println("文件写入成功");
    }
    
    /**
     * 对象序列化
     */
    public static void serializeObject(String path, Person person) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(person);
            System.out.println("对象序列化成功");
        }
    }
    
    /**
     * 对象反序列化
     */
    public static Person deserializeObject(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Person person = (Person) ois.readObject();
            System.out.println("对象反序列化成功");
            return person;
        }
    }
    
    public static void main(String[] args) {
        try {
            String filePath = "test_nio.txt";
            String content = "Hello, NIO!";
            
            // 写入文件
            writeWithNIO(filePath, content);
            
            // 读取文件
            readWithNIO(filePath);
            
            // 序列化对象
            Person person = new Person("张三", 25);
            String objPath = "person.ser";
            serializeObject(objPath, person);
            
            // 反序列化对象
            Person restored = deserializeObject(objPath);
            System.out.println("恢复的对象: " + restored);
            
            // 删除测试文件
            Files.deleteIfExists(Paths.get(filePath));
            Files.deleteIfExists(Paths.get(objPath));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
