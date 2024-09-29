package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 0891
 */
public class RegExp04 {
    public static void main(String[] args) {
//        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";
        String content = "csdj455612321-333999111522csdj121125-2224446663-12323";
//        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        String regStr = "\\d{5}-((\\d)\\2{2}){3}";
//        String regStr = "韩顺平教育|韩顺平老师|韩顺平同学";
//        String regStr = "韩顺平(?:教育|老师|同学)"; // 非捕获分组
//        String regStr = "韩顺平(?=教育|老师)"; // 非捕获分组
//        String regStr = "韩顺平(?!教育|老师)"; // 非捕获分组
//        String regStr = "韩顺平(教育|老师|同学)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        String result = "";
        while (matcher.find()) {
            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
        }
//        String replaceAll = matcher.replaceAll("哈哈哈");
//        result += replaceAll;
//        System.out.println(result);
    }

}
