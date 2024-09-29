package jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * C3P0的使用
 */
public class C3P0_ {
    @Test
    public void testC3P0_01() throws IOException, PropertyVetoException, SQLException {
        // 创建数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        // 通过配置文件获取信息
        Properties properties = new Properties();
        properties.load(new FileReader("src/preparedStatement.properties"));
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        // 给数据源 comboPooledDataSource 设置参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        // 设置连接池的初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(50); // 最大连接数 -- 扩容

        // 获取连接,测试效率 329ms
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close(); // close方法已经被jar包重写
        }
    }

    // 使用配置文件完成 c3p0-config.xml 放在 src 目录
    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource c3p0hello = new ComboPooledDataSource("c3p0hello");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = c3p0hello.getConnection();
//            System.out.println("使用配置文件完成");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 500000 次连接耗时" + (end - start) + "毫秒");
        // c3p0 500000 次连接耗时1143毫秒
    }
}
