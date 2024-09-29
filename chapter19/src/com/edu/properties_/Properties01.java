package com.edu.properties_;

import java.io.*;

public class Properties01 {
    public static void main(String[] args) throws IOException {
//        String filePath = "D:\\IdeaJavaProjects\\chapter19\\src\\mysql.properties";
        String filePath = "src\\mysql.properties";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
            if ("ip".equals(split[0])) {
                System.out.println(split[0] + "值是:" + split[1]);
            }
        }
        bufferedReader.close();
    }
}
