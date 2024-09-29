package jdbc.transaction_;

import jdbc.utils.JDBCUtils_;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * 0838
 * 事务
 */
public class Transaction_ {
    @Test
    public void noTransaction() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils_.getConnection();

            String sql = "update account set balance = balance - 100 where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "马云");
            int rows = preparedStatement.executeUpdate();

            int i = 1 / 0;//制造异常

            String sql1 = "update account set balance = balance + 100 where name = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, "马化腾");
            int rows1 = preparedStatement.executeUpdate();

            System.out.println((rows > 0 && rows1 > 0) ? "转账成功" : "转账失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void hasTransaction() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;
        try {
            connection = JDBCUtils_.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("A");

            String sql = "update account set balance = balance - 100 where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "马云");
            int rows = preparedStatement.executeUpdate();

//            int i = 1 / 0;//制造异常

            String sql1 = "update account set balance = balance + 100 where name = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, "马化腾");
            int rows1 = preparedStatement.executeUpdate();

            if (rows > 0 && rows1 > 0) {
                System.out.println("转账成功");
                connection.commit();
            } else {
                System.out.println("转账失败,回滚事务");
                connection.rollback(savepoint);
            }
        } catch (Exception e) {
            try {
                System.out.println("发生异常,回滚事务");
                connection.rollback(savepoint);
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtils_.close(null, preparedStatement, connection);
        }
    }
}
