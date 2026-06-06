package object_oriented;

/**
 * 内部类和匿名类示例
 */
public class InnerClassesDemo {
    
    private String outerName = "外部类";
    
    /**
     * 成员内部类
     */
    public class MemberInnerClass {
        public void sayHello() {
            System.out.println("成员内部类: " + outerName);
        }
    }
    
    /**
     * 静态内部类
     */
    public static class StaticInnerClass {
        public void sayHello() {
            System.out.println("静态内部类");
        }
    }
    
    /**
     * 局部内部类（在方法内部定义）
     */
    public void methodWithInnerClass() {
        final String localVar = "局部变量";
        
        class LocalInnerClass {
            public void sayHello() {
                System.out.println("局部内部类: " + localVar);
            }
        }
        
        LocalInnerClass local = new LocalInnerClass();
        local.sayHello();
    }
    
    public static void main(String[] args) {
        // 创建成员内部类
        InnerClassesDemo outer = new InnerClassesDemo();
        InnerClassesDemo.MemberInnerClass inner = outer.new MemberInnerClass();
        inner.sayHello();
        
        // 创建静态内部类
        InnerClassesDemo.StaticInnerClass staticInner = new InnerClassesDemo.StaticInnerClass();
        staticInner.sayHello();
        
        // 调用包含局部内部类的方法
        outer.methodWithInnerClass();
        
        // 匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类 - Runnable");
            }
        };
        runnable.run();
        
        // Lambda表达式（Java 8+）
        Runnable lambdaRunnable = () -> System.out.println("Lambda表达式");
        lambdaRunnable.run();
    }
}
