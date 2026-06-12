# 数据库 (database)

本文件夹包含Java数据库编程的示例，演示JDBC标准API的使用。

## 文件说明

| 文件名 | 说明 |
|--------|------|
| `JdbcDemo.java` | JDBC基础示例，演示使用JDBC连接数据库、执行SQL、事务管理 |

## JDBC架构

```
Java应用
    ↓
JDBC API (java.sql)
    ↓
JDBC Driver Manager
    ↓
数据库驱动 (MySQL Driver, Oracle Driver...)
    ↓
数据库服务器
```

## 核心概念

### 1. JDBC工作流程

```
┌──────────┐    ┌───────────┐    ┌─────────┐    ┌────────┐
│  Java    │───▶│  JDBC     │───▶│  Driver │───▶│  DB    │
│  App     │◀───│  API      │◀───│  Manager│◀───│ Server │
└──────────┘    └───────────┘    └─────────┘    └────────┘
```

### 2. 核心接口

| 接口 | 作用 |
|------|------|
| `DriverManager` | 管理数据库驱动 |
| `Connection` | 表示数据库连接 |
| `Statement` | 执行静态SQL |
| `PreparedStatement` | 执行动态SQL（防注入） |
| `CallableStatement` | 执行存储过程 |
| `ResultSet` | 封装查询结果 |

## 基本步骤

### 步骤1: 建立连接

```java
// SQLite 连接（无需用户名密码，直接创建本地文件）
String url = "jdbc:sqlite:example.db";
Connection conn = DriverManager.getConnection(url);
```

**常用数据库URL**:
```java
// SQLite（本示例使用）
"jdbc:sqlite:mydb.db"

// MySQL
"jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC"

// Oracle
"jdbc:oracle:thin:@localhost:1521:mydb"

// SQLServer
"jdbc:sqlserver://localhost:1433;DatabaseName=mydb"
```

### 步骤2: 创建表

```java
String createTableSQL = "CREATE TABLE IF NOT EXISTS users " +
    "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)";
conn.createStatement().execute(createTableSQL);
```

**注意**：SQLite 使用 `AUTOINCREMENT`，MySQL 使用 `AUTO_INCREMENT`

### 步骤3: 创建PreparedStatement

```java
// PreparedStatement（防SQL注入，推荐）
String insertSQL = "INSERT INTO users (name, age) VALUES (?, ?)";
PreparedStatement pstmt = conn.prepareStatement(insertSQL);
pstmt.setString(1, "张三");
pstmt.setInt(2, 25);
pstmt.executeUpdate();
```

### 步骤4: 执行查询

```java
ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users");
while (rs.next()) {
    System.out.println("ID: " + rs.getInt("id") +
        ", Name: " + rs.getString("name") +
        ", Age: " + rs.getInt("age"));
}
```

### 步骤5: 关闭资源

```java
// 方式1: 手动关闭（本示例使用）
rs.close();
pstmt.close();
conn.close();

// 方式2: try-with-resources（推荐）
try (Connection conn = DriverManager.getConnection(url);
     PreparedStatement pstmt = conn.prepareStatement(sql);
     ResultSet rs = pstmt.executeQuery()) {
    // 操作
} // 自动关闭
```

## SQL注入防护

```java
// 危险！SQL注入
String sql = "SELECT * FROM users WHERE name='" + input + "'";
// 输入: ' OR '1'='1  -> 绕过验证

// 安全！使用PreparedStatement
PreparedStatement pstmt = conn.prepareStatement(
    "SELECT * FROM users WHERE name = ?");
pstmt.setString(1, input);  // 参数绑定
```

## 常见问题

1. **驱动未找到**: 检查jar包是否引入
2. **连接超时**: 检查数据库服务是否启动
3. **SQL语法错误**: 检查SQL语句
4. **连接泄漏**: 确保资源正确关闭

## SQLite vs MySQL 差异

| 特性 | SQLite | MySQL |
|------|--------|-------|
| 连接URL | `jdbc:sqlite:文件名` | `jdbc:mysql://主机:端口/数据库` |
| 用户名密码 | 不需要 | 需要 |
| 自增主键 | `AUTOINCREMENT` | `AUTO_INCREMENT` |
| 驱动注册 | 不需要 | `Class.forName("com.mysql.cj.jdbc.Driver")` |
| 安装 | 无需安装 | 需要安装数据库服务 |

## 扩展学习

- **连接池**: HikariCP、Druid、C3P0
- **ORM框架**: MyBatis、Hibernate、JPA
- **迁移工具**: Flyway、Liquibase
