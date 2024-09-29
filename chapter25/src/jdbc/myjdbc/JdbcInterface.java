package jdbc.myjdbc;

/**
 * 模拟 jdbc接口
 */
public interface JdbcInterface {
    // 连接
    public Object getConnect();
    // crud
    public void crud();
    // 关闭连接
    public void close();
}
