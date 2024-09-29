package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式底层实现
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "199820023年12月8日，第二代Java平台的企业版J2EE发布。" +
                "1999年6月，Sun公司发布了第二代Java平台（简称为Java2）的3个版本：" +
                "J2ME（Java2 Micro Edition，Java2平台的微2551型版），应用于移5775动、无线及3652有限资源的环境" +
                "；J2SE（Java 2 Standard Edition，Java 2平台的254196标准版），应用于桌面环境；" +
                "J2EE（Java 2Enterprise Edition，Java 2平台的企业版）1221，应用于基于Java的应用服务器。" +
                "Java 2平台的发布，是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。9889";
        String regStr = "(\\d\\d)((\\d)\\d)"; // \\d 表达一个任意的数字
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String s = matcher.group(0); // 按小括号分组,0代表全部,1第一组,2第二组,3第三组
            System.out.println("第0组: " + matcher.group(0));
            System.out.println("第1组: " + matcher.group(1));
            System.out.println("第2组: " + matcher.group(2));
            System.out.println("第3组: " + matcher.group(3));
        }
    }
}
