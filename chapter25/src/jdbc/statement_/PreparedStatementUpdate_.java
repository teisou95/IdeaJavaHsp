package jdbc.statement_;

import jdbc.utils.JDBCUtils_;

import java.io.IOException;
import java.sql.*;

/**
 * 预处理 防sql注入
 */
public class PreparedStatementUpdate_ {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCUtils_.getConnection();
//        String sql = "insert into admin values(?,?)";
//        String sql = "update admin set pwd = ? where name = ?";
        String sql = "delete from admin where name = ? and pwd = ?";
        // preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "wang");
        preparedStatement.setString(2,"111");
        int rows = preparedStatement.executeUpdate();
        System.out.println("rows = " + rows);

        JDBCUtils_.close(null,preparedStatement,connection);
    }
}

