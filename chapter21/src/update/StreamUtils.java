package update;

import java.io.*;

/**
 * 工具类
 */
public class StreamUtils {

    /**
     * @param is 字节输入流
     * @return 字节数组
     * @throws IOException
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(buf)) != -1) {
            bos.write(buf, 0, readLen);
        }
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    /**
     * @param is 输入流
     * @return 字符串
     * @throws IOException
     */
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }
}
