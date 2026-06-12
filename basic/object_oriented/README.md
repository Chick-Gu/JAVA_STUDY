# 面向对象编程 (object_oriented)

本文件夹包含Java面向对象编程的核心示例，涵盖OOP的四大特性：封装、继承、多态、抽象。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `Person.java` | 人类类，演示面向对象的封装特性以及对象复制（浅拷贝和深拷贝） |
| `Student.java` | 学生类，演示继承和多态特性 |
| `InterfaceDetailsDemo.java` | 接口详解，演示接口的定义、实现和多重继承 |
| `InnerClassesDemo.java` | 内部类，演示成员内部类、静态内部类、局部内部类和匿名内部类 |
| `DeepCopyUtil.java` | 深拷贝工具类，提供对象深拷贝的通用方法 |

## 核心概念

### 1. 封装 (Encapsulation)

将数据和操作封装在类中，通过访问修饰符控制访问权限。

**实际代码（Person.java）：**
```java
public class Person implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    // 私有属性（封装）
    private String name;
    private int age;

    // 无参构造函数
    public Person() {}

    // 带参数构造方法
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 复制构造函数（浅拷贝）
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getter 方法
    public String getName() { return name; }
    public int getAge() { return age; }

    // Setter 方法（带验证）
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {
        if (age > 0) {  // 验证年龄必须大于0
            this.age = age;
        }
    }

    // 自我介绍方法
    public void introduce() {
        System.out.println("我叫" + name + "，今年" + age + "岁");
    }

    // 浅拷贝（使用 clone 方法）
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 深拷贝（手动实现）
    public Person deepCopy() {
        Person copy = new Person();
        copy.name = this.name;  // String 是不可变对象，直接赋值即可
        copy.age = this.age;
        return copy;
    }
}
```

**访问修饰符**:
- `private`: 仅同类可见
- `default` (无修饰符): 同包可见
- `protected`: 同包 + 子类可见
- `public`: 全局可见

**注意事项**:
- Person 类实现了 `Cloneable` 和 `Serializable` 接口
- `setAge()` 方法有验证逻辑，年龄必须大于0
- 提供了两种拷贝方式：`clone()`（浅拷贝）和 `deepCopy()`（深拷贝）

### 2. 继承 (Inheritance)

子类继承父类的属性和方法，实现代码复用。

**实际代码（Student.java）：**
```java
public class Student extends Person implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    // 子类特有属性
    private String school;

    // 无参构造函数
    public Student() {}

    // 带参数构造方法
    public Student(String name, int age, String school) {
        super(name, age);  // 调用父类构造方法
        this.school = school;
    }

    // 复制构造函数
    public Student(Student other) {
        super(other);           // 调用父类的复制构造函数
        this.school = other.school;
    }

    // Getter 和 Setter
    public String getSchool() { return school; }
    public void setSchool(String school) { this.school = school; }

    // 重写自我介绍方法（多态）
    @Override
    public void introduce() {
        System.out.println("我叫" + getName() + "，今年" + getAge() + "岁，在" + school + "上学");
    }

    // 浅拷贝（子类需要重写以复制子类特有字段）
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        // 如果有引用类型字段，需要在这里处理
        return cloned;
    }

    // 深拷贝（手动实现）
    public Student deepCopy() {
        Student copy = new Student();
        copy.setName(this.getName());
        copy.setAge(this.getAge());
        copy.school = this.school;
        return copy;
    }
}
```

**注意**:
- Java只支持单继承，一个类只能有一个父类
- 子类可以重写(Override)父类的方法
- 使用`super`关键字调用父类成员
- Student 重写了 `introduce()` 方法，实现多态
- Student 重写了 `clone()` 方法，确保子类特有字段也被复制

### 3. 多态 (Polymorphism)

同一接口的不同实现，或父类引用指向子类对象。

```java
// 父类引用指向子类对象
Person p = new Student("张三", 20, "清华大学");

// 方法重写后的多态调用
p.eat();  // 调用的是Student类的eat方法
```

**多态的三要素**:
1. 继承关系
2. 子类重写父类方法
3. 父类引用指向子类对象

### 4. 抽象 (Abstraction)

抽象类和接口定义行为规范，具体实现由子类完成。

```java
// 抽象类
abstract class Animal {
    abstract void sound();  // 抽象方法，没有实现
}

// 接口
interface Flyable {
    void fly();
}
```

**抽象类 vs 接口**:
| 特性 | 抽象类 | 接口 |
|------|--------|------|
| 继承 | 单继承 | 多实现 |
| 属性 | 可以有普通属性 | 只能是常量 |
| 方法 | 可以有普通方法 | Java 8前全是抽象方法 |
| 构造方法 | 可以有 | 不能有 |

## 内部类

Java支持在类内部定义类，称为内部类。

| 类型 | 说明 | 访问外部类 |
|------|------|------------|
| 成员内部类 | 定义在类方法外 | 可以访问所有外部成员 |
| 静态内部类 | 用static修饰 | 只能访问外部静态成员 |
| 局部内部类 | 定义在方法内 | 可以访问方法局部变量(需final) |
| 匿名内部类 | 没有名字的类 | 访问同局部内部类 |

## 浅拷贝与深拷贝

**浅拷贝**：只复制对象本身，引用类型字段共享
```java
// 方式1：使用 clone() 方法
Person shallowClone = (Person) person.clone();

// 方式2：使用复制构造函数
Person copyConstructor = new Person(person);
```

**深拷贝**：递归复制所有字段，包括引用类型
```java
Person deepClone = person.deepCopy();
```

**注意事项**：
- `clone()` 是浅拷贝，引用类型字段会共享
- `deepCopy()` 是深拷贝，所有字段都是独立的
- String 是不可变对象，浅拷贝时可以直接赋值
- 如果有可变引用类型字段（如数组、集合），需要在深拷贝中手动复制

## 最佳实践

1. 优先使用组合而非继承
2. 使用接口定义行为，使用抽象类提供默认实现
3. 封装时遵循"最小权限原则"
4. 避免在构造方法中调用可被重写的方法
