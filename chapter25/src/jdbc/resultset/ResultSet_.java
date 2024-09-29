package jdbc.resultset;

import jdbc.utils.JDBCUtils_;
import java.io.IOException;
import java.sql.*;

/**
 * 0828
 * select 语句 返回 resultSet
 */
public class ResultSet_ {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCUtils_.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from actor";
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println(sql);
        System.out.println("id" + "\t" + "name" + "\t" + "sex" + "\t" + "born");
        // 光标下移,直到返回false
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date born = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + born);
        }

        JDBCUtils_.close(resultSet,statement,connection);

    }
}
