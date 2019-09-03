package date;

import org.junit.Test;

import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jbzm
 * @date 2019-07-30 17:32
 */
public class LocalDateTimeTest {

    @Test
    public void mergeDateTime() {
        LocalDateTime of = LocalDateTime.of(2019, 7, 30, 12, 32, 44);
        System.out.println(of.getMonth());
        LocalDate parse = LocalDate.parse("2019-01-02");
        LocalTime parse1 = LocalTime.parse("12:23:01");
        LocalDateTime of1 = LocalDateTime.of(parse, parse1);
        System.out.println(of1.getMonth());
    }

    @Test
    public void test01() {
        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault());
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth().getValue());
    }

    @Test
    public void test02() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Integer, List<Integer>> collect = integers.stream().collect(Collectors.groupingBy(k -> k));
    }
}
