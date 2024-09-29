package com.edu.interface_;

public class Interface03 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        OracleDB oracleDB = new OracleDB();
        t(mysqlDB);
        t(oracleDB);

    }

    public static void t(DBInterface dbInterface) {
        dbInterface.connect();
        dbInterface.close();
    }
}

