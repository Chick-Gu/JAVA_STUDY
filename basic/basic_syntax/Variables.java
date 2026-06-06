package basic_syntax;

/**
 * 变量与数据类型示例
 * 演示Java的8种基本数据类型
 */
public class Variables {
    public static void main(String[] args) {
        byte byteValue = 10;
        short shortValue = 100;
        int intValue = 1000;
        long longValue = 10000L;
        
        float floatValue = 3.14f;
        double doubleValue = 3.1415926;
        
        boolean boolValue = true;
        
        char charValue = 'A';
        String stringValue = "你好 Java";
        
        System.out.println("字节型: " + byteValue);
        System.out.println("整型: " + intValue);
        System.out.println("双精度浮点: " + doubleValue);
        System.out.println("布尔值: " + boolValue);
        System.out.println("字符串: " + stringValue);
    }
}
