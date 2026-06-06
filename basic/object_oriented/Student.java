package object_oriented;

import java.io.Serializable;

/**
 * 学生类（继承Person类）
 * 演示面向对象的继承和多态特性，以及子类的克隆实现
 */
public class Student extends Person implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    
    // 子类特有属性
    private String school;
    
    /**
     * 构造方法
     */
    public Student() {}
    
    /**
     * 带参数构造方法
     */
    public Student(String name, int age, String school) {
        super(name, age);  // 调用父类构造方法
        this.school = school;
    }
    
    /**
     * 复制构造函数
     */
    public Student(Student other) {
        super(other);           // 调用父类的复制构造函数
        this.school = other.school;
    }
    
    /**
     * Getter 和 Setter
     */
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    
    /**
     * 重写自我介绍方法（多态）
     */
    @Override
    public void introduce() {
        System.out.println("我叫" + getName() + "，今年" + getAge() + "岁，在" + school + "上学");
    }
    
    /**
     * 浅拷贝（子类需要重写以复制子类特有字段）
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        // 如果有引用类型字段，需要在这里处理
        return cloned;
    }
    
    /**
     * 深拷贝（手动实现）
     */
    public Student deepCopy() {
        Student copy = new Student();
        copy.setName(this.getName());
        copy.setAge(this.getAge());
        copy.school = this.school;
        return copy;
    }
    
    /**
     * 主方法测试
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // 原始对象
        Student student = new Student("李四", 18, "清华大学");
        System.out.println("原始对象:");
        student.introduce();
        
        // 测试浅拷贝
        Student shallowClone = (Student) student.clone();
        System.out.println("\n浅拷贝对象:");
        shallowClone.introduce();
        
        // 测试深拷贝
        Student deepClone = student.deepCopy();
        System.out.println("\n深拷贝对象:");
        deepClone.introduce();
        
        // 修改拷贝对象
        shallowClone.setSchool("北京大学");
        System.out.println("\n修改浅拷贝对象后:");
        System.out.print("原始对象: ");
        student.introduce();
        System.out.print("浅拷贝对象: ");
        shallowClone.introduce();
    }
}
