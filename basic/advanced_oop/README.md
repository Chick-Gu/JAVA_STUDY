# 高级面向对象 (advanced_oop)

本文件夹包含Java高级面向对象编程的示例，重点演示设计模式和抽象类/接口的使用。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `SingletonDemo.java` | 单例模式示例，演示饿汉式、懒汉式和双重检查锁实现 |
| `FactoryPatternDemo.java` | 工厂模式示例，演示简单工厂、工厂方法和抽象工厂 |
| `AbstractInterfaceDemo.java` | 抽象类和接口示例，演示两者区别和使用场景 |

## 设计模式概述

设计模式是解决常见问题的最佳实践，分为三类：

```
设计模式
├─ 创建型 (Creational)
│   ├─ 单例模式 (Singleton)
│   ├─ 工厂模式 (Factory)
│   ├─ 抽象工厂 (Abstract Factory)
│   ├─ 建造者模式 (Builder)
│   └─ 原型模式 (Prototype)
├─ 结构型 (Structural)
│   ├─ 适配器模式 (Adapter)
│   ├─ 装饰器模式 (Decorator)
│   ├─ 代理模式 (Proxy)
│   ├─ 组合模式 (Composite)
│   ├─ 外观模式 (Facade)
│   └─ 桥接模式 (Bridge)
└─ 行为型 (Behavioral)
    ├─ 策略模式 (Strategy)
    ├─ 观察者模式 (Observer)
    ├─ 命令模式 (Command)
    ├─ 模板方法 (Template Method)
    └─ 迭代器模式 (Iterator)
```

## 单例模式 (Singleton)

确保一个类只有一个实例，并提供全局访问点。

### 饿汉式（线程安全）

```java
public class EagerSingleton {
    // 类加载时就创建实例
    private static final EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {
        // 私有构造函数，防止外部实例化
    }
    
    public static EagerSingleton getInstance() {
        return instance;
    }
}
```

### 懒汉式（线程不安全）

```java
public class LazySingleton {
    private static LazySingleton instance;
    
    private LazySingleton() {}
    
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

### 双重检查锁（推荐）

```java
public class DoubleCheckedSingleton {
    // volatile防止指令重排序
    private static volatile DoubleCheckedSingleton instance;
    
    private DoubleCheckedSingleton() {}
    
    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {  // 第一次检查
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {  // 第二次检查
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
```

### 静态内部类（推荐，扩展知识）

```java
public class StaticInnerSingleton {
    private StaticInnerSingleton() {}

    private static class Holder {
        private static final StaticInnerSingleton INSTANCE =
            new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

**实际代码（SingletonDemo.java）实现了三种单例：**
1. 饿汉式（EagerSingleton）
2. 懒汉式 + 双重检查锁（LazySingleton）
3. 枚举单例（EnumSingleton）— 最简洁，天然防止反射和序列化攻击

## 工厂模式 (Factory)

### 简单工厂（静态工厂）

**实际代码（FactoryPatternDemo.java）使用 switch-case：**
```java
// 产品接口
public interface Product {
    String getName();
}

// 具体产品（静态内部类）
public static class ProductA implements Product {
    @Override
    public String getName() { return "产品A"; }
}

public static class ProductB implements Product {
    @Override
    public String getName() { return "产品B"; }
}

// 简单工厂
public static class ProductFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "A": return new ProductA();
            case "B": return new ProductB();
            default: throw new IllegalArgumentException("未知产品类型: " + type);
        }
    }
}
```

**Java 14+ 箭头表达式写法（需要 JDK 14+）：**
```java
public static Product createProduct(String type) {
    return switch (type) {
        case "A" -> new ProductA();
        case "B" -> new ProductB();
        default -> throw new IllegalArgumentException("未知产品类型");
    };
}
```

**注意事项：**
- 实际代码中的产品类是**静态内部类**，这是简化演示的方式
- 简单工厂不属于 23 种设计模式，但很常用

### 工厂方法模式

```java
// 抽象工厂
public interface PhoneFactory {
    Phone createPhone();
}

// 具体工厂
public class IPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

public class AndroidFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new AndroidPhone();
    }
}

// 使用
PhoneFactory factory = new IPhoneFactory();
Phone phone = factory.createPhone();
```

### 抽象工厂模式

```java
// 产品族接口
public interface Phone {}
public interface Tablet {}

// 产品族A
public class IPhone implements Phone {}
public class IPad implements Tablet {}

// 产品族B
public class AndroidPhone implements Phone {}
public class AndroidPad implements Tablet {}

// 抽象工厂
public interface DeviceFactory {
    Phone createPhone();
    Tablet createTablet();
}

// 具体工厂
public class AppleFactory implements DeviceFactory {
    @Override
    public Phone createPhone() { return new IPhone(); }
    @Override
    public Tablet createTablet() { return new IPad(); }
}

public class SamsungFactory implements DeviceFactory {
    @Override
    public Phone createPhone() { return new AndroidPhone(); }
    @Override
    public Tablet createTablet() { return new AndroidPad(); }
}
```

## 抽象类 vs 接口

### 对比表

| 特性 | 抽象类 | 接口 |
|------|--------|------|
| 继承 | 单继承 | 多实现 |
| 属性 | 任意属性 | 只能是常量 (public static final) |
| 方法 | 任意方法 | Java 8前只能是抽象方法 |
| 构造方法 | 可以有 | 不能有 |
| 成员可见性 | 任意 | 隐式 public |
| 静态方法 | 可以 | Java 8+可以 |

### 使用场景

```java
// 抽象类：is-a关系，有共享实现
abstract class Animal {
    String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // 公共实现
    public void sleep() {
        System.out.println(name + "在睡觉");
    }
    
    // 抽象方法由子类实现
    public abstract void sound();
}

class Dog extends Animal {
    public Dog(String name) { super(name); }
    
    @Override
    public void sound() {
        System.out.println(name + "汪汪叫");
    }
}

// 接口：can-do关系，只定义行为契约
interface Flyable {
    void fly();
    
    // Java 8+ 默认方法
    default void land() {
        System.out.println("降落");
    }
    
    // Java 8+ 静态方法
    static void describe() {
        System.out.println("这是飞行接口");
    }
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("鸟儿飞翔");
    }
}
```

## 设计原则 (SOLID)（扩展知识）

| 原则 | 全称 | 说明 |
|------|------|------|
| SRP | 单一职责原则 | 一个类只负责一件事 |
| OCP | 开闭原则 | 对扩展开放，对修改关闭 |
| LSP | 里氏替换原则 | 子类可以替换父类 |
| ISP | 接口隔离原则 | 使用多个专门接口 |
| DIP | 依赖倒置原则 | 依赖抽象，不依赖具体 |

### 开闭原则示例

```java
// 违反OCP：添加新类型需要修改现有代码
class AreaCalculator {
    public double calculate(Object shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.getRadius() * c.getRadius();
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.getWidth() * r.getHeight();
        }
        // 添加Triangle需要修改这里
        return 0;
    }
}

// 符合OCP：添加新类型只需扩展
interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width, height;
    
    @Override
    public double area() {
        return width * height;
    }
}

// 计算器无需修改
class AreaCalculator {
    public double calculate(Shape shape) {
        return shape.area();
    }
}
```
