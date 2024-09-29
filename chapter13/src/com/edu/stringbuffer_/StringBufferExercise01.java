package com.edu.stringbuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str); // 底层调用  AbstractStringBuilder appendNull()
        System.out.println(stringBuffer.length()); // 4
        System.out.println(stringBuffer); // null

        StringBuffer stringBuffer1 = new StringBuffer(str); // 空指针异常
        /*
           public StringBuffer(String str) {
                super(str.length() + 16);
                append(str);
            }
         */

    }
}
