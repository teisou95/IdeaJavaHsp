package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 0823
 * 第一个 Jdbc 程序
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 1.引入jar文件
        // 2.注册驱动
        Driver driver = new Driver();
        // 3.得到连接
        String url = "jdbc:mysql://localhost:3306/db02"; // 数据库监听端口3306,网络连接
        Properties properties = new Properties();
        properties.setProperty("user", "jack");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);
        // 4.执行sql
        /*
            mysql> desc actors;
            +----------+-------------------+------+-----+---------+----------------+
            | Field    | Type              | Null | Key | Default | Extra          |
            +----------+-------------------+------+-----+---------+----------------+
            | id       | int(11)           | NO   | PRI | NULL    | auto_increment |
            | name     | varchar(32)       | NO   |     |         |                |
            | sex      | enum('男','女')   | NO   |     | 女      |                |
            | bornDate | date              | NO   |     | NULL    |                |
            | phone    | varchar(12)       | YES  |     | NULL    |                |
            +----------+-------------------+------+-----+---------+-----------------
         */
//        String sql = "insert into actors values(null,'刘德华','男','1970-11-11','110')";
//        String sql = "insert into actors values(null,'赵本山','男','1961-02-28','119')";
//        String sql = "update actors set phone = '13212345678' where name ='刘德华'";
//        String sql = "alter table actors change column bornDate bornDate date not null "; // rows=0
        String sql = "delete from actors where name = '赵本山'";

        Statement statement = connect.createStatement(); // 发送和执行sql语句,返回结果
        int rows = statement.executeUpdate(sql); // 如果是dml语句,返回受影响的行数
        System.out.println(rows > 0 ? "成功行数" + rows  : "失败");

        // 5.关闭连接
        statement.close();
        connect.close();

    }
}
