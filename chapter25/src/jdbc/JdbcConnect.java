package jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnect {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("driver","com.mysql.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://localhost:3306/db02");
        properties.setProperty("user","jack");
        properties.setProperty("password","123456");
        properties.setProperty("sql","insert into t1 values (null ,'sql语句也在配置文件里')");
        properties.store(new FileWriter("src/jdbc.properties"),null);
    }

    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();

        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user","jack");
        properties.setProperty("password","123456");

        Connection connect = driver.connect(url, properties);
        System.out.println("connect = " + connect);
        Statement statement = connect.createStatement();

        String sql = "create table t1 (id int primary key ,name varchar (16) not null )";
        int rows = statement.executeUpdate(sql);
        System.out.println("rows = " + rows);

        statement.close();
        connect.close();
    }

    @Test
    public void connect02() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 反射
        Class<Driver> driverClass = Driver.class;
        Driver driver = driverClass.newInstance();
        Method connect = driverClass.getMethod("connect", String.class, Properties.class);

        String url = "jdbc:mysql://localhost:3306/db02";
        Properties properties = new Properties();
        properties.setProperty("user","jack");
        properties.setProperty("password","123456");

        Connection connection = (Connection) connect.invoke(driver, url, properties);
        Class<? extends Connection> connectionClass = connection.getClass();
        Method close1 = connectionClass.getMethod("close");
        Method createStatement = connectionClass.getMethod("createStatement");
        Statement statement = (Statement) createStatement.invoke(connection);

        Class<? extends Statement> statementClass = statement.getClass();
        Method executeUpdate = statementClass.getMethod("executeUpdate", String.class);
        Method close = statementClass.getMethod("close");

        String sql = "insert into t1 values (1,'mary')";
        Integer rows = (Integer) executeUpdate.invoke(statement, sql);
        System.out.println("rows = " + rows);

        close.invoke(statement);
        close1.invoke(connection);

    }

    @Test
    public void connect03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        // DriverManager 统一管理
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "jack";
        String password = "123456";

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

//        String sql = "alter table t1 change id id int auto_increment";
        String sql = "insert into t1 values (null ,'haha')";
        int rows = statement.executeUpdate(sql);
        System.out.println("rows = " + rows);

        statement.close();
        connection.close();
    }

    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        // DriverManager 统一管理
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        // 加载Driver 类 自动完成注册
        /*
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */

        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "jack";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

//        String sql = "insert into t1 values (null ,'塔塔')";
        String sql = "insert into t1 values (null ,'注销了代码:类加载')";
        int rows = statement.executeUpdate(sql);
        System.out.println("rows = " + rows);

        statement.close();
        connection.close();
    }

    @Test
    public void connect05() throws ClassNotFoundException, IOException, SQLException {
        // 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileReader("src/jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String sql = properties.getProperty("sql");

        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

//        String sql = "insert into t1 values (null ,'连driver也可以放进去')";
        int rows = statement.executeUpdate(sql);
        System.out.println("rows = " + rows);

    }

}
