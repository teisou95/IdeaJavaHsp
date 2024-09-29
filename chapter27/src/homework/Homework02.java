package homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 结巴程序
 */
public class Homework02 {
    public static void main(String[] args) {
        String content = "我...我要...学......学学..学.....学学学.jjj..a.vvvva!";
        System.out.println(content.replaceAll("\\.+", "").replaceAll("(.)\\1+", "$1"));
        // 修改成 我要学java!
        // 1.去除所有的.
//        String regStr = "\\.+";
//        content = content.replaceAll(regStr, "");
//        System.out.println(content);
        // 我我要学学学学学学学jjjavvvva!
        // 2.去除连续重复的字
//        regStr = "(.)\\1*"; // 匹配重复的字符
//        regStr = "(.)\\1+"; // 匹配重复的字符
//        Pattern pattern = Pattern.compile(regStr);
//        Matcher matcher = pattern.matcher(content);
//        String replaceAll = matcher.replaceAll("$1");
//        System.out.println(replaceAll);



//        String newContent = "";
//        while (matcher.find()) {
//            newContent += matcher.group(0).charAt(0);
//        }
//        System.out.println(newContent);
    }
}
