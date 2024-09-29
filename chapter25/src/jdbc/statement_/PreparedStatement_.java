package jdbc.statement_;

import jdbc.utils.JDBCUtils_;

import java.io.IOException;
import java.sql.*;

/**
 * 预处理 防sql注入
 * 输入用户名:1' or
 * 输入密码:or '1' = '1
 * 失败
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCUtils_.getConnection();
        String sql = "select name,pwd from admin where name = ? and pwd = ?"; // ? 作为占位符
        // preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("输入用户名:");
//        String adminName = scanner.nextLine();
//        System.out.print("输入密码:");
//        String adminPwd = scanner.nextLine();
//
//        preparedStatement.setString(1, adminName);
//        preparedStatement.setString(2,adminPwd);
        preparedStatement.setString(1, "1' or");
        preparedStatement.setString(2,"or '1' = '1");

        ResultSet resultSet = preparedStatement.executeQuery(); // sql 不需要再填写了
        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("失败");
        }

        JDBCUtils_.close(resultSet,preparedStatement,connection);
    }
}
