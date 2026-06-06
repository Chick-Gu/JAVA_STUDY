package object_oriented;

import java.io.Serializable;

/**
 * 人类类
 * 演示面向对象的封装特性以及对象复制（浅拷贝和深拷贝）
 */
public class Person implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    
    // 私有属性（封装）
    private String name;
    private int age;
    
    /**
     * 构造方法
     */
    public Person() {}
    
    /**
     * 带参数构造方法
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * 复制构造函数（浅拷贝）
     */
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }
    
    /**
     * Getter 方法
     */
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    /**
     * Setter 方法（带验证）
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
    
    /**
     * 自我介绍方法
     */
    public void introduce() {
        System.out.println("我叫" + name + "，今年" + age + "岁");
    }
    
    /**
     * 浅拷贝（使用 clone 方法）
     * 只复制对象本身，引用类型字段共享
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /**
     * 深拷贝（手动实现）
     * 递归复制所有字段，包括引用类型
     */
    public Person deepCopy() {
        Person copy = new Person();
        copy.name = this.name;        // String 是不可变对象，直接赋值即可
        copy.age = this.age;
        return copy;
    }
    
    /**
     * 主方法测试
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // 原始对象
        Person person = new Person("张三", 25);
        System.out.println("原始对象:");
        person.introduce();
        
        // 测试浅拷贝（使用 clone）
        Person shallowClone = (Person) person.clone();
        System.out.println("\n浅拷贝对象:");
        shallowClone.introduce();
        
        // 测试浅拷贝（使用复制构造函数）
        Person copyConstructor = new Person(person);
        System.out.println("\n复制构造函数对象:");
        copyConstructor.introduce();
        
        // 测试深拷贝
        Person deepClone = person.deepCopy();
        System.out.println("\n深拷贝对象:");
        deepClone.introduce();
        
        // 修改拷贝对象
        shallowClone.setName("李四");
        shallowClone.setAge(30);
        System.out.println("\n修改浅拷贝对象后:");
        System.out.print("原始对象: ");
        person.introduce();
        System.out.print("浅拷贝对象: ");
        shallowClone.introduce();
    }
}
