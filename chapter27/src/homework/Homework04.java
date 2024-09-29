package homework;

public class Homework04 {
    public static void main(String[] args) {
        String content = "13888889999";
        boolean matches = content.matches("13[89]\\d{8}");
        System.out.println(matches?"验证成功":"验证失败");
        String str = "hello#abc-jack12smith~北京";
        // 按照 # - ~ 或 数字 分割
        String[] split = str.split("[#\\-~\\d]+");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
