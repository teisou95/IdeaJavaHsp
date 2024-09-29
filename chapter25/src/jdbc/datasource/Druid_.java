package jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 连接池
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
//            System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("druid 500000 次连接耗时" + (end - start) + "毫秒");
        // druid 500000 次连接耗时220毫秒
    }
}
