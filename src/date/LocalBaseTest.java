package date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author jbzm
 * @date 2019-07-30 17:23
 */
public class LocalBaseTest {
    @Test
    public void test01() {
        LocalDate of = LocalDate.of(2019, 7, 30);
        System.out.println(of.getYear());
        System.out.println(of.getMonth());
        System.out.println(of.getDayOfWeek());
        System.out.println(of.getDayOfMonth());
    }

    @Test
    public void getNew(){
        System.out.println(LocalDate.now());
    }

    @Test
    public void getByFormatter(){
        LocalDate parse = LocalDate.parse("2019-01-02");
        LocalTime parse1 = LocalTime.parse("12:23:01");
        System.out.println(parse);
        System.out.println(parse1);
        System.out.println(parse.getDayOfWeek());
        System.out.println(parse1.getHour());
    }
}
