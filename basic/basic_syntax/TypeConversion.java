package basic_syntax;

/**
 * 类型转换示例
 * 演示Java中的自动转换和强制转换
 */
public class TypeConversion {
    
    public static void main(String[] args) {
        // 1. 自动类型转换（向上转换）
        System.out.println("=== 自动类型转换 ===");
        byte b = 10;
        short s = b;      // byte -> short
        int i = s;        // short -> int
        long l = i;       // int -> long
        float f = l;      // long -> float
        double d = f;     // float -> double
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        
        // 2. 强制类型转换（向下转换）
        System.out.println("\n=== 强制类型转换 ===");
        double pi = 3.1415926;
        int intPi = (int) pi;  // 截断小数部分
        System.out.println("double pi: " + pi);
        System.out.println("int pi: " + intPi);
        
        long bigNum = 10000000000L;
        int smallNum = (int) bigNum;  // 可能丢失精度
        System.out.println("long: " + bigNum);
        System.out.println("int: " + smallNum);
        
        // 3. 数值与字符串转换
        System.out.println("\n=== 数值与字符串转换 ===");
        String numStr = "123";
        int num = Integer.parseInt(numStr);
        System.out.println("字符串转整数: " + num);
        
        double doubleNum = Double.parseDouble("3.14");
        System.out.println("字符串转double: " + doubleNum);
        
        String strFromInt = String.valueOf(456);
        System.out.println("整数转字符串: " + strFromInt);
        
        // 4. char与int转换
        System.out.println("\n=== char与int转换 ===");
        char ch = 'A';
        int charCode = ch;  // 自动转换为ASCII码
        System.out.println("字符'A'的ASCII码: " + charCode);
        
        char fromInt = (char) 65;  // 强制转换
        System.out.println("ASCII码65对应的字符: " + fromInt);
    }
}
