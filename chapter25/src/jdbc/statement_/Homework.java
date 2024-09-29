package jdbc.statement_;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Homework {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/preparedStatement.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String sql1 = properties.getProperty("sql1");
        String sql2 = properties.getProperty("sql2");
        String sql3 = properties.getProperty("sql3");
        String sql4 = properties.getProperty("sql4");
        String sql5 = properties.getProperty("sql5");

        Class<?> aClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement5 = connection.prepareStatement(sql5);
        ResultSet resultSet = preparedStatement5.executeQuery();
        while (resultSet.next()) {
//            String name = resultSet.getString("name");
//            String pwd = resultSet.getString("pwd");
            String name = resultSet.getString(1);
            String pwd = resultSet.getString(2);
            System.out.println(name + "\t" + pwd);
        }
        resultSet.close();
        preparedStatement5.close();

//        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
//        preparedStatement3.setString(1,"king");
//        preparedStatement3.setString(2,"tom");
//        preparedStatement3.executeUpdate();
//
//        PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
//        preparedStatement4.setString(1,"yaya");
//        preparedStatement4.executeUpdate();
//
//        preparedStatement3.close();
//        preparedStatement4.close();

//        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
//        preparedStatement1.executeUpdate();
//
//        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
//        preparedStatement2.setString(1,"tom");
//        preparedStatement2.setString(2,"123");
//        preparedStatement2.executeUpdate();
//
//        preparedStatement2.setString(1,"mary");
//        preparedStatement2.setString(2,"456");
//        preparedStatement2.executeUpdate();
//
//        preparedStatement2.setString(1,"papa");
//        preparedStatement2.setString(2,"789");
//        preparedStatement2.executeUpdate();
//
//        preparedStatement2.setString(1,"yaya");
//        preparedStatement2.setString(2,"000");
//        preparedStatement2.executeUpdate();
//
//        preparedStatement2.setString(1,"tata");
//        preparedStatement2.setString(2,"000123");
//        preparedStatement2.executeUpdate();
//
//        preparedStatement2.setString(1,"mama");
//        preparedStatement2.setString(2,"123456789");
//        preparedStatement2.executeUpdate();
//
//        preparedStatement2.close();
//        preparedStatement2.close();
        connection.close();

    }
}
