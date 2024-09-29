package dao_.dao;

import dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 其他 Dao 的父类
 * 泛型指定具体的类型
 */
public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    // 开发通用DML方法,针对任意表
    public int update(String sql, Object... params) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            int rows = qr.update(connection, sql, params);
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 返回多个对象(多行查询结果)
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    // 查询单行
    public T querySingle(String sql,Class<T> clazz,Object...params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            T query = qr.query(connection, sql, new BeanHandler<T>(clazz), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    // 查询单行单列
    public Object queryScalar(String sql,Object...params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            Object query = qr.query(connection, sql, new ScalarHandler(), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
