package com.edu.interface_;

public class OracleDB implements DBInterface{
    @Override
    public void connect() {
        System.out.println("连接 Oracle");
    }

    @Override
    public void close() {
        System.out.println("关闭 Oracle");
    }
}
