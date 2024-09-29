package dao;

import domain.Bill;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BillDAO extends BasicDAO<Bill> {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    /**
     * 事务(点菜)
     *
     * @param tableId 餐桌编号
     * @param sql     点单语句
     * @param params  点单参数
     * @return 点菜是否成功
     */
    public boolean order(int tableId, String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            connection.setAutoCommit(false);
            // 修改餐桌状态
            int update = diningTableDAO.update("update diningTable set state = '用餐中' where tableId = ?", tableId);
            int update1 = this.update(sql, params);
            if (!(update > 0 && update1 > 0)) {
                System.out.println("执行点菜失败,回滚");
                connection.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                System.out.println("出现异常,回滚");
                connection.rollback();
                return false;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
        System.out.println("点菜成功");
        return true;
    }


    /**
     * 事务(结账)
     * @param tableId 桌号
     * @param sql 结账语句
     * @param params 参数
     * @return 是否结账成功
     */
    public boolean checkout(int tableId, String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            connection.setAutoCommit(false);
            // 修改餐桌状态
            int update = diningTableDAO.update("update diningTable set state = '空',orderName = '',orderTel = '' where tableId = ?", tableId);
            int update1 = this.update(sql, params);
            if (!(update > 0 && update1 > 0)) {
                System.out.println("执行结账失败,回滚");
                connection.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                System.out.println("出现异常,回滚");
                connection.rollback();
                return false;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
        return true;
    }
}
