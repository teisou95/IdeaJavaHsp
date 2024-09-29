package com.edu.string_;

public class StringMethod02 {
    public static void main(String[] args) {
        System.out.println("dka".toUpperCase());
        System.out.println("KJD".toLowerCase());

        String s1 = "ab";
        String s2 = "df";
        String s3 = "ja";
        String str = s1.concat(s2).concat(s3);
        System.out.println(str);

        System.out.println(str.replace("a", "哈哈"));
        System.out.println(str);

        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        String[] split = poem.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        poem = "E:\\aaa\\bbb";
        System.out.println(poem);
        split = poem.split("\\\\");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        String s = "happy";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        System.out.println(chars);

        String a = "jchn";
        String b = "jack";
        String c = "jackabc";
        System.out.println(a.compareTo(b)); // 2 // 'c' - 'a'
        System.out.println(b.compareTo(c)); // -3

        String name = "john";
        int age = 10;
        double score = 52.887;
        char gender = '男';
        String info = "我的姓名是" + name + " 年龄是" + age + " 成绩是" + score + " 性别是" + gender;
        System.out.println(info);
        // 占位符
        // %d %s %.2f %c 由后面的变量替换
        // %d 十进制整数
        // %.2f 小数(保留小数点2位,四舍五入)
        /*
            %f 会输出浮点数，默认保留 6 位小数并自动四舍五入。
            你可以通过 %.nf 的形式指定输出的小数位数（n 为小数点后保留的位数），
            此时也会自动进行四舍五入。
         */
        // %c char
        String formatStr = "我的姓名是%s 年龄是%d 成绩是%.2f 性别是%c";
        String infoFormat = String.format(formatStr,name,age,score,gender);
        System.out.println(infoFormat);
    }
}
