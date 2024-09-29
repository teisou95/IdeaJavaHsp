package homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework07 {
    public static void main(String[] args) {
        // 解析 url
        // https://www.sohu.com:8080/abc/index.htm
        // 协议 http
        // 域名 www.sohu.com
        // 端口 8080
        // 文件名 index.htm
        String url = "https://www.sohu.kk.lll.com:80859/dsfj/fds4^&3////index.htm";
        String regStr = "^(?<xieyi>https?)://(?<yuming>www(?:\\.[a-zA-Z0-9]+){2,}):(?<duankou>\\d+)[\\S]*/(?<wenjianming>[a-zA-Z0-9]+\\.[a-zA-Z]+)$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(url);
        if (matcher.matches()) {
            System.out.println("整体匹配成功");
            System.out.println("协议: " + matcher.group("xieyi"));
            System.out.println("域名: " + matcher.group("yuming"));
            System.out.println("端口: " + matcher.group("duankou"));
            System.out.println("文件名: " + matcher.group("wenjianming"));
        } else {
            System.out.println("整体匹配失败");
        }
//        String regStr = "https?";
//        Pattern pattern = Pattern.compile(regStr);
//        Matcher matcher = pattern.matcher(url);
//        while (matcher.find()) {
//            String s = matcher.group(0);
//            System.out.println("协议 = " + s);
//        }
//
//        regStr = "www(\\.[a-zA-Z]+){2,}";
//        pattern = Pattern.compile(regStr);
//        matcher = pattern.matcher(url);
//        while (matcher.find()) {
//            String s = matcher.group(0);
//            System.out.println("域名 = " + s);
//        }
//
//        regStr = "(?<=:)\\d+(?=/)";
//        pattern = Pattern.compile(regStr);
//        matcher = pattern.matcher(url);
//        while (matcher.find()) {
//            String s = matcher.group(0);
//            System.out.println("端口 = " + s);
//        }
//
//        regStr = "(?<!//)((?<=/)[a-zA-z]+\\.[a-zA-z]+)\\b";
//        pattern = Pattern.compile(regStr);
//        matcher = pattern.matcher(url);
//        while (matcher.find()) {
//            String s = matcher.group(0);
//            System.out.println("文件名 = " + s);
//        }
    }
}
