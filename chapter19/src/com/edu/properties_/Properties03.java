package com.edu.properties_;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","abc111");

//        properties.store(new FileOutputStream("src\\mysql001.properties"),null);
        properties.store(new FileWriter("src\\mysql001.properties"),"hello,world");

        properties.setProperty("pwd","300300");
        properties.store(new FileWriter("src\\mysql001.properties"),null);
    }
}
