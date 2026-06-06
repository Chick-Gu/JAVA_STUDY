package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC基础示例
 * 演示如何使用JDBC连接数据库
 */
public class JdbcDemo {
    
    // 数据库连接信息（使用SQLite作为示例，无需额外安装）
    private static final String URL = "jdbc:sqlite:example.db";
    
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 注册驱动（SQLite不需要显式注册）
            
            // 建立连接
            conn = DriverManager.getConnection(URL);
            System.out.println("数据库连接成功");
            
            // 创建表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)";
            conn.createStatement().execute(createTableSQL);
            
            // 插入数据
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
