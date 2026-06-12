# 异常处理 (exception_handling)

本文件夹包含Java异常处理的示例，涵盖异常基础、自定义异常和最佳实践。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `ExceptionDemo.java` | 异常处理基础示例，演示try-catch-finally和异常抛出 |
| `ExceptionDetailsDemo.java` | 异常详解，演示自定义异常、异常链和最佳实践 |

## 异常层次结构

```
Throwable
├─ Error (错误)
│   ├─ OutOfMemoryError
│   ├─ StackOverflowError
│   └─ NoClassDefFoundError
└─ Exception (异常)
    ├─ IOException (检查型)
    ├─ SQLException (检查型)
    └─ RuntimeException (非检查型)
        ├─ NullPointerException
        ├─ ArrayIndexOutOfBoundsException
        ├─ ClassCastException
        └─ ArithmeticException
```

## 核心概念

### 1. try-catch-finally

```java
try {
    // 可能抛出异常的代码
    int result = divide(10, 0);
} catch (ArithmeticException e) {
    // 捕获特定异常
    System.out.println("除数不能为零: " + e.getMessage());
} catch (Exception e) {
    // 捕获其他异常
    System.out.println("其他异常: " + e.getMessage());
} finally {
    // 无论是否异常都执行
    System.out.println("清理资源");
}
```

**执行顺序**:
1. try中的代码正常执行
2. 若抛出异常，尝试匹配catch子句
3. finally总是执行（即使catch中有return）

### 2. 异常抛出

```java
// throw: 主动抛出异常
public void checkAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("年龄不能为负数");
    }
}

// throws: 方法声明可能抛出的异常
public void readFile(String path) throws IOException {
    // 方法实现
}
```

### 3. 自定义异常

**实际代码（ExceptionDetailsDemo.java）中的 InvalidAgeException：**
```java
public class InvalidAgeException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidAgeException(String message) {
        super(message);
    }

    // 带 cause 参数的构造函数，用于异常链
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

**自定义异常最佳实践：**
```java
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    // 提供带 cause 的构造函数，支持异常链
    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
```

**注意事项**：
- 自定义异常应提供带 `Throwable cause` 参数的构造函数，以支持异常链
- 检查型异常继承 `Exception`，非检查型异常继承 `RuntimeException`

### 4. 异常链

保留原始异常信息，便于追踪问题根源：

```java
try {
    // 业务操作
} catch (IOException e) {
    throw new BusinessException("FILE_ERROR", "文件处理失败", e);
}
```

## 异常类型

| 类型 | 继承 | 特点 | 处理要求 |
|------|------|------|----------|
| 检查型异常 | `Exception` | 编译器检查 | 必须捕获或声明throws |
| 非检查型异常 | `RuntimeException` | 运行时检查 | 可选捕获 |
| 错误 | `Error` | JVM问题 | 通常不捕获 |

## 常见异常

| 异常 | 原因 |
|------|------|
| `NullPointerException` | 空指针访问 |
| `ArrayIndexOutOfBoundsException` | 数组越界 |
| `ClassCastException` | 类型转换失败 |
| `IllegalArgumentException` | 参数不合法 |
| `NumberFormatException` | 数字格式错误 |
| `ConcurrentModificationException` | 并发修改集合 |

## 最佳实践

### 应该捕获的异常
1. 可恢复的异常
2. 调用方可以正确处理的异常
3. 需要记录日志的异常

### 应该抛出（不捕获）的异常
1. 无法恢复的Error
2. 调用方无法处理的异常
3. 传播更有意义信息的异常

### 异常处理规范

```java
// 错误示例
try {
    doSomething();
} catch (Exception e) {
    e.printStackTrace();  // 不推荐
}

// 推荐做法
try {
    doSomething();
} catch (SpecificException e) {
    log.error("操作失败", e);
    throw new BusinessException("OPERATION_FAILED", "操作失败", e);
}
```

### 异常匹配规则

1. 捕获顺序很重要，子类在前，父类在后
2. 可以捕获多个异常（Java 7+）

```java
// Java 7+ 多异常捕获
try {
    // 多种操作
} catch (IOException | SQLException e) {
    log.error("IO或SQL异常", e);
}
```

## 性能考虑

1. 异常创建有性能开销（填充栈轨迹）
2. 不要用异常控制程序流程
3. 避免在循环中捕获异常
