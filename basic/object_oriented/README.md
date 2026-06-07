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

```java
public class Person {
    private String name;  // 私有属性，外部无法直接访问
    private int age;
    
    // 提供公开的getter和setter方法
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
```

**访问修饰符**:
- `private`: 仅同类可见
- `default` (无修饰符): 同包可见
- `protected`: 同包 + 子类可见
- `public`: 全局可见

### 2. 继承 (Inheritance)

子类继承父类的属性和方法，实现代码复用。

```java
public class Student extends Person {
    private String school;
    
    public Student(String name, int age, String school) {
        super(name, age);  // 调用父类构造方法
        this.school = school;
    }
}
```

**注意**:
- Java只支持单继承，一个类只能有一个父类
- 子类可以重写(Override)父类的方法
- 使用`super`关键字调用父类成员

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

```java
// 浅拷贝：只拷贝引用
Person shallow = person;

// 深拷贝：拷贝整个对象
Person deep = (Person) person.clone();
```

## 最佳实践

1. 优先使用组合而非继承
2. 使用接口定义行为，使用抽象类提供默认实现
3. 封装时遵循"最小权限原则"
4. 避免在构造方法中调用可被重写的方法
