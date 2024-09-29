package jdbc.myjdbc;

public class TestJdbc {
    public static void main(String[] args) {
        // 操作jdbc
        JdbcInterface jdbcImplement = new MysqlJdbcImplement();
        jdbcImplement.getConnect();
        jdbcImplement.crud();
        jdbcImplement.close();

        System.out.println("=======================");
        // 操作jdbc
        jdbcImplement = new OracleJdbcImplement();
        jdbcImplement.getConnect();
        jdbcImplement.crud();
        jdbcImplement.close();
    }
}
