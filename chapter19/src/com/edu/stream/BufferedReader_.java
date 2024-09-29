package com.edu.stream;
// 模拟处理流(包装流)
public class BufferedReader_ extends Reader_{
    private Reader_ reader;

    public BufferedReader_(Reader_ reader) {
        this.reader = reader;
    }

    // 扩展节点流的方法
    public void reads(int num) {
        for (int i = 0; i < num; i++) {
            reader.read();
        }
    }
}
