# 高级语法 (advanced_syntax)

本文件夹包含Java高级语法的示例，涵盖Lambda表达式、Stream API、泛型和枚举。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `LambdaDemo.java` | Lambda表达式示例，演示Java 8函数式编程特性 |
| `StreamDemo.java` | Stream API示例，演示流式数据处理 |
| `GenericsDemo.java` | 泛型示例，演示泛型类、泛型方法和类型通配符 |
| `EnumDemo.java` | 枚举示例，演示枚举类型的定义和使用 |

## Lambda表达式

### 函数式接口

只有一个抽象方法的接口，可以用Lambda表达式简写。

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

// 使用Lambda
Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

System.out.println(add.calculate(1, 2));      // 3
System.out.println(multiply.calculate(3, 4)); // 12
```

### Lambda语法

```java
// 无参数
() -> { statements }

// 单参数（括号可省略）
x -> { statements }
(x) -> { statements }

// 多参数
(x, y) -> { statements }

// 表达式体（单行，无需return）
x -> x * x
(a, b) -> a + b

// 代码块体
x -> {
    int result = x * 2;
    return result;
}
```

### 常用函数式接口

| 接口 | 方法 | 说明 |
|------|------|------|
| `Predicate<T>` | `boolean test(T t)` | 断言/过滤 |
| `Function<T,R>` | `R apply(T t)` | 转换 |
| `Consumer<T>` | `void accept(T t)` | 消费 |
| `Supplier<T>` | `T get()` | 生产 |
| `UnaryOperator<T>` | `T apply(T t)` | 一元操作 |
| `BinaryOperator<T>` | `T apply(T t, T u)` | 二元操作 |

### 方法引用

```java
List<String> names = Arrays.asList("Tom", "Jerry");

// Lambda
names.forEach(name -> System.out.println(name));

// 方法引用
names.forEach(System.out::println);

// 构造器引用
Supplier<ArrayList<String>> listSupplier = ArrayList::new;
```

## Stream API

### Stream操作流程

```
数据源 ──▶ 中间操作 ──▶ 中间操作 ──▶ ... ──▶ 终端操作
(List/Set/Map)   (filter/map/...)      (collect/forEach)
```

### 创建Stream

```java
// 从集合
Stream<String> stream1 = list.stream();
Stream<String> stream2 = list.parallelStream();

// 从数组
IntStream stream3 = Arrays.stream(new int[]{1, 2, 3});

// Stream.of
Stream<String> stream4 = Stream.of("a", "b", "c");

// 无限流
Stream.generate(() -> "item").limit(10);
Stream.iterate(0, n -> n + 2).limit(10);
```

### 中间操作

```java
// filter - 过滤
list.stream()
    .filter(s -> s.length() > 3)
    .collect(Collectors.toList());

// map - 转换
list.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// flatMap - 扁平化
list.stream()
    .flatMap(s -> Stream.of(s.split("")))
    .collect(Collectors.toList());

// distinct - 去重
list.stream().distinct().collect(Collectors.toList());

// sorted - 排序
list.stream()
    .sorted(Comparator.comparing(String::length).reversed())
    .collect(Collectors.toList());

// limit - 限制数量
list.stream().limit(10).collect(Collectors.toList());

// skip - 跳过
list.stream().skip(5).collect(Collectors.toList());
```

### 终端操作

```java
// collect - 收集到集合
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());

// toMap
Map<String, Integer> map = stream.collect(
    Collectors.toMap(s -> s, String::length));

// groupingBy - 分组
Map<String, List<Person>> byCity = people.stream()
    .collect(Collectors.groupingBy(Person::getCity));

// joining - 拼接
String result = stream.collect(Collectors.joining(", "));

// forEach - 遍历
stream.forEach(System.out::println);

// count - 计数
long count = stream.count();

// sum/avg - 求和/平均值 (IntStream等)
int sum = IntStream.of(1, 2, 3).sum();
double avg = IntStream.of(1, 2, 3).average().orElse(0);

// min/max - 最值
Optional<Integer> min = IntStream.of(1, 2, 3).min();

// reduce - 聚合
int product = IntStream.of(1, 2, 3, 4).reduce(1, (a, b) -> a * b);

// anyMatch/allMatch/noneMatch - 匹配
boolean hasEven = IntStream.of(1, 2, 3).anyMatch(n -> n % 2 == 0);

// findFirst/findAny - 查找
Optional<Integer> first = IntStream.of(1, 2, 3).findFirst();
```

## 泛型

### 泛型类

```java
public class Box<T> {
    private T content;
    
    public T getContent() {
        return content;
    }
    
    public void setContent(T content) {
        this.content = content;
    }
}

Box<String> stringBox = new Box<>();
stringBox.setContent("Hello");
String content = stringBox.getContent();
```

### 泛型方法

```java
public static <T> T getFirst(T[] array) {
    if (array == null || array.length == 0) {
        return null;
    }
    return array[0];
}

String first = getFirst(new String[]{"a", "b"});
Integer num = getFirst(new Integer[]{1, 2});
```

### 类型边界

```java
// 上界：T必须是Number或其子类
public class NumberBox<T extends Number> {
    private T value;
    
    public T getValue() {
        return value;
    }
}

// 多个上界
public <T extends Comparable<T> & Serializable> void process(T item) {
    // T必须同时实现Comparable和Serializable
}
```

### 通配符

| 通配符 | 说明 | 用途 |
|--------|------|------|
| `<?>` | 无界通配符 | 只读操作 |
| `<? extends T>` | 上界通配符 | 读取数据 |
| `<? super T>` | 下界通配符 | 写入数据 |

```java
// 上界：只能从集合读取，不能写入
void printAll(List<? extends Number> list) {
    for (Number n : list) {  // OK
        System.out.println(n);
    }
    // list.add(1);  // 编译错误
}

// 下界：可以向集合写入，但不能保证读取类型
void addNumbers(List<? super Integer> list) {
    list.add(1);    // OK
    list.add(2);    // OK
    // Integer n = list.get(0);  // 编译错误，只能用Object接收
}
```

### 泛型擦除

泛型信息只在编译时存在，运行时会被擦除。

```java
List<String> stringList = new ArrayList<>();
List<Integer> intList = new ArrayList<>();

// 运行时类型都是ArrayList
System.out.println(stringList.getClass() == intList.getClass()); // true
```

**类型擦除后的限制**:
- 不能使用`new T()`（需要反射）
- 不能使用`new T[]`
- 不能使用`instanceof T`
- 不能创建泛型数组

## 枚举

### 实际代码示例（EnumDemo.java）

```java
public enum Weekday {
    MONDAY("星期一", 1),
    TUESDAY("星期二", 2),
    WEDNESDAY("星期三", 3),
    THURSDAY("星期四", 4),
    FRIDAY("星期五", 5),
    SATURDAY("星期六", 6),
    SUNDAY("星期日", 7);

    private final String chineseName;
    private final int dayNumber;

    // 枚举构造方法隐式是 private
    Weekday(String chineseName, int dayNumber) {
        this.chineseName = chineseName;
        this.dayNumber = dayNumber;
    }

    public String getChineseName() { return chineseName; }
    public int getDayNumber() { return dayNumber; }

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

// 使用枚举
Weekday today = Weekday.MONDAY;
System.out.println("今天是: " + today.getChineseName());
System.out.println("是周末吗? " + today.isWeekend());

// 遍历枚举
for (Weekday day : Weekday.values()) {
    System.out.println(day.ordinal() + ": " + day.getChineseName());
}
```

**枚举要点：**
- 枚举常量在类加载时就已经创建好，使用时只是引用已存在的实例
- 枚举构造方法隐式是 `private`，不能显式声明为 `public` 或 `protected`
- `ordinal()` 返回枚举常量的序号（从0开始）
- `values()` 返回所有枚举常量的数组

### 基础枚举

```java
public enum Season {
    SPRING,  // 实际上是 Season.SPRING
    SUMMER,
    AUTUMN,
    WINTER
}

Season s = Season.SPRING;
```

### 带属性和方法

```java
public enum Planet {
    MERCURY(3.303e23, 2.4397e6),
    VENUS(4.869e24, 6.0518e6),
    EARTH(5.976e24, 6.371e6);

    private final double mass;    // 质量
    private final double radius;  // 半径

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() { return mass; }
    public double getRadius() { return radius; }
}
```

### 抽象方法（扩展知识）

```java
public enum Operation {
    PLUS {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE {
        public double apply(double x, double y) { return x / y; }
    };

    public abstract double apply(double x, double y);
}
```

### EnumSet和EnumMap（扩展知识）

```java
// EnumSet - 高效存储枚举值
EnumSet<Season> summer = EnumSet.of(Season.SUMMER, Season.AUTUMN);

// EnumMap - 以枚举为键的Map
EnumMap<Season, String> descriptions = new EnumMap<>(Season.class);
descriptions.put(Season.SPRING, "春天");
```

**注意事项：**
- 枚举类型天然适合表示固定常量集合（如星期、月份、状态等）
- 枚举可以有字段、方法、构造方法
- 枚举可以实现接口，但不能继承其他类
- 枚举常量之间比较使用 `==` 即可，无需 `equals()`
