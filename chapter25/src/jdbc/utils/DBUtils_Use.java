package jdbc.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class DBUtils_Use {
    // 使用 apache-DBUtils 工具类 + druid
    @Test
    public void testQueryMany() throws SQLException {
        // 返回结果是多行的情况
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select id,name,sex from actor where id >= ?";
        // 使用DBUtils
        QueryRunner queryRunner = new QueryRunner();
        List<Actor> actors = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        JDBCUtilsByDruid.close(null, null, connection);

    }

    @Test
    public void testQuerySingle() throws SQLException {
        // 返回结果是单行
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from actor where id = ?";
        // 使用DBUtils
        QueryRunner queryRunner = new QueryRunner();
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 5);
        System.out.println(actor);
        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    public void testScalar() throws SQLException {
        // 返回单行单列
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select name from actor where id = ?";
        // 使用DBUtils
        QueryRunner queryRunner = new QueryRunner();
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 5);
        System.out.println("obj = " + obj);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    public void testDML() throws SQLException {
        // 使用DML语句
        Connection connection = JDBCUtilsByDruid.getConnection();
//        String sql = "insert into actor values(null,?,?,?)";
        String sql = "delete from actor where id = ?";
//        String sql = "update actor set name = ? where id = ?";
        // 使用DBUtils
        QueryRunner queryRunner = new QueryRunner();
        int rows = queryRunner.update(connection, sql,7);


        JDBCUtilsByDruid.close(null, null, connection);
    }
}
