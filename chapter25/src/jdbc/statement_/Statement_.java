package jdbc.statement_;

import jdbc.utils.JDBCUtils_;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 * sql注入
 * 输入用户名:1' or
 * 输入密码:or '1' = '1
 * 登陆成功
 */
public class Statement_ {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCUtils_.getConnection();
        Statement statement = connection.createStatement();
//        String sql = "select name,pwd from admin";

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入用户名:");
        String adminName = scanner.nextLine();
        System.out.print("输入密码:");
        String adminPwd = scanner.nextLine();
        String sql = "select name,pwd from admin where name = '" + adminName + "' and pwd = '" + adminPwd + "'";

        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("失败");
        }

        JDBCUtils_.close(resultSet,statement,connection);
    }
}
