// 快捷键
// delete ctrl+Y
// duplicate ctrl+D
// 补全代码 alt+/
// 注释 ctrl+/
// auto import alt+enter
// format code crtl+alt+L
// run alt+R
// 生成构造器 generate alt+insert
// 查看类的层级关系 ctrl+H
// 定位方法 ctrl+B
// 自动分配变量名 +.var

public class ArrayTest {
    // 使用模板
    public static void main(String[] args) {
        Mytools mytools = new Mytools();
        int[] arr = {1, 2, 4, 3, 8, 0, -5, 7, 10};
        mytools.bubble(arr); // 引用传递
        // 在 idea 当 run 文件时,会先编译成 .class 文件再运行
    }
}

// 创建一个Mytools 类,编写一个方法,可以完成对 int 数组的冒泡排序
class Mytools {

    public void bubble(int[] arr) {
        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) { // 外层循环
            for (int j = 0; j < arr.length - 1 - i; j++) { // 内层循环
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序完毕");
        printArr(arr);
    }

    public void printArr(int[] arr) {
        System.out.println("数组打印如下:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}