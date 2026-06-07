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

### 步骤1: 加载驱动

```java
// 方式1: 反射加载（推荐）
Class.forName("com.mysql.cj.jdbc.Driver");

// 方式2: 自动加载（JDBC 4.0+）
// 只需在classpath中添加驱动jar包
```

### 步骤2: 建立连接

```java
String url = "jdbc:mysql://localhost:3306/mydb";
String user = "root";
String password = "123456";

Connection conn = DriverManager.getConnection(url, user, password);
```

**常用数据库URL**:
```java
// MySQL
"jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC"

// Oracle
"jdbc:oracle:thin:@localhost:1521:mydb"

// SQLServer
"jdbc:sqlserver://localhost:1433;DatabaseName=mydb"

// SQLite
"jdbc:sqlite:mydb.db"
```

### 步骤3: 创建Statement

```java
// 静态SQL（有SQL注入风险）
Statement stmt = conn.createStatement();
String sql = "SELECT * FROM users WHERE name='" + name + "'";

// PreparedStatement（防SQL注入，推荐）
PreparedStatement pstmt = conn.prepareStatement(
    "SELECT * FROM users WHERE name = ? AND age > ?");
pstmt.setString(1, name);
pstmt.setInt(2, age);
```

### 步骤4: 执行SQL

```java
// 查询
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
    int id = rs.getInt("id");
    String name = rs.getString("name");
    System.out.println(id + ": " + name);
}

// 增删改
int rows = stmt.executeUpdate("INSERT INTO users VALUES(1, '张三')");
System.out.println("影响行数: " + rows);
```

### 步骤5: 关闭资源

```java
// 方式1: 手动关闭
rs.close();
stmt.close();
conn.close();

// 方式2: try-with-resources（推荐）
try (Connection conn = DriverManager.getConnection(url, user, pass);
     PreparedStatement pstmt = conn.prepareStatement(sql);
     ResultSet rs = pstmt.executeQuery()) {
    // 操作
} // 自动关闭
```

## 事务管理

```java
conn.setAutoCommit(false);  // 开启事务

try {
    // 执行多条SQL
    stmt.executeUpdate("INSERT INTO a VALUES(1)");
    stmt.executeUpdate("INSERT INTO b VALUES(2)");
    conn.commit();  // 提交事务
} catch (Exception e) {
    conn.rollback();  // 回滚事务
} finally {
    conn.setAutoCommit(true);
}
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

## 批处理优化

```java
pstmt = conn.prepareStatement("INSERT INTO users VALUES(?, ?)");
for (User user : users) {
    pstmt.setInt(1, user.getId());
    pstmt.setString(2, user.getName());
    pstmt.addBatch();  // 添加到批处理
}
pstmt.executeBatch();  // 批量执行
conn.commit();
```

## 常见问题

1. **驱动未找到**: 检查jar包是否引入
2. **连接超时**: 检查数据库服务是否启动
3. **SQL语法错误**: 检查SQL语句
4. **连接泄漏**: 确保资源正确关闭

## 扩展学习

- **连接池**: HikariCP、Druid、C3P0
- **ORM框架**: MyBatis、Hibernate、JPA
- **迁移工具**: Flyway、Liquibase
