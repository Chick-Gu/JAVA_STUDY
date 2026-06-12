# Java 从入门到精通学习指南

欢迎来到 Java 学习的完整路径！本指南涵盖从基础语法到高级特性的所有内容，每个知识点都有对应的代码示例。

---

## 📁 项目结构

### 项目布局说明

本项目按照学习进度和知识模块进行组织，每个文件夹对应一个学习主题，包含可直接运行的代码示例。以下是详细说明：

| 文件夹 | 内容说明 | 文件数量 |
|--------|----------|----------|
| `basic_syntax/` | Java 基础语法，包括变量、控制流程、运算符等 | 5个 |
| `object_oriented/` | 面向对象编程核心概念：类、继承、多态、内部类等 | 5个 |
| `data_structures/` | 数据结构：数组、集合、队列、栈、Map、二叉树、图等 | 7个 |
| `exception_handling/` | 异常处理机制：try-catch、自定义异常、资源自动关闭 | 2个 |
| `io_operations/` | 文件操作和NIO：文件读写、对象序列化 | 2个 |
| `advanced_syntax/` | 高级语法：泛型、Lambda、Stream API、枚举 | 4个 |
| `advanced_oop/` | 高级面向对象：设计模式（单例、工厂） | 3个 |
| `concurrency/` | 并发编程：多线程、线程池、同步机制 | 5个 |
| `jvm/` | JVM原理：内存模型、垃圾回收、类加载 | 3个 |
| `network/` | 网络编程：Socket、HTTP客户端 | 3个 |
| `database/` | 数据库操作：JDBC基础 | 1个 |

```
basic/
├── README.md                           # 完整学习指南（对应所有代码）
├── hello_world.java                    # Hello World 入门示例
├── run.bat                             # 一键运行脚本
├── tutorial.html                       # 可视化学习网页
├── basic_syntax/                       # 基础语法（5个文件）
│   ├── Variables.java                  # 变量与数据类型（8种基本类型）
│   ├── ControlFlow.java                # 控制流程（if-else、循环、switch）
│   ├── OperatorsDemo.java              # 运算符详解（算术、比较、逻辑、位运算）
│   ├── StringOperations.java           # 字符串操作（String、StringBuilder）
│   └── TypeConversion.java             # 类型转换（自动转换、强制转换）
├── object_oriented/                    # 面向对象编程（5个文件）
│   ├── Person.java                     # 类与封装（含浅拷贝、深拷贝）
│   ├── Student.java                    # 继承与多态（子类克隆实现）
│   ├── DeepCopyUtil.java               # 深拷贝工具类（序列化方式）
│   ├── InnerClassesDemo.java           # 内部类（成员、静态、局部、匿名类）
│   └── InterfaceDetailsDemo.java       # 接口与抽象类详解（多实现、默认方法）
├── data_structures/                    # 数据结构（7个文件）
│   ├── ArraysDemo.java                 # 数组操作（声明、访问、排序）
│   ├── ArrayListDemo.java              # ArrayList详解（容量管理、Iterator、二分查找）
│   ├── CollectionDemo.java             # 集合框架（List、Set、Map基础）
│   ├── QueueStackDemo.java             # 队列与栈（Queue、Stack、Deque、PriorityQueue）
│   ├── MapDetailsDemo.java             # Map详解（HashMap、LinkedHashMap、TreeMap）
│   ├── BinaryTreeDemo.java             # 二叉树（遍历、BST操作、重建二叉树）
│   └── GraphDemo.java                  # 图（DFS/BFS、拓扑排序、Dijkstra）
├── exception_handling/                 # 异常处理（2个文件）
│   ├── ExceptionDemo.java              # try-catch-finally基础
│   └── ExceptionDetailsDemo.java       # 自定义异常与try-with-resources
├── io_operations/                      # IO操作（2个文件）
│   ├── FileDemo.java                   # 文件读写基础
│   └── NioSerializationDemo.java       # NIO与对象序列化
├── advanced_syntax/                    # 高级语法（4个文件）
│   ├── GenericsDemo.java               # 泛型（泛型类、方法、有界泛型）
│   ├── LambdaDemo.java                 # Lambda表达式（函数式接口、方法引用）
│   ├── StreamDemo.java                 # Stream API（过滤、映射、聚合）
│   └── EnumDemo.java                   # 枚举类型（定义、使用）
├── advanced_oop/                       # 高级面向对象（3个文件）
│   ├── AbstractInterfaceDemo.java      # 抽象类与接口（对比与实践）
│   ├── SingletonDemo.java              # 单例模式（饿汉式、懒汉式、枚举）
│   └── FactoryPatternDemo.java         # 工厂模式（简单工厂、工厂方法）
├── concurrency/                        # 并发编程（5个文件）
│   ├── ThreadDemo.java                 # 多线程基础（继承Thread、实现Runnable）
│   ├── ThreadPoolDemo.java             # 线程池（ExecutorService）
│   ├── SynchronizationDemo.java        # 同步机制（synchronized）
│   ├── CallableFutureDemo.java         # Callable与Future（有返回值任务）
│   └── CompletableFutureDemo.java      # CompletableFuture（异步编程进阶）
├── jvm/                                # JVM原理（3个文件）
│   ├── JVMMemoryDemo.java              # JVM内存模型（堆、栈、方法区）
│   ├── GarbageCollectionDemo.java      # 垃圾回收（GC机制）
│   └── ClassLoaderDemo.java            # 类加载机制（类加载器层次）
├── network/                            # 网络编程（3个文件）
│   ├── SocketServer.java               # Socket服务器端
│   ├── SocketClient.java               # Socket客户端
│   └── HttpClientDemo.java             # HTTP客户端（Java 11+ HttpClient）
└── database/                           # 数据库操作（1个文件）
    └── JdbcDemo.java                   # JDBC基础（连接、查询、更新）
```

---

## 🚀 第一部分：Java 基础入门

### 1.1 Hello World（对应 hello_world.java）

这是 Java 程序的"Hello World"入门示例，是学习任何编程语言的第一个程序。

**代码解释：**
- `public class hello_world`：定义一个公共类，类名必须与文件名一致
- `public static void main(String[] args)`：主方法，是 Java 程序的入口点
- `System.out.println("Hello World!")`：在控制台输出字符串

```java
public class hello_world {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

### 1.2 编译与运行（对应所有 .java 文件）

Java 是一种编译型语言，需要先将源代码编译成字节码，然后再运行。

**编译运行流程：**
1. **编译**：使用 `javac` 命令将 `.java` 源文件编译成 `.class` 字节码文件
2. **运行**：使用 `java` 命令执行字节码文件

```bash
# 编译单个文件（指定 UTF-8 编码防止中文乱码）
javac -encoding UTF-8 basic_syntax/Variables.java

# 编译所有文件并生成包结构
javac -encoding UTF-8 */*.java -d .

# 运行无包名的类（如 hello_world）
java hello_world

# 运行带包名的类（如 basic_syntax.Variables）
java basic_syntax.Variables
```

### 1.3 .java vs .class（对应所有文件）

Java 程序有两种重要的文件类型，理解它们的区别非常重要：

| 文件类型 | 内容 | 生成方式 | 可读方式 | 用途 |
| -------- | ---- | -------- | -------- | ---- |
| `.java` | 源代码（人类可读的文本） | 开发者编写 | 文本编辑器（如 VS Code） | 编写和维护程序逻辑 |
| `.class` | 字节码（JVM 可执行的二进制） | `javac` 编译生成 | 反编译工具 | JVM 执行程序 |

**简单比喻：**
- `.java` 文件就像是菜谱（人类可读）
- `.class` 文件就像是做好的菜（JVM 可以"吃"）

### 1.4 程序结构（对应所有 .java 文件）

一个标准的 Java 程序结构包含以下几个部分：

```java
package basic_syntax;           // 包声明（对应文件夹路径，可选）
import java.util.Scanner;       // 导入语句（使用其他类时需要）
public class Variables {         // 类声明（必须与文件名一致）
    public static void main(String[] args) {  // 主方法（程序入口）
        // 这里写程序代码
    }
}
```

**各部分说明：**
1. **包声明**：用于组织代码，避免类名冲突，类似于文件夹的作用
2. **导入语句**：引入其他包中的类，方便使用
3. **类声明**：Java 程序的基本单元，所有代码必须放在类里面
4. **主方法**：程序的入口点，JVM 从这里开始执行

---

## 📚 第二部分：基础语法（对应 basic_syntax/）

### 2.1 变量与数据类型（Variables.java）

变量是存储数据的容器，Java 是强类型语言，每个变量必须声明类型。

**Java 的 8 种基本数据类型：**

| 类型 | 关键字 | 大小 | 范围 | 示例 |
| ---- | ------ | ---- | ---- | ---- |
| 字节型 | `byte` | 1字节 | -128 ~ 127 | `byte age = 25;` |
| 短整型 | `short` | 2字节 | -32768 ~ 32767 | `short score = 95;` |
| 整型 | `int` | 4字节 | -21亿 ~ 21亿 | `int count = 100;` |
| 长整型 | `long` | 8字节 | 很大范围 | `long bigNum = 10000000000L;` |
| 单精度浮点 | `float` | 4字节 | 小数 | `float pi = 3.14f;` |
| 双精度浮点 | `double` | 8字节 | 更精确的小数 | `double precisePi = 3.1415926;` |
| 布尔型 | `boolean` | 1字节 | true/false | `boolean flag = true;` |
| 字符型 | `char` | 2字节 | Unicode字符 | `char letter = 'A';` |

```java
// 8种基本数据类型
byte byteValue = 10;      // 字节型，范围 -128 到 127
short shortValue = 100;   // 短整型
int intValue = 1000;      // 整型（最常用）
long longValue = 10000L;  // 长整型，需后缀 L
float floatValue = 3.14f; // 单精度浮点，需后缀 f
double doubleValue = 3.1415926; // 双精度浮点（默认）
boolean boolValue = true; // 布尔值
char charValue = 'A';     // 字符型
String stringValue = "你好 Java"; // 字符串（引用类型）
```

### 2.2 控制流程（ControlFlow.java）

控制流程用于控制程序的执行顺序，包括条件判断和循环。

**1. 条件语句（if-else）**：根据条件执行不同的代码块
**2. 循环语句（for/while）**：重复执行一段代码
**3. 选择语句（switch）**：根据值选择执行路径

```java
// 条件语句 - 根据分数输出等级
int score = 85;
if (score >= 90) {
    System.out.println("优秀");
} else if (score >= 80) {
    System.out.println("良好");
} else if (score >= 60) {
    System.out.println("及格");
} else {
    System.out.println("不及格");
}

// for循环 - 从0到4输出数字
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// while循环 - 计数器方式
int count = 0;
while (count < 3) {
    System.out.println("循环次数: " + count);
    count++;
}

// switch语句（Java 7+支持字符串）
String day = "Monday";
switch (day) {
    case "Monday":
        System.out.println("星期一");
        break;
    case "Friday":
        System.out.println("星期五");
        break;
    default:
        System.out.println("其他日期");
}
```

### 2.3 运算符详解（OperatorsDemo.java）

运算符用于执行各种操作，包括算术、比较、逻辑和位运算。

**算术运算符**：用于数学计算
```java
int a = 10 + 5;   // 加法：15
int b = 10 - 5;   // 减法：5
int c = 10 * 5;   // 乘法：50
int d = 10 / 3;   // 除法：3（整数除法舍去小数）
int e = 10 % 3;   // 取模（余数）：1
```

**比较运算符**：用于比较两个值，返回布尔值
```java
boolean eq = (a == b);  // 等于
boolean ne = (a != b);  // 不等于
boolean gt = (a > b);   // 大于
boolean lt = (a < b);   // 小于
boolean ge = (a >= b);  // 大于等于
boolean le = (a <= b);  // 小于等于
```

**逻辑运算符**：用于组合多个条件
```java
boolean and = (a > 5) && (b < 20);  // 短路与：两个条件都为真
boolean or = (a > 5) || (b < 20);   // 短路或：任一条件为真
boolean not = !(a > 5);              // 非：取反
```

**位运算符**：直接操作二进制位（高级用法）
```java
int bitAnd = 0b1010 & 0b1100;  // 位与：1000（8）
int bitOr = 0b1010 | 0b1100;   // 位或：1110（14）
int bitXor = 0b1010 ^ 0b1100;  // 异或：0110（6）
int leftShift = 1 << 2;        // 左移：4（相当于乘以2的2次方）
int rightShift = 8 >> 2;       // 右移：2（相当于除以2的2次方）
```

### 2.4 字符串操作（StringOperations.java）

字符串是程序中最常用的数据类型之一，Java 提供了丰富的字符串操作方法。

**String 类常用方法：**
```java
String str = "Hello World";

int length = str.length();                    // 获取长度：11
char ch = str.charAt(0);                     // 获取索引0的字符：'H'
String sub = str.substring(0, 5);            // 子串："Hello"
boolean contains = str.contains("World");    // 是否包含：true
String upper = str.toUpperCase();            // 转大写："HELLO WORLD"
String lower = str.toLowerCase();            // 转小写："hello world"
String trimmed = "  abc  ".trim();           // 去除首尾空格："abc"
String[] parts = str.split(" ");             // 按空格分割：["Hello", "World"]
```

**StringBuilder（可变字符串）：**

当需要频繁修改字符串时，推荐使用 StringBuilder，因为 String 是不可变的，每次修改都会创建新对象。

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" ").append("Java");  // 链式调用
String result = sb.toString();  // 转换为String："Hello Java"
```

**字符串格式化：**
```java
String formatted = String.format("姓名：%s，年龄：%d，分数：%.2f", "张三", 25, 95.5);
// 输出："姓名：张三，年龄：25，分数：95.50"
```

### 2.5 类型转换（TypeConversion.java）

Java 中不同类型之间需要进行转换，分为自动转换和强制转换。

**自动类型转换（隐式转换）**：小类型自动转为大类型，不会丢失精度
```java
byte b = 10;
int i = b;          // byte → int（自动转换）
double d = i;       // int → double（自动转换）
```

**强制类型转换（显式转换）**：大类型转小类型，可能丢失精度，需要显式声明
```java
double pi = 3.14159;
int piInt = (int) pi;  // 结果：3（小数部分被截断）

long bigNum = 10000000000L;
int smallNum = (int) bigNum;  // 可能溢出，结果不确定
```

**字符串与数值转换**：
```java
// 字符串转数值
String numStr = "123";
int num = Integer.parseInt(numStr);      // "123" → 123
double numD = Double.parseDouble(numStr); // "123" → 123.0

// 数值转字符串
int value = 456;
String str1 = String.valueOf(value);     // 456 → "456"
String str2 = Integer.toString(value);   // 456 → "456"
```

---

## 🏗️ 第三部分：面向对象编程（对应 object_oriented/）

### 3.1 类与封装（Person.java）

面向对象编程（OOP）的核心概念之一是封装，即将数据和操作数据的方法绑定在一起，并对外部隐藏内部实现。

**封装的好处：**
1. 数据安全性：防止外部直接访问和修改对象的内部状态
2. 代码可维护性：修改内部实现不影响外部使用
3. 代码复用性：可以创建多个对象实例

```java
public class Person implements Cloneable, Serializable {
    // 私有属性（封装）- 外部无法直接访问
    private String name;
    private int age;
    private String[] hobbies;
  
    // 构造方法 - 创建对象时初始化属性
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
  
    // Getter方法 - 获取属性值
    public String getName() { return name; }
    public int getAge() { return age; }
  
    // Setter方法 - 设置属性值（可以添加验证逻辑）
    public void setName(String name) { 
        if (name != null && !name.isEmpty()) {
            this.name = name; 
        }
    }
    public void setAge(int age) { 
        if (age >= 0 && age <= 150) {
            this.age = age; 
        }
    }
  
    // 浅拷贝（使用clone方法）
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
  
    // 深拷贝（手动实现）
    public Person deepCopy() {
        Person copy = new Person(this.name, this.age);
        // 对引用类型进行单独复制
        if (this.hobbies != null) {
            copy.hobbies = this.hobbies.clone();
        }
        return copy;
    }
}
```

### 3.2 继承与多态（Student.java）

**继承**：子类可以继承父类的属性和方法，实现代码复用。

**多态**：同一个方法调用可以有不同的行为表现，取决于调用的对象类型。

```java
// Student类继承Person类
public class Student extends Person {
    // 子类特有属性
    private String school;
  
    // 构造方法：先调用父类构造方法
    public Student(String name, int age, String school) {
        super(name, age);  // 调用父类构造方法
        this.school = school;
    }
  
    // 方法重写（多态的体现）
    @Override
    public void introduce() {
        System.out.println("我叫" + getName() + "，在" + school + "上学");
    }
  
    // 子类特有方法
    public void study() {
        System.out.println("正在学习");
    }
}

// 多态示例
Person p = new Student("李四", 18, "清华大学");
p.introduce();  // 调用子类的introduce方法，输出："我叫李四，在清华大学上学"
```

### 3.3 深拷贝工具类（DeepCopyUtil.java）

对象复制分为浅拷贝和深拷贝：

**浅拷贝**：只复制对象本身，对象内部的引用类型仍然共享同一个实例
**深拷贝**：不仅复制对象本身，还递归复制所有引用类型的成员

```java
public class DeepCopyUtil {
    // 使用序列化实现深拷贝
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepCopy(T obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
          
            // 序列化对象：将对象转为字节流
            oos.writeObject(obj);
          
            // 反序列化：从字节流重建对象（产生新的对象实例）
            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                return (T) ois.readObject();
            }
        } catch (Exception e) {
            throw new RuntimeException("深拷贝失败", e);
        }
    }
}
```

### 3.4 内部类（InnerClassesDemo.java）

内部类是定义在另一个类内部的类，分为四种类型：

**1. 成员内部类**：定义在类的成员位置，可以访问外部类的所有成员
```java
class MemberInnerClass {
    public void show() {
        System.out.println(outerField);  // 可以访问外部类字段
    }
}
```

**2. 静态内部类**：使用 static 修饰，不依赖外部类实例
```java
static class StaticInnerClass {
    public void show() {
        System.out.println("静态内部类");
    }
}
```

**3. 局部内部类**：定义在方法内部，只能在该方法内使用
```java
public void methodWithLocalClass() {
    class LocalInnerClass {
        public void show() {
            System.out.println("局部内部类");
        }
    }
    LocalInnerClass local = new LocalInnerClass();
    local.show();
}
```

**4. 匿名类**：没有类名，一次性使用，常用于实现接口或继承类
```java
public void methodWithAnonymousClass() {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("匿名类实现");
        }
    };
    r.run();
}
```

### 3.5 接口与抽象类详解（InterfaceDetailsDemo.java）

**抽象类**：包含抽象方法（没有实现的方法），不能直接实例化，用于被继承
```java
abstract class Animal {
    public abstract void makeSound();  // 抽象方法（必须被子类实现）
  
    public void eat() {  // 具体方法（可以有实现）
        System.out.println("动物在吃东西");
    }
}
```

**接口**：定义一组方法规范，Java 8+ 可以有默认方法和静态方法
```java
interface Flyable {
    void fly();  // 抽象方法（默认 public abstract）
  
    default void land() {  // 默认方法（有实现）
        System.out.println("降落");
    }
  
    static void info() {  // 静态方法
        System.out.println("这是飞行接口");
    }
}
```

**区别对比：**

| 特性 | 抽象类 | 接口 |
| ---- | ------ | ---- |
| 继承 | 只能继承一个 | 可以实现多个 |
| 方法 | 抽象方法 + 具体方法 | 抽象方法 + 默认方法 + 静态方法 |
| 构造方法 | 可以有 | 不能有 |
| 成员变量 | 可以有实例变量 | 只能有常量（public static final） |

```java
// 类可以继承一个抽象类，实现多个接口
class Duck extends Animal implements Flyable, Swimmable {
    @Override
    public void makeSound() {
        System.out.println("嘎嘎嘎");
    }
  
    @Override
    public void fly() {
        System.out.println("鸭子在飞");
    }
  
    @Override
    public void swim() {
        System.out.println("鸭子在游泳");
    }
}
```

---

## 📊 第四部分：数据结构（对应 data_structures/）

### 4.1 数组操作（ArraysDemo.java）

数组是最基本的数据结构，用于存储相同类型的元素集合。

**数组特点：**
- 固定长度：创建时指定大小，不可改变
- 连续存储：元素在内存中连续存放，访问速度快
- 索引访问：通过索引（从0开始）访问元素

```java
// 数组声明方式
int[] arr1 = new int[5];           // 声明长度为5的数组（默认值0）
int[] arr2 = {1, 2, 3, 4, 5};     // 声明并初始化

// 访问数组元素
int first = arr2[0];  // 获取第一个元素：1
arr2[1] = 10;         // 修改第二个元素为10

// 获取数组长度
int length = arr2.length;  // 5

// 遍历数组（三种方式）
// 方式1：普通for循环
for (int i = 0; i < arr2.length; i++) {
    System.out.println(arr2[i]);
}

// 方式2：增强for循环（foreach）
for (int num : arr2) {
    System.out.println(num);
}

// 方式3：Arrays工具类
Arrays.sort(arr2);  // 排序
int[] copy = Arrays.copyOf(arr2, arr2.length);  // 复制

// 二维数组
int[][] matrix = {{1, 2}, {3, 4}};
int value = matrix[0][1];  // 获取第一行第二列：2
```

### 4.2 集合框架（CollectionDemo.java）

Java 集合框架提供了多种数据结构实现，主要分为三大类：

**List（有序可重复）**：保持元素的插入顺序，允许重复元素
```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple");  // 允许重复
String first = list.get(0);  // 获取第一个元素
```

**Set（无序不可重复）**：不允许重复元素，不保证顺序
```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");  // 重复元素被忽略
```

**Map（键值对）**：存储键值对，键唯一，值可以重复
```java
Map<String, Integer> map = new HashMap<>();
map.put("Apple", 10);
map.put("Banana", 20);
int value = map.get("Apple");  // 根据键获取值：10
```

### 4.3 队列与栈（QueueStackDemo.java）

**队列（Queue）**：先进先出（FIFO），像排队一样
```java
Queue<String> queue = new LinkedList<>();
queue.offer("A");  // 入队
queue.offer("B");
String front = queue.poll();  // 出队（返回并移除）：A
String peek = queue.peek();   // 查看队首（不移除）：B
```

**栈（Stack）**：后进先出（LIFO），像叠盘子一样
```java
Stack<Integer> stack = new Stack<>();
stack.push(1);  // 入栈
stack.push(2);
int top = stack.pop();   // 出栈（返回并移除）：2
int peekTop = stack.peek();  // 查看栈顶：1
```

**Deque（双端队列）**：可以从两端添加或移除元素，非常灵活
```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("A");   // 队首添加
deque.addLast("B");    // 队尾添加
deque.removeFirst();   // 队首移除
deque.removeLast();    // 队尾移除
```

### 4.4 Map详解（MapDetailsDemo.java）

Map 有多种实现，每种都有不同的特点：

**HashMap**：基于哈希表实现，无序，查找速度快（O(1)）
```java
Map<String, String> hashMap = new HashMap<>();
hashMap.put("name", "张三");
hashMap.put("age", "25");
```

**LinkedHashMap**：保持插入顺序，遍历时按插入顺序输出
```java
Map<String, String> linkedHashMap = new LinkedHashMap<>();
linkedHashMap.put("first", "A");
linkedHashMap.put("second", "B");
// 遍历顺序：A -> B（插入顺序）
```

**TreeMap**：按键的自然顺序排序（如字母顺序）
```java
Map<String, Integer> treeMap = new TreeMap<>();
treeMap.put("Banana", 20);
treeMap.put("Apple", 10);
// 遍历顺序：Apple -> Banana（字母顺序）
```

**遍历Map的方式：**
```java
// 方式1：遍历Entry
for (Map.Entry<String, String> entry : hashMap.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// 方式2：使用Lambda
hashMap.forEach((key, value) -> System.out.println(key + ": " + value));
```

### 4.5 ArrayList详解（ArrayListDemo.java）

ArrayList 是 Java 中最常用的动态数组，类似 C++ 的 vector。

**ArrayList vs C++ vector 对比：**
| C++ vector | Java ArrayList | 说明 |
|------------|----------------|------|
| `push_back(x)` | `add(x)` | 末尾添加 |
| `pop_back()` | `remove(size()-1)` | 末尾删除 |
| `size()` | `size()` | 获取大小 |
| `operator[]` | `get(i)` / `set(i, v)` | 随机访问 |
| `reserve(n)` | `ensureCapacity(n)` | 预分配容量 |
| `shrink_to_fit()` | `trimToSize()` | 缩容 |

**容量管理：**
```java
ArrayList<Integer> list = new ArrayList<>();
list.ensureCapacity(100);  // 预分配100个元素的容量，避免多次扩容
list.trimToSize();          // 缩容至实际大小，释放多余内存
```

**多种遍历方式：**
```java
// 方式1：普通for（最快，O(1)随机访问）
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

// 方式2：增强for
for (String item : list) {
    System.out.println(item);
}

// 方式3：Iterator（可安全删除）
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    // 可以安全调用 it.remove()
}

// 方式4：ListIterator（支持双向遍历）
ListIterator<String> lit = list.listIterator(list.size());
while (lit.hasPrevious()) {
    System.out.println(lit.previous());
}

// 方式5：Lambda
list.forEach(item -> System.out.println(item));
```

**排序与二分查找：**
```java
ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(85, 92, 76, 88));

Collections.sort(scores);                          // 升序
Collections.sort(scores, Collections.reverseOrder()); // 降序

// 二分查找（必须先排序）
int idx = Collections.binarySearch(scores, 88);
```

**与数组互转：**
```java
// ArrayList → 数组
String[] arr = list.toArray(new String[0]);

// 数组 → ArrayList
String[] names = {"张三", "李四", "王五"};
ArrayList<String> fromArray = new ArrayList<>(Arrays.asList(names));
```

**性能特征：**
- 底层：`Object[]` 动态数组（连续内存）
- 随机访问：O(1)
- 末尾添加：O(1) 均摊
- 中间插入/删除：O(n)（需移动元素）
- 扩容策略：默认 ×1.5

**注意事项：**
- 需要频繁随机访问 → 选 ArrayList
- 频繁头/中插入删除 → 选 LinkedList
- `Arrays.asList()` 返回固定大小视图，不能 `add/remove`

### 4.6 二叉树（BinaryTreeDemo.java）

Java 标准库没有直接提供通用二叉树类，需要手动实现。

**树的基本概念：**
```
         ①          ← 根节点 (root)
       /   \
      ②     ③       ← 内部节点
     / \   / \
    ④  ⑤ ⑥  ⑦     ← 叶子节点 (leaf)
```

**四种遍历方式：**
```java
// 前序遍历：根→左→右（用于复制树/序列化）
// 中序遍历：左→根→右（BST的中序 = 升序排列!）
// 后序遍历：左→右→根（用于删除树/计算目录大小）
// 层序遍历：一层一层（用于BFS/最短路径）
```

**二叉搜索树（BST）操作：**
```java
BinarySearchTree bst = new BinarySearchTree();
bst.insert(5);   // 插入
bst.insert(3);
bst.insert(8);

bst.search(4);   // 查找
bst.findMin();   // 最小值
bst.findMax();   // 最大值
bst.delete(3);   // 删除
```

**BST 特性：**
- 左子树所有节点 < 根节点
- 右子树所有节点 > 根节点
- 中序遍历结果是升序序列

**从遍历序列重建二叉树：**
```java
// 已知前序和中序，可以唯一确定一棵二叉树
int[] preorder = {3, 9, 20, 15, 7};
int[] inorder  = {9, 3, 15, 20, 7};
TreeNode root = buildTreeFromPreIn(preorder, inorder);
```

**注意事项：**
- Java 标准库的 TreeSet/TreeMap 底层是红黑树，但不暴露节点结构
- 二叉树相关算法是面试高频考点

### 4.7 图（GraphDemo.java）

Java 标准库没有直接提供通用图类，需要手动实现。

**图的两种表示方式：**
```java
// 1. 邻接表（常用，省空间 O(V+E)）
Map<Integer, List<Integer>> adjList = new HashMap<>();
adjList.put(0, Arrays.asList(1, 2));  // 节点0连接到1和2

// 2. 邻接矩阵（适合稠密图）
int[][] matrix = new int[n][n];
matrix[0][1] = 1;  // 节点0到节点1有边
```

**图的遍历：**
```java
// DFS（深度优先搜索）— 用栈或递归
// 用途：路径查找、连通分量、拓扑排序、找环

// BFS（广度优先搜索）— 用队列
// 用途：最短路径（无权图）、社交网络中的"N度人脉"
```

**拓扑排序（DAG）：**
```java
// 有向无环图的拓扑排序
// 每条边 u→v 中，u 一定排在 v 前面
// 应用：课程依赖、构建系统（make）、任务调度
```

**Dijkstra 最短路径：**
```java
// 加权图的最短路径算法
// 适用于边权重非负的图
```

**注意事项：**
- 实际项目中通常使用第三方库（如 JGraphT、Guava Graph）
- 图算法是算法面试的重点内容

---

## ⚠️ 第五部分：异常处理（对应 exception_handling/）

### 5.1 try-catch-finally基础（ExceptionDemo.java）

异常处理是处理程序运行时错误的机制，使用 try-catch-finally 结构。

**try块**：包含可能抛出异常的代码
**catch块**：捕获并处理异常
**finally块**：无论是否发生异常都会执行，用于资源清理

```java
try {
    // 可能抛出异常的代码
    int result = 10 / 0;  // 这里会抛出 ArithmeticException
} catch (ArithmeticException e) {
    // 捕获特定异常
    System.out.println("捕获到算术异常: " + e.getMessage());
} catch (Exception e) {
    // 捕获其他异常（父类异常要放在后面）
    System.out.println("捕获到异常: " + e.getMessage());
} finally {
    // 无论是否发生异常都会执行
    System.out.println("finally块执行");
}
```

**抛出异常**：主动抛出异常
```java
public void validateAge(int age) throws IllegalArgumentException {
    if (age < 0 || age > 150) {
        throw new IllegalArgumentException("年龄无效: " + age);
    }
}
```

### 5.2 自定义异常与try-with-resources（ExceptionDetailsDemo.java）

**自定义异常**：创建自己的异常类，用于特定场景

```java
// 自定义检查异常（继承Exception，必须声明或捕获）
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// 自定义运行时异常（继承RuntimeException，无需声明）
class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}
```

**try-with-resources**：自动关闭实现了 AutoCloseable 接口的资源
```java
// 无需手动关闭 reader 和 writer，自动关闭
try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
     BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
  
    String line;
    while ((line = reader.readLine()) != null) {
        writer.write(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

**异常链**：保留原始异常信息
```java
try {
    riskyOperation();
} catch (SQLException e) {
    // 包装原始异常，保留堆栈信息
    throw new RuntimeException("数据库操作失败", e);
}
```

---

## 📁 第六部分：IO操作（对应 io_operations/）

### 6.1 文件读写基础（FileDemo.java）

Java 的 IO 操作分为字节流和字符流：
- **字节流**：用于处理二进制数据（如图片、视频）
- **字符流**：用于处理文本数据（如 .txt 文件）

**文件创建与删除：**
```java
File file = new File("test.txt");
if (!file.exists()) {
    boolean created = file.createNewFile();  // 创建文件
}
boolean deleted = file.delete();  // 删除文件
```

**字符流写入：**
```java
try (FileWriter writer = new FileWriter("test.txt")) {
    writer.write("Hello World!\n");
    writer.write("你好，Java！");
} catch (IOException e) {
    e.printStackTrace();
}
```

**字符流读取：**
```java
try (FileReader reader = new FileReader("test.txt")) {
    char[] buffer = new char[1024];
    int length = reader.read(buffer);
    System.out.println("读取内容: " + new String(buffer, 0, length));
} catch (IOException e) {
    e.printStackTrace();
}
```

### 6.2 NIO与序列化（NioSerializationDemo.java）

**NIO（New IO）**：Java 7+ 引入的新 IO API，更高效
```java
Path path = Paths.get("test_nio.txt");

// 写入文件
String content = "NIO 文件操作";
Files.write(path, content.getBytes(StandardCharsets.UTF_8));

// 读取文件
byte[] bytes = Files.readAllBytes(path);
String readContent = new String(bytes, StandardCharsets.UTF_8);

// 文件复制
Files.copy(path, Paths.get("test_copy.txt"), StandardCopyOption.REPLACE_EXISTING);
```

**对象序列化**：将对象转换为字节流，便于存储或传输
```java
// 序列化对象
Person person = new Person("张三", 25);
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
    oos.writeObject(person);
}

// 反序列化对象
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
    Person restored = (Person) ois.readObject();
}
```

---

## 🌟 第七部分：高级语法（对应 advanced_syntax/）

### 7.1 泛型（GenericsDemo.java）

泛型允许在定义类、接口和方法时使用类型参数，提高代码的类型安全性和复用性。

**泛型类**：
```java
class Box<T> {
    private T content;
  
    public void set(T content) {
        this.content = content;
    }
  
    public T get() {
        return content;
    }
}

// 使用
Box<String> stringBox = new Box<>();
stringBox.set("Hello");
String value = stringBox.get();
```

**泛型方法**：
```java
public static <T> void printList(List<T> list) {
    for (T item : list) {
        System.out.println(item);
    }
}
```

**有界泛型**：限制类型参数的范围
```java
public static <T extends Number> double sum(List<T> numbers) {
    double total = 0;
    for (T num : numbers) {
        total += num.doubleValue();
    }
    return total;
}
```

**通配符**：
```java
public static void processList(List<?> list) {
    // 可以读取，但不能写入（除了null）
}
```

### 7.2 Lambda表达式（LambdaDemo.java）

Lambda 表达式是 Java 8 引入的函数式编程特性，可以简化代码。

**语法**：`(参数) -> 表达式/代码块`

```java
// 无参数
Runnable r = () -> System.out.println("Hello Lambda");

// 带参数
Comparator<Integer> comparator = (a, b) -> a - b;

// 多条语句
Callable<Integer> task = () -> {
    int sum = 0;
    for (int i = 0; i <= 100; i++) {
        sum += i;
    }
    return sum;
};
```

**方法引用**：简化 Lambda 表达式
```java
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(System.out::println);  // 等价于 s -> System.out.println(s)

// 构造方法引用
Supplier<StringBuilder> sbSupplier = StringBuilder::new;

// 实例方法引用
String str = "Hello";
Supplier<Integer> lengthSupplier = str::length;
```

### 7.3 Stream API（StreamDemo.java）

Stream API 提供了一种声明式处理集合的方式，支持过滤、映射、聚合等操作。

**基本操作：**
```java
List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");

// 过滤 + 映射 + 收集
List<String> result = fruits.stream()
    .filter(s -> s.startsWith("a"))          // 过滤：以a开头
    .map(String::toUpperCase)                // 映射：转大写
    .collect(Collectors.toList());           // 收集：转为List
```

**聚合操作：**
```java
long count = fruits.stream().count();  // 计数
String joined = fruits.stream().collect(Collectors.joining(", "));  // 拼接
Optional<String> first = fruits.stream().findFirst();  // 第一个元素
```

**数值流：**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream().mapToInt(Integer::intValue).sum();  // 求和
double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);  // 平均值
```

**并行流：**
```java
int parallelSum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
```

### 7.4 枚举（EnumDemo.java）

枚举是一种特殊的类，用于定义固定数量的常量。

**简单枚举：**
```java
enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

**带构造方法和属性的枚举：**
```java
enum WeekdayWithName {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
  
    private String chineseName;
  
    private WeekdayWithName(String chineseName) {
        this.chineseName = chineseName;
    }
  
    public String getChineseName() {
        return chineseName;
    }
}
```

**使用枚举：**
```java
Weekday today = Weekday.MONDAY;

// switch语句中使用
switch (today) {
    case MONDAY:
        System.out.println("星期一");
        break;
}

// 遍历枚举
for (Weekday day : Weekday.values()) {
    System.out.println(day);
}
```

---

## 🏛️ 第八部分：高级面向对象（对应 advanced_oop/）

### 8.1 抽象类与接口（AbstractInterfaceDemo.java）

**抽象类 vs 接口对比：**

| 特性 | 抽象类 | 接口 |
| ---- | ------ | ---- |
| 继承限制 | 只能单继承 | 可以多实现 |
| 构造方法 | 有 | 无 |
| 成员变量 | 可以有实例变量 | 只能是常量 |
| 方法类型 | 抽象方法 + 具体方法 | 抽象方法 + 默认方法 + 静态方法 |
| 使用场景 | 表示"is-a"关系 | 表示"can-do"关系 |

```java
abstract class Animal {
    protected String name;
  
    public Animal(String name) {
        this.name = name;
    }
  
    public abstract void makeSound();
  
    public void eat() {
        System.out.println(name + "在吃东西");
    }
}

interface Flyable {
    void fly();
  
    default void land() {
        System.out.println("降落");
    }
}

class Bird extends Animal implements Flyable {
    public Bird(String name) {
        super(name);
    }
  
    @Override
    public void makeSound() {
        System.out.println("啾啾啾");
    }
  
    @Override
    public void fly() {
        System.out.println(name + "在飞");
    }
}
```

### 8.2 单例模式（SingletonDemo.java）

单例模式确保一个类只有一个实例，并提供全局访问点。

**饿汉式单例**：类加载时就创建实例，线程安全
```java
class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();
  
    private EagerSingleton() {}  // 私有构造方法
  
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
```

**懒汉式单例**：延迟加载，需要双重检查保证线程安全
```java
class LazySingleton {
    private static volatile LazySingleton instance;
  
    private LazySingleton() {}
  
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
```

**枚举单例**：最简单、最安全的实现方式
```java
enum EnumSingleton {
    INSTANCE;
  
    public void doSomething() {
        System.out.println("枚举单例");
    }
}
```

### 8.3 工厂模式（FactoryPatternDemo.java）

工厂模式用于创建对象，将对象创建逻辑封装起来。

**简单工厂模式**：
```java
// 产品接口
interface Product {
    void use();
}

// 具体产品A
class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("使用产品A");
    }
}

// 具体产品B
class ProductB implements Product {
    @Override
    public void use() {
        System.out.println("使用产品B");
    }
}

// 工厂类
class ProductFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                throw new IllegalArgumentException("未知产品类型: " + type);
        }
    }
}

// 使用
Product productA = ProductFactory.createProduct("A");
productA.use();  // 输出：使用产品A
```

---

## 🔄 第九部分：并发编程（对应 concurrency/）

### 9.1 多线程基础（ThreadDemo.java）

多线程允许程序同时执行多个任务，提高程序效率。

**创建线程的三种方式：**

**方式1：继承Thread类**
```java
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(100);  // 暂停100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

**方式2：实现Runnable接口**
```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable: " + i);
        }
    }
}
```

**方式3：使用Lambda表达式**
```java
new Thread(() -> {
    System.out.println("Lambda线程");
}).start();
```

**启动线程：**
```java
MyThread thread1 = new MyThread();
thread1.start();  // 启动线程

Thread thread2 = new Thread(new MyRunnable());
thread2.start();
```

### 9.2 线程池（ThreadPoolDemo.java）

线程池管理一组线程，避免频繁创建和销毁线程的开销。

```java
// 创建固定大小的线程池
ExecutorService executor = Executors.newFixedThreadPool(3);

// 提交任务
executor.submit(() -> {
    System.out.println("任务1执行");
});

executor.submit(() -> {
    System.out.println("任务2执行");
});

// 关闭线程池
executor.shutdown();  // 优雅关闭，等待任务完成
```

**常见线程池类型：**
```java
ExecutorService cachedPool = Executors.newCachedThreadPool();  // 缓存线程池（自动扩容）
ExecutorService singlePool = Executors.newSingleThreadExecutor();  // 单线程池
ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(3);  // 定时任务池
```

**定时任务：**
```java
scheduledPool.schedule(() -> {
    System.out.println("延迟5秒执行");
}, 5, TimeUnit.SECONDS);

scheduledPool.scheduleAtFixedRate(() -> {
    System.out.println("每3秒执行一次");
}, 1, 3, TimeUnit.SECONDS);
```

### 9.3 同步机制（SynchronizationDemo.java）

多线程环境下，多个线程同时访问共享资源可能导致数据不一致，需要同步机制。

**synchronized方法：**
```java
class Counter {
    private int count = 0;
  
    public synchronized void increment() {
        count++;
    }
  
    public synchronized void decrement() {
        count--;
    }
}
```

**synchronized块（更细粒度的同步）：**
```java
public void update() {
    synchronized (this) {
        // 需要同步的代码
    }
}
```

**使用示例：**
```java
Counter counter = new Counter();
ExecutorService executor = Executors.newFixedThreadPool(10);

for (int i = 0; i < 1000; i++) {
    executor.submit(counter::increment);
}

executor.shutdown();
executor.awaitTermination(1, TimeUnit.MINUTES);

System.out.println("最终计数: " + counter.getCount());  // 应该是1000
```

### 9.4 Callable与Future（CallableFutureDemo.java）

Callable 是带返回值的任务，Future 用于获取异步任务的结果。

```java
class SumTask implements Callable<Integer> {
    private int start;
    private int end;
  
    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }
  
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}

// 使用
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(new SumTask(1, 100));

// 获取结果（阻塞等待）
Integer result = future.get();
System.out.println("1到100的和: " + result);

executor.shutdown();
```

### 9.5 CompletableFuture（CompletableFutureDemo.java）

CompletableFuture 是 Java 8+ 引入的异步编程工具，支持链式调用和组合操作。

```java
// 创建异步任务
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return "Hello";
});

// 链式调用
future.thenApply(str -> str + " World")
      .thenAccept(result -> System.out.println("结果: " + result))
      .exceptionally(e -> {
          System.out.println("异常: " + e.getMessage());
          return null;
      });

// 组合多个任务
CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> s1 + " " + s2);
String result = combined.get();  // 结果：Hello World
```

---

## 🧠 第十部分：JVM原理（对应 jvm/）

### 10.1 JVM内存模型（JVMMemoryDemo.java）

JVM 内存分为多个区域，每个区域有不同的用途：

```
┌─────────────────────────────────────────────────────────────┐
│                        JVM内存                              │
├─────────────────────────────────────────────────────────────┤
│  方法区（Method Area）                                       │
│  - 类信息、常量池、静态变量、运行时常量池                      │
│  - 被所有线程共享                                            │
├─────────────────────────────────────────────────────────────┤
│  堆（Heap）                                                  │
│  - 对象实例、数组                                             │
│  - 垃圾回收主要区域                                           │
│  - 被所有线程共享                                            │
│  ├─ 新生代：Eden + Survivor（From/To）                        │
│  └─ 老年代                                                  │
├─────────────────────────────────────────────────────────────┤
│  栈（Stack）                                                 │
│  - 方法调用栈                                                │
│  - 局部变量、方法参数、返回值                                   │
│  - 每个线程独有                                              │
│  - 栈帧（Stack Frame）：每个方法调用对应一个栈帧                 │
├─────────────────────────────────────────────────────────────┤
│  本地方法栈（Native Method Stack）                            │
│  - 本地方法（JNI）调用                                        │
│  - 每个线程独有                                              │
├─────────────────────────────────────────────────────────────┤
│  程序计数器（PC Register）                                     │
│  - 当前线程执行位置（字节码指令地址）                           │
│  - 每个线程独有                                              │
└─────────────────────────────────────────────────────────────┘
```

```java
public class JVMMemoryDemo {
    // 静态变量（存储在方法区）
    private static String staticField = "静态变量";
  
    public static void main(String[] args) {
        // 局部变量（存储在栈中）
        int localVariable = 10;
      
        // 对象实例（存储在堆中）
        Person person = new Person("张三", 25);
      
        // 方法调用（栈帧）
        method1();
    }
  
    private static void method1() {
        String param = "参数";
        method2(param);
    }
  
    private static void method2(String param) {
        System.out.println(param);
    }
}
```

### 10.2 垃圾回收（GarbageCollectionDemo.java）

垃圾回收（GC）自动回收不再使用的对象，释放内存。

```java
public class GarbageCollectionDemo {
  
    static class MyObject {
        @Override
        protected void finalize() throws Throwable {
            // 对象被回收前调用（不推荐使用）
            System.out.println("对象被回收: " + this);
        }
    }
  
    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
      
        // 置为null，成为垃圾
        obj1 = null;
        obj2 = null;
      
        // 提示垃圾回收（不保证立即执行）
        System.gc();
    }
}
```

**常见垃圾收集器：**
- **Serial GC**：单线程，适合小型应用
- **Parallel GC**：多线程，吞吐量优先（默认）
- **CMS GC**：并发标记清除，响应时间优先
- **G1 GC**：区域化分代，兼顾吞吐量和响应时间
- **ZGC/Shenandoah**：低延迟垃圾收集器

### 10.3 类加载机制（ClassLoaderDemo.java）

类加载器负责将类的字节码加载到 JVM 中。

**类加载过程：**
1. **加载**：读取字节码文件
2. **验证**：检查字节码的正确性
3. **准备**：为静态变量分配内存并设置默认值
4. **解析**：将符号引用转换为直接引用
5. **初始化**：执行静态初始化器和静态变量赋值

**类加载器层次：**
```java
public class ClassLoaderDemo {
  
    public static void main(String[] args) {
        // 获取类加载器
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println("类加载器: " + classLoader);  // Application ClassLoader
      
        // 获取父类加载器
        ClassLoader parentLoader = classLoader.getParent();
        System.out.println("父类加载器: " + parentLoader);  // Extension ClassLoader
      
        // 获取启动类加载器（通常为null）
        ClassLoader bootstrapLoader = parentLoader.getParent();
        System.out.println("启动类加载器: " + bootstrapLoader);  // null（C++实现）
    }
}
```

---

## 🌐 第十一部分：网络编程（对应 network/）

### 11.1 Socket编程（SocketServer.java / SocketClient.java）

Socket 是网络通信的基础，实现客户端-服务器模式。

**服务器端：**
```java
public class SocketServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器Socket，监听端口8888
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器启动，等待客户端连接...");
      
        // 接受客户端连接
        Socket client = server.accept();
        System.out.println("客户端连接成功: " + client.getInetAddress());
      
        // 获取输入流（接收客户端消息）
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
      
        // 获取输出流（发送消息给客户端）
        PrintWriter writer = new PrintWriter(
            new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8), true);
      
        // 读取客户端消息
        String message = reader.readLine();
        System.out.println("收到客户端消息: " + message);
      
        // 发送响应
        writer.println("收到消息: " + message);
      
        // 关闭资源
        reader.close();
        writer.close();
        client.close();
        server.close();
    }
}
```

**客户端：**
```java
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 连接服务器
        Socket socket = new Socket("localhost", 8888);
        System.out.println("连接服务器成功");
      
        // 获取输出流（发送消息给服务器）
        PrintWriter writer = new PrintWriter(
            new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
      
        // 获取输入流（接收服务器响应）
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
      
        // 发送消息
        writer.println("Hello Server!");
      
        // 接收响应
        String response = reader.readLine();
        System.out.println("收到服务器响应: " + response);
      
        // 关闭资源
        writer.close();
        reader.close();
        socket.close();
    }
}
```

### 11.2 HTTP客户端（HttpClientDemo.java）

Java 11+ 提供了内置的 HttpClient，用于发送 HTTP 请求。

```java
public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        // 创建HttpClient
        HttpClient client = HttpClient.newHttpClient();
      
        // 创建GET请求
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.example.com/data"))
            .header("Content-Type", "application/json")
            .GET()
            .build();
      
        // 发送请求并获取响应
        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());
      
        System.out.println("状态码: " + response.statusCode());
        System.out.println("响应体: " + response.body());
      
        // POST请求
        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://api.example.com/submit"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"张三\"}"))
            .build();
      
        HttpResponse<String> postResponse = client.send(postRequest,
            HttpResponse.BodyHandlers.ofString());
        System.out.println("POST响应: " + postResponse.body());
    }
}
```

---

## 🗄️ 第十二部分：数据库操作（对应 database/）

### 12.1 JDBC基础（JdbcDemo.java）

JDBC（Java Database Connectivity）是 Java 访问数据库的标准接口。

**JDBC操作步骤：**
1. 建立连接
2. 创建 Statement/PreparedStatement
3. 执行SQL
4. 处理结果
5. 关闭资源

**实际代码使用 SQLite（无需额外安装数据库）：**
```java
public class JdbcDemo {
    // SQLite连接（无需用户名密码，直接创建本地文件）
    private static final String URL = "jdbc:sqlite:example.db";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 建立连接（SQLite不需要显式注册驱动）
            conn = DriverManager.getConnection(URL);
            System.out.println("数据库连接成功");

            // 创建表（SQLite使用AUTOINCREMENT，MySQL使用AUTO_INCREMENT）
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)";
            conn.createStatement().execute(createTableSQL);

            // 插入数据（使用PreparedStatement防止SQL注入）
            String insertSQL = "INSERT INTO users (name, age) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, "张三");
            pstmt.setInt(2, 25);
            pstmt.executeUpdate();

            // 查询数据
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Age: " + rs.getInt("age"));
            }

            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

**SQLite vs MySQL 差异：**
| 特性 | SQLite | MySQL |
|------|--------|-------|
| 连接URL | `jdbc:sqlite:文件名` | `jdbc:mysql://主机:端口/数据库` |
| 用户名密码 | 不需要 | 需要 |
| 自增主键 | `AUTOINCREMENT` | `AUTO_INCREMENT` |
| 驱动注册 | 不需要 | `Class.forName("com.mysql.cj.jdbc.Driver")` |

**注意事项：**
- 本示例使用 SQLite，无需安装额外数据库
- 实际项目中推荐使用连接池（如 HikariCP）
- 务必使用 `try-with-resources` 或 `finally` 块关闭资源

---

## 🏗️ 第十三部分：框架入门（对应 frameworks/）

### 13.1 Spring IOC/DI（SpringDemo.java）

Spring 框架的核心是 **IOC（控制反转）** 和 **DI（依赖注入）**。

**核心概念：**
- **IOC**：对象的创建和管理由 Spring 容器负责，而不是程序员手动 `new`
- **DI**：容器自动将依赖的对象注入到需要的地方

**实际代码使用 Java 配置方式：**
```java
public class SpringDemo {

    // 配置类：告诉 Spring 如何创建 Bean
    @Configuration
    public static class AppConfig {

        @Bean
        public MessageService messageService() {
            return new MessageServiceImpl();
        }

        @Bean
        public MessagePrinter messagePrinter() {
            return new MessagePrinter(messageService());
        }
    }

    // 服务接口
    public interface MessageService {
        String getMessage();
    }

    // 服务实现
    public static class MessageServiceImpl implements MessageService {
        @Override
        public String getMessage() {
            return "Hello Spring!";
        }
    }

    // 消费者：通过构造方法注入依赖
    public static class MessagePrinter {
        private final MessageService service;

        public MessagePrinter(MessageService service) {
            this.service = service;
        }

        public void printMessage() {
            System.out.println(service.getMessage());
        }
    }

    public static void main(String[] args) {
        // 创建 Spring 应用上下文
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

        // 从容器获取 Bean
        MessagePrinter printer = context.getBean(MessagePrinter.class);

        // 使用 Bean
        printer.printMessage();

        // 关闭上下文
        context.close();
    }
}
```

**依赖注入的三种方式（扩展知识）：**
```java
// 1. 构造方法注入（推荐）
public class Service {
    private final Dependency dep;
    public Service(Dependency dep) { this.dep = dep; }
}

// 2. Setter 注入
public class Service {
    private Dependency dep;
    public void setDep(Dependency dep) { this.dep = dep; }
}

// 3. 字段注入（使用 @Autowired）
public class Service {
    @Autowired
    private Dependency dep;
}
```

**常用注解（扩展知识）：**
| 注解 | 说明 |
|------|------|
| `@Configuration` | 配置类 |
| `@Bean` | 定义 Bean |
| `@Component` | 通用组件 |
| `@Service` | 服务层 |
| `@Repository` | 数据访问层 |
| `@Controller` | 控制器层 |
| `@Autowired` | 自动注入 |

**注意事项：**
- 本示例使用 `@Configuration` + `@Bean` 的 Java 配置方式
- 实际项目中通常使用 `@Component` + `@Autowired` 的注解方式
- 运行此代码需要添加 Spring 依赖（Maven/Gradle）
- 代码中的类都是静态内部类，这是简化的演示方式

**Maven 依赖：**
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.30</version>
</dependency>
```

---

## 📋 编译运行速查表

| 操作 | 命令 | 对应文件 | 说明 |
|------|------|----------|------|
| 编译单个文件 | `javac -encoding UTF-8 basic_syntax/Variables.java` | 单个 .java | 指定UTF-8编码防止中文乱码 |
| 编译所有文件 | `javac -encoding UTF-8 */*.java -d .` | 所有 .java | `-d .` 表示生成包结构 |
| 运行无包类 | `java hello_world` | hello_world.java | 没有包声明的类直接运行 |
| 运行带包类 | `java basic_syntax.Variables` | basic_syntax/Variables.java | 使用完整类名运行 |
| 编译运行脚本 | `run.bat` | run.bat | 交互式菜单，选择运行不同示例 |
| 查看可视化教程 | 打开 tutorial.html | tutorial.html | 网页版学习指南 |

---

## 🎯 学习路径规划（与代码对应）

### 第1周：基础入门
```
├── hello_world.java         # Hello World入门
├── Variables.java           # 变量与数据类型
└── ControlFlow.java         # 控制流程
```

### 第2周：基础语法进阶
```
├── OperatorsDemo.java       # 运算符详解
├── StringOperations.java    # 字符串操作
└── TypeConversion.java      # 类型转换
```

### 第3周：面向对象基础
```
├── Person.java              # 类与封装
├── Student.java             # 继承与多态
└── DeepCopyUtil.java        # 对象复制
```

### 第4周：面向对象进阶
```
├── InnerClassesDemo.java    # 内部类
└── InterfaceDetailsDemo.java # 接口与抽象类
```

### 第5周：数据结构
```
├── ArraysDemo.java          # 数组
├── ArrayListDemo.java       # ArrayList详解
├── CollectionDemo.java      # 集合框架
├── QueueStackDemo.java      # 队列与栈
├── MapDetailsDemo.java      # Map详解
├── BinaryTreeDemo.java      # 二叉树
└── GraphDemo.java           # 图
```

### 第6周：异常处理与IO
```
├── ExceptionDemo.java       # 异常处理基础
├── ExceptionDetailsDemo.java # 自定义异常
├── FileDemo.java            # 文件操作
└── NioSerializationDemo.java # NIO与序列化
```

### 第7周：高级语法
```
├── GenericsDemo.java        # 泛型
├── LambdaDemo.java          # Lambda表达式
├── StreamDemo.java          # Stream API
└── EnumDemo.java            # 枚举
```

### 第8周：设计模式
```
├── AbstractInterfaceDemo.java # 抽象类与接口
├── SingletonDemo.java       # 单例模式
└── FactoryPatternDemo.java  # 工厂模式
```

### 第9周：并发编程
```
├── ThreadDemo.java          # 多线程基础
├── ThreadPoolDemo.java      # 线程池
├── SynchronizationDemo.java # 同步机制
├── CallableFutureDemo.java  # Callable与Future
└── CompletableFutureDemo.java # CompletableFuture
```

### 第10周：JVM原理
```
├── JVMMemoryDemo.java       # JVM内存模型
├── GarbageCollectionDemo.java # 垃圾回收
└── ClassLoaderDemo.java     # 类加载机制
```

### 第11周：网络编程
```
├── SocketServer.java        # Socket服务器
├── SocketClient.java        # Socket客户端
└── HttpClientDemo.java      # HTTP客户端
```

### 第12周：数据库操作
```
└── JdbcDemo.java            # JDBC基础
```

### 第13周：框架入门
```
└── SpringDemo.java          # Spring IOC/DI
```

---

## 💡 学习建议

1. **循序渐进**：按照学习路径规划逐步学习，不要跳跃
2. **动手实践**：每个代码示例都要亲自编译运行，观察输出
3. **调试思考**：遇到错误不要急于查找答案，先思考可能的原因
4. **扩展练习**：在现有代码基础上添加功能，加深理解
5. **查阅文档**：养成查阅官方文档的习惯（[Java API文档](https://docs.oracle.com/en/java/javase/21/docs/api/)）

---

**祝学习愉快！** 🚀