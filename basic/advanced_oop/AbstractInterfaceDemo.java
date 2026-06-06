package advanced_oop;

/**
 * 抽象类和接口示例
 */
public class AbstractInterfaceDemo {
    
    /**
     * 抽象类 - 包含抽象方法和具体方法
     */
    public abstract class Animal {
        protected String name;
        
        public Animal(String name) {
            this.name = name;
        }
        
        // 抽象方法 - 子类必须实现
        public abstract void makeSound();
        
        // 具体方法 - 子类可以继承或重写
        public void eat() {
            System.out.println(name + "正在吃东西");
        }
    }
    
    /**
     * 接口 - 只包含抽象方法（Java 8+可以有默认方法）
     */
    public interface Flyable {
        void fly();
        
        // 默认方法
        default void land() {
            System.out.println("降落中...");
        }
    }
    
    /**
     * 实现类
     */
    public class Bird extends Animal implements Flyable {
        public Bird(String name) {
            super(name);
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + "叽叽喳喳");
        }
        
        @Override
        public void fly() {
            System.out.println(name + "正在飞翔");
        }
    }
    
    public static void main(String[] args) {
        AbstractInterfaceDemo demo = new AbstractInterfaceDemo();
        Bird bird = demo.new Bird("麻雀");
        
        bird.makeSound();
        bird.eat();
        bird.fly();
        bird.land();
    }
}
