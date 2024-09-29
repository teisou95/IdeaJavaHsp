package jdbc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类
 * 获取连接
 * 关闭资源
 */
public class JDBCUtils_ {
    private static String user;
    private static String password;
    private static String driver;
    private static String url;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src/jdbc.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            Class<?> aClass = Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
