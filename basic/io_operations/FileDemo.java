package io_operations;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件操作示例
 * 演示文件的创建、写入、读取和删除
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("test.txt");
        
        try {
            if (file.createNewFile()) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件已存在");
            }
            
            FileWriter writer = new FileWriter(file);
            writer.write("你好，Java IO！\n这是第二行内容");
            writer.close();
            System.out.println("写入成功");
            
            FileReader reader = new FileReader(file);
            char[] buffer = new char[1024];
            int length = reader.read(buffer);
            reader.close();
            System.out.println("读取内容:\n" + new String(buffer, 0, length));
            
            if (file.delete()) {
                System.out.println("文件已删除");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
