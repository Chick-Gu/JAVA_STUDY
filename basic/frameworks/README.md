# 框架 (frameworks)

本文件夹包含Java主流框架的示例，当前主要演示Spring框架基础。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `SpringDemo.java` | Spring框架基础示例，演示Spring IOC容器和依赖注入 |

## Spring框架概述

Spring是Java生态中最流行的企业级应用开发框架，提供IoC、AOP等核心功能。

```
┌─────────────────────────────────────────────────────┐
│                  Spring Framework                   │
├─────────────────────────────────────────────────────┤
│  Core Container                                     │
│  ├─ Beans (IOC/DI)                                  │
│  ├─ Core (资源加载、事件机制)                         │
│  ├─ Context (应用上下文)                             │
│  └─ SpEL (Spring表达式语言)                         │
├─────────────────────────────────────────────────────┤
│  AOP & Aspects                                      │
├─────────────────────────────────────────────────────┤
│  Data Access/Integration                            │
│  ├─ JDBC                                            │
│  ├─ ORM                                             │
│  ├─ Transactions                                    │
│  └─ OXMs                                            │
├─────────────────────────────────────────────────────┤
│  Web (Spring MVC)                                   │
├─────────────────────────────────────────────────────┤
│  Testing                                            │
└─────────────────────────────────────────────────────┘
```

## 核心概念

### 1. IOC (控制反转)

将对象的创建和管理权交给Spring容器，而不是在代码中直接`new`。

```
传统方式:
A a = new A();  // 自己创建对象

IOC方式:
Spring容器 ──注入──▶ A对象  // 容器创建和管理
```

### 2. DI (依赖注入)

**实际代码（SpringDemo.java）使用 @Configuration + @Bean：**
```java
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
```

**依赖注入的三种方式（扩展知识）：**

**构造方法注入** (推荐):
```java
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
}
```

**Setter注入**:
```java
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
```

**字段注入** (不推荐):
```java
public class UserService {
    @Autowired
    private UserDao userDao;
}
```

**注意事项**：
- 实际代码使用 `@Configuration` + `@Bean` 的 Java 配置方式
- 实际项目中通常使用 `@Component` + `@Autowired` 的注解方式
- 运行代码需要添加 Spring 依赖（Maven/Gradle）

### 3. AOP (面向切面编程)（扩展知识）

分离横切关注点，如日志、事务、安全等。

```
┌────────────────────────────────────┐
│          业务逻辑方法               │
│  ┌──────────────────────────────┐ │
│  │ @Transactional               │ │
│  │ public void transfer(){      │ │
│  │     // 转账业务逻辑           │ │
│  │ }                            │ │
│  └──────────────────────────────┘ │
└────────────────────────────────────┘
         │
         ▼
┌────────────────────────────────────┐
│  切面 (Aspect)                     │
│  ├─ 前置通知 (Before)              │
│  ├─ 后置通知 (After Returning)    │
│  ├─ 异常通知 (After Throwing)     │
│  ├─ 最终通知 (After Finally)       │
│  └─ 环绕通知 (Around)              │
└────────────────────────────────────┘
```

**注意**：AOP 在实际代码中未演示，属于扩展知识

## Spring模块

| 模块 | 说明 |
|------|------|
| Spring Core | IOC容器和DI |
| Spring AOP | 面向切面编程 |
| Spring JDBC | 数据库访问封装 |
| Spring ORM | 整合Hibernate/MyBatis |
| Spring TX | 事务管理 |
| Spring Web | Web应用开发 |
| Spring MVC | Web MVC框架 |
| Spring Boot | 快速开发脚手架 |
| Spring Cloud | 微服务框架 |

## Spring Boot vs 传统Spring

| 特性 | 传统Spring | Spring Boot |
|------|-----------|-------------|
| 配置 | XML大量配置 | 自动配置 |
| 依赖 | 手动管理 | starter自动引入 |
| 运行 | 需部署到服务器 | main方法直接运行 |
| 监控 | 无 | actuator提供 |
| 微服务 | 支持但繁琐 | 原生支持 |

## 常用注解

### Bean定义
```java
@Component      // 通用组件
@Service       // 业务层组件
@Repository    // 数据访问层组件
@Controller    // 控制层组件 (Web)
@Configuration // 配置类
```

### 依赖注入
```java
@Autowired     // 自动注入（byType）
@Qualifier     // 指定bean名称（byName）
@Resource      // 自动注入（byName）
@Primary       // 主候选bean
```

### 作用域
```java
@Scope("singleton")  // 单例（默认）
@Scope("prototype")  // 原型，每次请求新实例
@Scope("request")     // 请求
@Scope("session")     // 会话
```

## 最佳实践

1. 构造方法注入优先（保证不可变性）
2. 面向接口编程（便于测试和替换）
3. 使用@ComponentScan指定扫描包
4. 配置类使用@Configuration而非@Component
5. 避免字段注入（难以单元测试）

## Maven 依赖

运行 SpringDemo.java 需要添加以下依赖：

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.30</version>
</dependency>
```

## 扩展学习

- Spring Security: 认证授权
- Spring Data: 数据访问抽象
- Spring Batch: 批处理
- Spring Cloud: 微服务
