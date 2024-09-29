package jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcHomework {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        int i = 1;
        while (true) {
            try {
                String sql = properties.getProperty("sql" + i++);
                System.out.println("sql = " + sql);
                int rows = statement.executeUpdate(sql);
                System.out.println("受影响rows = " + rows);
            } catch (SQLException throwables) {
                System.out.println("sql语句循环读取结束");
                break;
            }
        }

        System.out.println("执行完成");
        statement.close();
        connection.close();
    }
}
