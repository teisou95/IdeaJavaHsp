package homework;

public class Homework05 {
    public static void main(String[] args) {
        // 验证邮箱地址
        // 只能有一个@
        // @前面是用户名,可以是 数字 字母 下划线_ 减号-
        // @后面是域名,只能是 字母开头,中间是 字母和点.,以字母结尾,如shou.com tsing.com.cn等
        String add = "kk@sohu.com.cn.hk";
        // Attempts to match the entire region against the pattern.
        boolean matches = add.matches("^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$");
        System.out.println(matches ? "验证成功" : "验证失败");
    }
}
