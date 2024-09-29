package com.edu.stringbuffer_;

public class StringBuggerMethod01 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");
        s.append(',');
        s.append("张三丰");
        s.append("赵敏").append(100).append(true).append(10.5);
        System.out.println(s);

        // 删除
        s.delete(11,14);
        System.out.println(s);

        // 修改 替换
        s.replace(9,11,"周芷若");
        System.out.println(s);

        // 查找
        int indexOf = s.indexOf("张三");
        System.out.println(indexOf);

        // 插入
        s.insert(9,"赵敏");
        System.out.println(s);

        // 长度
        System.out.println(s.length());
    }
}
