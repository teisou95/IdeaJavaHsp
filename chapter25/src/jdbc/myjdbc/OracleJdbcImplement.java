package jdbc.myjdbc;

/**
 * Oracle 实现接口
 */
public class OracleJdbcImplement implements JdbcInterface{
    @Override
    public Object getConnect() {
        System.out.println("得到 Oracle 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 Oracle 的增删改查");

    }

    @Override
    public void close() {
        System.out.println("关闭 Oracle 的连接");

    }
}
