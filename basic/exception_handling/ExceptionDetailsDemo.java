package exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 自定义异常和try-with-resources示例
 */
public class ExceptionDetailsDemo {
    
    /**
     * 自定义异常类
     */
    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
        
        public InvalidAgeException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
     * 自定义运行时异常
     */
    public static class NegativeNumberException extends RuntimeException {
        public NegativeNumberException(String message) {
            super(message);
        }
    }
    
    /**
     * 抛出自定义异常
     */
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("年龄不能为负数: " + age);
        }
        if (age > 150) {
            throw new InvalidAgeException("年龄超过合理范围: " + age);
        }
        System.out.println("年龄有效: " + age);
    }
    
    /**
     * 使用try-with-resources（自动关闭资源）
     */
    public static void readFile(String path) {
        // try-with-resources会自动关闭实现AutoCloseable接口的资源
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("文件读取失败: " + e.getMessage());
        }
        // reader在这里已经自动关闭，不需要手动close()
    }
    
    /**
     * 异常链
     */
    public static void processData(String input) throws InvalidAgeException {
        try {
            int age = Integer.parseInt(input);
            validateAge(age);
        } catch (NumberFormatException e) {
            // 将原始异常包装为自定义异常
            throw new InvalidAgeException("无效的年龄格式: " + input, e);
        }
    }
    
    public static void main(String[] args) {
        // 测试自定义检查异常
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
        
        // 测试运行时异常
        try {
            throw new NegativeNumberException("数字不能为负");
        } catch (NegativeNumberException e) {
            System.out.println("运行时异常: " + e.getMessage());
        }
        
        // 测试异常链
        try {
            processData("abc");
        } catch (InvalidAgeException e) {
            System.out.println("异常链测试: " + e.getMessage());
            System.out.println("原始原因: " + e.getCause());
        }
        
        // 测试try-with-resources
        // readFile("test.txt");  // 需要文件存在才能测试
        System.out.println("try-with-resources演示完成");
    }
}
