package homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework01 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入需验证内容:");
//        String content = scanner.next();

        // 验证汉字
//        String regStr = "^[\\u4e00-\\u9fff]+$";
//        String regStr = "^[\u0391-\uffe5]+$";

        // 验证邮政编码 1-9 开头的6位数字
//        String regStr = "^[1-9]\\d{5}$";

        // 验证QQ号 1-9 开头的 5-10位数字
//        String regStr = "^[1-9]\\d{4,9}$";

        // 验证手机号码 13,14,15,18 开头的11位数
//        String regStr = "^1(?:3|4|5|8)\\d{9}$";
//        String regStr = "^1[3458]\\d{9}$";
//        String regStr = "^1[3|4|5|8]\\d{9}$"; // 会匹配到 | ,错误格式

        // 验证有效URL地址
        // https://www.bilibili.com/video/BV1gT4ZeBEJR/?spm_id_from=333.1007.tianma.1-2-2.click&vd_source=da2cc1c48afb4cc41d764b1b78ee9a75
        String content = "https://www.bilibili.com/video/BV1gT4ZeBEJR/?spm_id_from=333.1007.tianma.1-2-2.click&vd_source=da2cc1c48afb4cc41d764b1b78ee9a75";
//        String regStr = "^http[s]*://www\\.\\w+.*\\w$";
        String regStr = "^https?://www\\.[\\w-]+\\.\\w+(/\\S*)?$";


//        Pattern pattern = Pattern.compile(regStr);
        boolean matches = Pattern.matches(regStr, content); // 整体匹配
        System.out.println(matches ? "满足格式" : "不满足格式");
//        Matcher matcher = pattern.matcher(content);
//        if (matcher.find()) {
//            System.out.println("满足格式");
//        } else {
//            System.out.println("不满足格式");
//        }

    }
}
