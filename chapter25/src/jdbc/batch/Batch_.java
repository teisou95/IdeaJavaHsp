package jdbc.batch;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 批处理
 */
public class Batch_ {
    // 传统方法,添加5000条数据到admin2
    @Test
    public void noBatch() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/preparedStatement.properties"));
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        String sql = "insert into admin2 values(null ,?,?)";
        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行添加");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "user" + i);
            preparedStatement.setString(2, "password" + i);
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();

        System.out.println("传统方式完成添加,耗时 " + (end - start) + " 毫秒");
        // 传统方式完成添加,耗时 1450 毫秒
        preparedStatement.close();
        connection.close();
    }

    // 批处理
    @Test
    public void batch() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/preparedStatement.properties"));
        String url = properties.getProperty("url"); // 配置批处理
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        String sql = "insert into admin2 values(null ,?,?)";
        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false); // 关闭自动提交
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("开始执行添加");
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5001; i++) {
            preparedStatement.setString(1, "user" + i);
            preparedStatement.setString(2, "password" + i);
            // 将sql语句加入到批处理包中
            preparedStatement.addBatch();
            if (i % 1000 == 0) { // 每 1000 条执行一次
                preparedStatement.executeBatch();
                preparedStatement.clearBatch(); // 清空批处理包
            }
        }
        connection.commit();
        long end = System.currentTimeMillis();

        System.out.println("批处理方式完成添加,耗时 " + (end - start) + " 毫秒");
        // 批处理方式完成添加,耗时 140 毫秒
        preparedStatement.close();
        connection.close();
    }
}
