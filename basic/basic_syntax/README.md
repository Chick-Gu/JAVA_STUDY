# 基础语法 (basic_syntax)

本文件夹包含Java基础语法的示例，涵盖变量、数据类型、运算符和控制流。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `Variables.java` | 变量与数据类型示例，演示Java的8种基本数据类型 |
| `TypeConversion.java` | 类型转换示例，演示自动转换和强制转换 |
| `StringOperations.java` | 字符串操作示例，演示String的常用方法 |
| `OperatorsDemo.java` | 运算符示例，演示算术、关系、逻辑、位运算符 |
| `ControlFlow.java` | 控制流示例，演示if-else、switch、for、while等 |

## 8种基本数据类型

| 类型 | 字节 | 位数 | 范围 | 默认值 |
|------|------|------|------|--------|
| byte | 1 | 8 | -128 ~ 127 | 0 |
| short | 2 | 16 | -32768 ~ 32767 | 0 |
| int | 4 | 32 | -2³¹ ~ 2³¹-1 | 0 |
| long | 8 | 64 | -2⁶³ ~ 2⁶³-1 | 0L |
| float | 4 | 32 | ±3.4E38 (约6-7位精度) | 0.0f |
| double | 8 | 64 | ±1.7E308 (约15位精度) | 0.0d |
| boolean | 1 | 8 | true / false | false |
| char | 2 | 16 | '\u0000' ~ '\uffff' | '\u0000' |

## 变量声明

```java
// 变量声明
int age = 25;
String name = "张三";
boolean isStudent = true;

// 常量声明 (final)
final double PI = 3.14159;
final int MAX_COUNT = 100;
```

## 类型转换

### 自动类型转换 (隐式)

小类型 → 大类型，编译器自动完成

```
byte → short → int → long → float → double
         ↑
         char
```

```java
int i = 100;
long l = i;        // 自动转换
double d = i;      // 自动转换
```

### 强制类型转换 (显式)

大类型 → 小类型，可能丢失精度

```java
double d = 3.14159;
int i = (int) d;   // i = 3，小数部分丢失

long l = 100L;
byte b = (byte) l; // 可能溢出
```

### 数值提升

```java
// 运算时自动提升为int
short s1 = 1, s2 = 2;
int i = s1 + s2;   // 结果是int，不是short

// 字符串拼接
String s = "Hello" + 123;  // "Hello123"
```

## 字符串操作

### String常用方法

```java
String s = "Hello World";

// 获取长度和字符
int len = s.length();           // 11
char c = s.charAt(0);           // 'H'

// 查找和判断
int idx = s.indexOf("World");   // 6
boolean contains = s.contains("Hello");  // true
boolean starts = s.startsWith("He");     // true

// 截取和分割
String sub = s.substring(0, 5);  // "Hello"
String[] parts = s.split(" ");    // ["Hello", "World"]

// 大小写
String upper = s.toUpperCase();   // "HELLO WORLD"
String lower = s.toLowerCase();   // "hello world"

// 替换
String replaced = s.replace("World", "Java");  // "Hello Java"

// 去除空白
String trimmed = "  abc  ".trim();  // "abc"

// 判断空
boolean isEmpty = s.isEmpty();   // false
boolean isBlank = s.isBlank();    // false (Java 11+)

// 格式化
String formatted = String.format("Hello %s, age %d", "Tom", 20);
```

### StringBuilder vs String

```java
// String: 不可变，每次修改创建新对象
String s = "Hello";
s += " World";  // 创建新对象，效率低

// StringBuilder: 可变，线程不安全
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" World");  // 高效

// StringBuffer: 可变，线程安全
StringBuffer sbf = new StringBuffer();  // 同步，稍慢
```

## 运算符

### 算术运算符

| 运算符 | 说明 | 示例 |
|--------|------|------|
| + | 加 | a + b |
| - | 减 | a - b |
| * | 乘 | a * b |
| / | 除 | a / b (整数除法取整) |
| % | 取余 | a % b |
| ++ | 自增 | ++a (前), a++ (后) |
| -- | 自减 | --a (前), a-- (后) |

### 关系运算符

| 运算符 | 说明 |
|--------|------|
| == | 等于 |
| != | 不等于 |
| > | 大于 |
| < | 小于 |
| >= | 大于等于 |
| <= | 小于等于 |

### 逻辑运算符

| 运算符 | 说明 | 短路 |
|--------|------|------|
| && | 逻辑与 | 是 |
| \|\| | 逻辑或 | 是 |
| ! | 逻辑非 | - |

### 位运算符

| 运算符 | 说明 |
|--------|------|
| & | 按位与 |
| \| | 按位或 |
| ^ | 按位异或 |
| ~ | 按位取反 |
| << | 左移 |
| >> | 右移 |
| >>> | 无符号右移 |

### 运算符优先级

```
优先级从高到低:
1. () 括号
2. ++ -- ! ~ (一元运算符)
3. * / %
4. + - (二元运算符)
5. << >> >>>
6. < > <= >= instanceof
7. == !=
8. & (按位与)
9. ^ (按位异或)
10. | (按位或)
11. && (逻辑与)
12. || (逻辑或)
13. ? : (三元)
14. = += -= *= /= %= (赋值)
```

## 控制流

### if-else

```java
if (score >= 90) {
    grade = "A";
} else if (score >= 80) {
    grade = "B";
} else if (score >= 70) {
    grade = "C";
} else {
    grade = "D";
}
```

### switch

```java
// Java 14+ 支持箭头表达式
switch (day) {
    case 1, 2, 3, 4, 5 -> "工作日";
    case 6, 7 -> "周末";
    default -> "无效日期";
}

// 传统写法
switch (day) {
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        result = "工作日";
        break;
    case 6:
    case 7:
        result = "周末";
        break;
    default:
        result = "无效日期";
}
```

### for循环

```java
// 普通for循环
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// 增强for循环 (for-each)
int[] nums = {1, 2, 3, 4, 5};
for (int num : nums) {
    System.out.println(num);
}

// Java 8+ forEach
list.forEach(item -> System.out.println(item));
```

### while和do-while

```java
// while: 先判断后执行
while (condition) {
    // 可能不执行
}

// do-while: 先执行后判断
do {
    // 至少执行一次
} while (condition);
```

### 跳转语句

```java
// break: 跳出循环
for (int i = 0; i < 10; i++) {
    if (i == 5) break;  // 跳出整个循环
}

// continue: 跳过本次迭代
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;  // 跳过偶数
    System.out.println(i);
}

// label: 指定跳转位置
outer:
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if (j == 3) break outer;  // 跳出外层循环
    }
}
```
