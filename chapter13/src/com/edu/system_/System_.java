package com.edu.system_;

import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {
        // exit 退出程序
        System.out.println("ok1");
//        System.exit(0); // 0 ,状态值 代表正常退出
        System.out.println("ok2");

        // arraycopy 复制数组元素 适合底层调用
        // 一般使用 Arrays.copyOf
        /*
         * @param      src      the source array. 源数组
         * @param      srcPos   starting position in the source array. 源数组索引开始位置
         * @param      dest     the destination array. 目的数组
         * @param      destPos  starting position in the destination data. 目的数组索引开始位置
         * @param      length   the number of array elements to be copied.  拷贝长度
         */
        int[] src = {1, 2, 3};
        int[] dest = new int[3]; // {0,0,0}
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println(Arrays.toString(dest));
        System.out.println(Arrays.toString(Arrays.copyOf(src,2)));

        // currentTimeMillis 返回毫秒数(距离1970-1-1)
        Long times = System.currentTimeMillis();
        System.out.println(times);
    }
}
