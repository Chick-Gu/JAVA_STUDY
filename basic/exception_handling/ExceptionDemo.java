package exception_handling;

/**
 * 异常处理示例
 * 演示try-catch-finally和异常抛出
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("结果: " + result);
        } catch (ArithmeticException e) {
            System.out.println("捕获到异常: " + e.getMessage());
        } finally {
            System.out.println("finally块总是执行");
        }
        
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } catch (Exception e) {
            System.out.println("其他异常");
        }
        
        try {
            checkAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int divide(int a, int b) {
        return a / b;
    }
    
    public static void checkAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能为负数");
        }
        System.out.println("年龄有效: " + age);
    }
}
