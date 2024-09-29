package utils;

import java.util.Scanner;

/**
 * 业务层
 * 工具类,完成获取用户各种输入
 * 1.首先准备工具类(实际开发中有工具类开发库)
 * 2.处理各种情况的用户输入,能够按照程序员的需求,得到用户的控制台输入
 * 3.静态方法可以直接通过类名调用,不需要创建对象
 */
// static 方法属于类，而不是类的实例。它们可以通过类名直接调用，而不需要创建类的对象。
// 例如，Math.sqrt() 就是一个 static 方法。
// static 方法不能直接访问类的实例变量或实例方法。它只能访问类的 static 变量和调用其他 static 方法。
// static 方法通常用于那些不依赖于对象的状态或行为的方法，比如工具类中的方法（如 Math 类中的方法）。
// 可以通过类名调用：ClassName.staticMethod()。
// 也可以通过实例调用，但这不推荐：instance.staticMethod()。
//
// 实例方法（非 static 方法）:
// 实例方法属于类的实例（对象）。你必须创建类的对象才能调用实例方法。
// 实例方法可以访问类的实例变量和其他实例方法。它也可以访问 static 变量和方法。
// 实例方法用于那些需要依赖于对象的状态和行为的方法。
// 调用方式:必须通过对象调用。
public class Utility {
    // 静态属性
    private static Scanner scanner = new Scanner(System.in);


    /**
     * 功能: 读取一个字符串
     *
     * @param limit       限制读取的长度
     * @param blankReturn 如果为 true ,表示 可以读空字符串
     *                    如果为 false,表示 不能读空字符串
     *                    <p>
     *                    如果输入为空,或者输入长度超过 limit,就提示重新输入
     * @return 读取到的字符串
     */
    public static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        // 判断有没有下一行,主要用于文件输入判断,键盘输入的情况下可以改为 while(true)
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    System.out.println("输入不能为空,请重新输入:");
                    continue; // 循环读取,直至不为空
                }
            }
            if (line.length() > limit) {
                System.out.println("输入长度不能超过 " + limit + " ,请重新输入:");
                continue;
            }
            break;
        }
        return line;
    }


    /**
     * 功能: 读取键盘输入的一个菜单选项,值: 1~6的范围
     *
     * @return 1~6
     */
    public static char readMenuSelection() {
        System.out.println("请输入选择(1~6):");
        char c = 0;
        while (true) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c!= '6') {
                System.out.println("输入必须是1~6,请重新输入:");
                continue;
            }
            break;
        }
        return c;
    }

    /**
     * 功能：读取键盘输入的一个字符
     *
     * @return 一个字符
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 功能：读取键盘输入的一个字符，如果直接按回车，则返回指定的默认值；否则返回输入的那个字符
     *
     * @param defaultValue 指定的默认值
     * @return 默认值或输入的字符
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return str.length() == 0 ? defaultValue : str.charAt(0);
    }

    /**
     * 功能：读取键盘输入的整型，长度小于10位
     *
     * @return 整数
     */
    public static int readInt() {
        int n = 0;
        while (true) {
            String str = readKeyBoard(10, false);
            try {
                n = Integer.parseInt(str); // 尝试字符串转为整数
                break;
            } catch (NumberFormatException e) { // 抛出 数字格式错误 异常
                System.out.println(e.getMessage()); // 打印异常信息
                System.out.println("数字输入错误,请重新输入:");
            }
        }
        return n;
    }

    /**
     * 功能：读取键盘输入的 整数或默认值，如果直接回车，则返回默认值，否则返回输入的整数
     *
     * @param defaultValue 指定的默认值
     * @return 整数或默认值
     */
    public static int readInt(int defaultValue) {
        int n = 0;
        while (true) {
            String str = readKeyBoard(10, true);
            if (str.length() == 0) { // 输入为空
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str); // 尝试字符串转为整数
                break;
            } catch (NumberFormatException e) { // 抛出 数字格式错误 异常
                System.out.println(e.getMessage()); // 打印异常信息
                System.out.println("数字输入错误,请重新输入:");
            }
        }
        return n;
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串
     *
     * @param limit 限制的长度
     * @return 指定长度的字符串
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串或默认值，如果直接回车，返回默认值，否则返回字符串
     *
     * @param limit        限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.length() == 0 ? defaultValue : str;
    }

    /**
     * 功能：读取键盘输入的确认选项，Y或N
     * 将小的功能，封装到一个方法中.
     *
     * @return Y或N
     */
    public static char readConfirmSelection() {
        char c = 0;
        while (true) {
            String str = readKeyBoard(1, false);
            c = str.toUpperCase().charAt(0); // 转为大写字母
            if (c != 'Y' && c != 'N') {
                System.out.println("选择有误,请重新输入:");
                continue;
            }
            break;
        }
        return c;
    }
}
