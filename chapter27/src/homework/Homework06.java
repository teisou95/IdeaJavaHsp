package homework;

public class Homework06 {
    public static void main(String[] args) {
        String content = "-00123.0";
        // 验证是否为整数或小数
        boolean matches = content.matches("^[+-]?(([1-9]\\d*)|0)(\\.\\d+)?$");
        System.out.println(matches ? "验证成功" : "验证失败");
        int i = Integer.parseInt("+0012");
        System.out.println("i = " + i);
        double v = Double.parseDouble("-0023.");
        System.out.println("v = " + v);
    }

}
