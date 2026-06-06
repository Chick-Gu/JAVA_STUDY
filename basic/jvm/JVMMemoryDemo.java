package jvm;

/**
 * JVM内存模型示例
 * 演示堆内存、栈内存和方法区的使用
 */
public class JVMMemoryDemo {
    
    /**
     * 演示栈内存（局部变量）
     */
    public static int calculate(int a, int b) {
        int sum = a + b;  // sum 在栈内存中
        return sum;
    }
    
    /**
     * 演示堆内存（对象）
     */
    public static class Person {
        private String name;  // name 引用在栈中，对象在堆中
        
        public Person(String name) {
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        // 基本类型在栈中
        int x = 10;
        int y = 20;
        
        // 对象在堆中，引用在栈中
        Person person = new Person("张三");
        
        // 方法调用，参数和局部变量在栈中
        int result = calculate(x, y);
        System.out.println("计算结果: " + result);
        System.out.println("Person对象: " + person.name);
    }
}
