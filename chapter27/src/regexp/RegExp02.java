package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 转义字符
 */
public class RegExp02 {
    public static void main(String[] args) {
        String content = "abc$(58a.bc(12哈hh2589kdas哈3(";
        // 匹配 (
        String regStr = "\\W+\\d{2}"; // + 代表1~多
//        String regStr = "\\W"; // [^0-9a-zA-Z]
//        String regStr = "\\w"; // [0-9a-zA-Z]
//        String regStr = "\\D(\\d)*"; // 单个非数字开头,后街任意个数的数字
//        String regStr = "\\D"; // 匹配单个非数字字符
//        String regStr = "\\d{2}(\\d)?"; // 数字字符,匹配2个或3个数字的字符串
//        String regStr = "a..c"; // . 匹配除\n之外任何字符
//        String regStr = "[a-h]"; // 连字符
//        String regStr = "[ab哈]"; // 可接受字符列表
//        String regStr = "[^abc]"; // 不接受字符列表
//        String regStr = "\\(";
//        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
