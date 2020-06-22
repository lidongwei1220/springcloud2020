import java.time.ZonedDateTime;

/**
 * @author 李东薇
 * @date 2020/6/19 15:14
 */
public class T1 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//默认时区
        System.out.println(zonedDateTime);
    }
}
