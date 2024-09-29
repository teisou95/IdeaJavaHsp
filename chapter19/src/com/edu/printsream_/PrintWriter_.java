package com.edu.printsream_;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
//        PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\ffff.txt"));
        printWriter.print("急急急");
        printWriter.close();
    }
}
