package basic_syntax;

/**
 * 运算符和表达式示例
 * 演示Java中的各种运算符
 */
public class OperatorsDemo {
    
    public static void main(String[] args) {
        // 1. 算术运算符
        int a = 10;
        int b = 3;
        System.out.println("=== 算术运算符 ===");
        System.out.println("a + b = " + (a + b));      // 加法
        System.out.println("a - b = " + (a - b));      // 减法
        System.out.println("a * b = " + (a * b));      // 乘法
        System.out.println("a / b = " + (a / b));      // 除法（整数除法）
        System.out.println("a % b = " + (a % b));      // 取模
        System.out.println("a++ = " + (a++));          // 后置递增
        System.out.println("++a = " + (++a));          // 前置递增
        System.out.println("b-- = " + (b--));          // 后置递减
        System.out.println("--b = " + (--b));          // 前置递减
        
        // 2. 比较运算符
        System.out.println("\n=== 比较运算符 ===");
        System.out.println("a == b ? " + (a == b));    // 等于
        System.out.println("a != b ? " + (a != b));    // 不等于
        System.out.println("a > b ? " + (a > b));      // 大于
        System.out.println("a < b ? " + (a < b));      // 小于
        System.out.println("a >= b ? " + (a >= b));    // 大于等于
        System.out.println("a <= b ? " + (a <= b));    // 小于等于
        
        // 3. 逻辑运算符
        boolean x = true;
        boolean y = false;
        System.out.println("\n=== 逻辑运算符 ===");
        System.out.println("x && y = " + (x && y));    // 逻辑与（短路）
        System.out.println("x || y = " + (x || y));    // 逻辑或（短路）
        System.out.println("!x = " + (!x));            // 逻辑非
        System.out.println("x & y = " + (x & y));      // 逻辑与（非短路）
        System.out.println("x | y = " + (x | y));      // 逻辑或（非短路）
        System.out.println("x ^ y = " + (x ^ y));      // 异或
        
        // 4. 位运算符
        int c = 60;   // 0011 1100
        int d = 13;   // 0000 1101
        System.out.println("\n=== 位运算符 ===");
        System.out.println("c & d = " + (c & d));      // 按位与 0000 1100 = 12
        System.out.println("c | d = " + (c | d));      // 按位或 0011 1101 = 61
        System.out.println("c ^ d = " + (c ^ d));      // 按位异或 0011 0001 = 49
        System.out.println("~c = " + (~c));            // 按位取反
        System.out.println("c << 2 = " + (c << 2));    // 左移 1111 0000 = 240
        System.out.println("c >> 2 = " + (c >> 2));    // 右移（带符号）0000 1111 = 15
        System.out.println("c >>> 2 = " + (c >>> 2));  // 无符号右移
        
        // 5. 赋值运算符
        System.out.println("\n=== 赋值运算符 ===");
        int e = 10;
        e += 5;  // e = e + 5
        System.out.println("e += 5 = " + e);
        e -= 3;  // e = e - 3
        System.out.println("e -= 3 = " + e);
        e *= 2;  // e = e * 2
        System.out.println("e *= 2 = " + e);
        
        // 6. 三元运算符
        int max = (a > b) ? a : b;
        System.out.println("\n=== 三元运算符 ===");
        System.out.println("max(a, b) = " + max);
    }
}
