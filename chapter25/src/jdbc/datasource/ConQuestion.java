package jdbc.datasource;

import jdbc.utils.JDBCUtils_;
import org.junit.Test;

import java.sql.Connection;

public class ConQuestion {
    // 连接 mysql 5000次
    @Test
    public void testCon() {
        // 不关闭连接 Too many connections 异常
        // 关闭连接 耗时长 2443毫秒
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils_.getConnection();
            JDBCUtils_.close(null, null, connection);
        }
    }
}