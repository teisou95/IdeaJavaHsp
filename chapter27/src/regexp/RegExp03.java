package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符匹配夫
 */
public class RegExp03 {
    public static void main(String[] args) {
//        String content = "a11c8abcABCaBc";
//        String content = "123-abc";
//        String content = "abckkk acbabc jjabc\n哈哈abc ";
        String content = "abckkk acbabc&jjabc哈哈 ";
//        String regStr = "[a-z]";
//        String regStr = "[A-Z]";
//        String regStr = "(?i)[abc]"; // 不区分大小写
//        String regStr = "(?i)abc"; // 不区分大小写
//        String regStr = "abc";
//        String regStr = "[0-9]+";
//        String regStr = "[^a-z]{2}";
//        String regStr = "^[1-9]+\\-[a-z]+$";
        String regStr = "abc\\b";
//        String regStr = "abc\\B";
        Pattern pattern = Pattern.compile(regStr);
//        Pattern pattern = Pattern.compile(re gStr,Pattern.CASE_INSENSITIVE); // 不区分大小写
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
