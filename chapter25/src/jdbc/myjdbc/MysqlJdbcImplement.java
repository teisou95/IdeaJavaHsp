package jdbc.myjdbc;
/**
 * mysql 实现接口
 */
public class MysqlJdbcImplement implements JdbcInterface{
    @Override
    public Object getConnect() {
        System.out.println("得到 mysql 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 的增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 mysql 的连接");
    }
}
