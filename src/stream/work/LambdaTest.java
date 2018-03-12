package stream.work;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author jbzm
 * @Date Create on 2018/3/13 0:41
 */
public class LambdaTest {
    @Test
    public void test1() {
        String str = "token=14312lk3jiojoj12oi3j&id=sldfjiowe12312&name=1293uu89&work=12lk3j2io";
        Map<String, String> collect = Stream.of(str.split("&")).map(x -> x.split("=")).collect(Collectors.toMap(x -> x[0], x -> x[1]));
        System.out.println(collect);
    }

    @Test
    public void test2() {
        List<Integer> collect = books().stream().map(Book::getId).collect(Collectors.toList());
        System.out.println(collect);
        String collect1 = books().stream().map(x -> x.getId() + "").collect(Collectors.joining(","));
        System.out.println(collect1);
        String collect2 = books().stream().map(x -> x.getId() + "").collect(Collectors.joining(",", "(", ")"));
        System.out.println(collect2);
        String collect3 = books().stream().map(x -> "'" + x.getId() + "'").collect(Collectors.joining(",", "(", ")"));
        System.out.println(collect3);
    }

    /**
     * 通过比较器进行多次比较然后对结果进行再次比较后排序
     */
    @Test
    public void test3() {
        long a = System.currentTimeMillis();
        books().stream().parallel().sorted(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPublishDate)).reversed()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(System.currentTimeMillis()-a);
        long l = System.currentTimeMillis();
        books().stream().sorted(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPublishDate)).reversed()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(System.currentTimeMillis()-l);
    }
    /**
     * 通过比较器来求出最大值，也可以求出平均值
     */
    @Test
    public void test4(){
        books().stream().max(Comparator.comparing(Book::getPrice).thenComparing(Book::getPublishDate));
    }

    /**
     * 分组后进行排序
     */
    @Test
    public void test5(){
        Map<String, List<Book>> collect = books().stream().collect(Collectors.groupingBy(Book::getType));
        System.out.println(collect);
        Map<Double, Optional<Book>> collect1 = books().stream().collect(Collectors.groupingBy(Book::getPrice, Collectors.maxBy(Comparator.comparing(Book::getPublishDate))));
        System.out.println(collect1);
    }

    /**
     * 对数据进行过滤之后排序
     */
    @Test
    public void test6(){
        books().stream().filter(x->x.getPrice()==20d).sorted(Comparator.comparing(Book::getPublishDate)).forEach(System.out::println);
    }

    private List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "tomcat1", 20d, "1", LocalDate.parse("2014-05-11")));
        books.add(new Book(2, "tomcat2", 13d, "2", LocalDate.parse("2014-05-12")));
        books.add(new Book(3, "tomcat3", 24d, "3", LocalDate.parse("2014-05-13")));
        books.add(new Book(4, "tomcat4", 74d, "3", LocalDate.parse("2014-05-14")));
        books.add(new Book(5, "tomcat5", 20d, "2", LocalDate.parse("2014-05-15")));
        books.add(new Book(6, "tomcat6", 42d, "6", LocalDate.parse("2014-05-16")));
        books.add(new Book(6, "tomcat6", 20d, "1", LocalDate.parse("2014-05-17")));
        books.add(new Book(6, "tomcat6", 31d, "6", LocalDate.parse("2014-05-18")));
        return books;
    }
}
