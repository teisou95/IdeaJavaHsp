package mysql.jar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载类 得到 mysql连接
        Class.forName("java.sql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:\\localhost:3306/data/db02","username","password");

        // 编写mysql语句
        // 创建一个商品 goods表
//        String sql = "create table goods (id int,name varchar(32),price double,introduce text)";
//        String sql = "insert into goods values(1,'手机','2000','好手机')";
        String sql = "drop table goods";
        // 得到Statement
        Statement statement = connection.createStatement();
        // 发送执行
        statement.executeUpdate(sql);

        // 关连
        statement.close();
        connection.close();
        System.out.println("成功");


    }
}
