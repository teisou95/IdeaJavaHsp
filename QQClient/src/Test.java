import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);

    }
}
