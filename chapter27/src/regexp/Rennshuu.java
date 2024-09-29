package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Rennshuu {
    public static void main(String[] args) {
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。" +
                "1999年6月，Sun公司发布了第二代Java平台（简称为Java2）的3个版本：" +
                "J2ME（Java2 Micro Edition，Java2平台的微2551型版），应用于移5775动、无线及3652有限资源的环境" +
                "；J2SE（Java 2 Standard Edition，Java 2平台的标准版），应用于桌面环境；" +
                "J2EE（Java 2Enterprise Edition，Java 2平台的企业版）1221，应用于基于Java的应用服务器。" +
                "Java 2平台的发布，是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。9889";
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String s = matcher.group(0);
            if (s.length() == 4 && s.charAt(0) == s.charAt(3) && s.charAt(1) == s.charAt(2)) {
                System.out.println(s);
            }
        }
    }
}
