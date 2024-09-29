package com.edu.byteIOstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流
 * 将数据写入文件
 */
public class FileOutputStream01 {
    public static void main(String[] args) {
        String filePath = "D:\\a.txt";
        File file = new File(filePath);
        FileOutputStream fileOutputStream = null;
        String str = "hello,word!哈哈";
        try {
            File parentFile = file.getParentFile();
            if (parentFile.exists()) {
                fileOutputStream = new FileOutputStream(filePath,false);
                // true追加模式,false覆盖模式(会清除原数据)
//                fileOutputStream.write(454785);
//                fileOutputStream.write('H');
//                fileOutputStream.write(new byte[]{'h','e'});
                fileOutputStream.write(str.getBytes()); // 字符串转为字节数组
//                fileOutputStream.write(str.getBytes(),0,str.length()); // 汉字字符不正常输出
                // 会自动创建文件(前提是目录存在)
                System.out.println("写入成功");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close(); // close等价于 flush + close,底层还是调用 FileOutputStream 按字节写入的
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
