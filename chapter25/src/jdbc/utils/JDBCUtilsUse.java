package jdbc.utils;

import org.junit.Test;

import java.sql.*;

public class JDBCUtilsUse {
    public static void main(String[] args) {

    }

    @Test
    public void testDML() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        String sql = "update actor set name = ? where id = ?";
//        String sql = "insert into actor values(?,?,?,?)";
        String sql = "delete from actor where id = ?";
        try {
            connection = JDBCUtils_.getConnection();
            preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setString(1, "王大宝");
//            preparedStatement.setInt(2, 2);

//            preparedStatement.setObject(1,null);
//            preparedStatement.setString(2,"大张伟");
//            preparedStatement.setString(3,"男");
//            preparedStatement.setDate(4,new Date(87,2,25));

            preparedStatement.setInt(1, 2);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "执行成功" : "失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from actor where id = ? or name = ?";
        try {
            connection = JDBCUtils_.getConnection();
            System.out.println(connection.getClass() );
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "佐佐木希");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date born = resultSet.getDate("born");
                String sex = resultSet.getString("sex");
                System.out.println(id + " " + name + " " + sex + " " + born);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_.close(resultSet,preparedStatement,connection);
        }
    }
}
