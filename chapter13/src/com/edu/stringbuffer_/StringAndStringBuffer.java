package com.edu.stringbuffer_;


/**
 * String 与 StringBuffer 转换
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        String str = "hello tom";
        // 返回的是 StringBuffer对象,对 String 没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(str.getClass());

        // append 方法 拼接
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        StringBuffer jack = new StringBuffer("jack");
        String s = jack.toString();
        String s1 = new String(jack);
    }
}
