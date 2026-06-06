package object_oriented;

/**
 * 接口和抽象类详解
 */
public class InterfaceDetailsDemo {
    
    /**
     * 接口可以继承多个接口
     */
    public interface Flyable {
        void fly();
        int MAX_HEIGHT = 10000;  // 常量（public static final）
    }
    
    public interface Swimmable {
        void swim();
    }
    
    /**
     * 接口多继承
     */
    public interface Amphibious extends Flyable, Swimmable {
        void walk();
    }
    
    /**
     * 抽象类可以实现接口
     */
    public static abstract class Animal {
        protected String name;
        
        public Animal(String name) {
            this.name = name;
        }
        
        public abstract void makeSound();
        
        public void eat() {
            System.out.println(name + "正在吃东西");
        }
    }
    
    /**
     * 具体类实现接口和继承抽象类
     */
    public static class Duck extends Animal implements Amphibious {
        public Duck(String name) {
            super(name);
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + "嘎嘎叫");
        }
        
        @Override
        public void fly() {
            System.out.println(name + "正在飞，最高高度: " + MAX_HEIGHT + "米");
        }
        
        @Override
        public void swim() {
            System.out.println(name + "正在游泳");
        }
        
        @Override
        public void walk() {
            System.out.println(name + "正在走路");
        }
    }
    
    public static void main(String[] args) {
        Duck duck = new Duck("唐老鸭");
        duck.makeSound();
        duck.eat();
        duck.fly();
        duck.swim();
        duck.walk();
        
        // 接口引用
        Flyable flyable = duck;
        flyable.fly();
        
        Swimmable swimmable = duck;
        swimmable.swim();
    }
}
