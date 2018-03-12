package stream.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author jbzm
 * @Date Create on 2018/3/11 13:09
 */
public class StreamApi {
    /**
     * 通过数组创建
     */
    static void test1() {
        Integer[] lol = {1, 2, 3, 4, 5, 6};
        Stream<Integer> integerStream = Stream.of(lol);
        integerStream.forEach(System.out::println);
    }

    /**
     * 通过list自带的方法创建
     */
    static void test2() {
        List<String> stringList = new ArrayList();
        Stream<String> stream = stringList.stream();
    }

    /**
     * 通过generate创建
     * 无止境的流
     */
    static void test3() {
        Stream<String> generate = Stream.generate(() -> "d");
        generate.forEach(System.out::println);
    }

    /**
     * 通过iterate创建
     * 无止境的流
     */
    static void test4() {
        Stream.iterate(1, x -> x + 1);
    }

    /**
     * 转换字符流
     */
    static void test5() {
        String str = "sdfds";
        IntStream chars = str.chars();
    }

    public static void main(String[] args) {
        Integer integer1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().max((a, b) -> a - b).get();//最大
        Integer integer2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().min((a, b) -> a - b).get();//最小
        Integer integer3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().filter(x -> x / 2 == 0).findFirst().get();//过滤
        Integer integer4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().filter(x -> x / 2 == 0).sorted((a, b) -> a - b).findFirst().get();//过滤并排序
        List<Integer> collect = Stream.iterate(1, x -> x + 1).limit(20).filter(x -> x % 2 == 0).collect(Collectors.toList());//生成20个范围的数组,过滤.重新封装到array  collect 收集器
        Arrays.asList(2, 2, 2, 3, 4, 1, 4, 2, 3, 5, 6, 4, 5, 5, 6).stream().distinct().forEach(System.out::print);//去重
        Arrays.asList(2, 2, 2, 3, 4, 1, 4, 2, 3, 5, 6, 4, 5, 5, 6).stream().collect(Collectors.toSet()).forEach(System.out::print);//set集合自动去重自动排序
        System.out.println();
        Stream.iterate(1, x -> x + 1).limit(50).skip(10).limit(10).forEach(System.out::print);//用skip忽略函数来模拟分页
        String str1 = "11,123,133,123";
        System.out.println();
        int sum = Stream.of(str1.split(",")).mapToInt(Integer::valueOf).sum();//将String流转换为Integer流并且通过sum求和
        String str2 = "tomcat,apach,zookeeper";
        Stream.of(str2.split(",")).map(User::new).forEach(System.out::println);//将String转换为UserStream并且循环调用toString方法输出
        Stream.of(str2.split(",")).map(Persion::build).forEach(System.out::println);//将String转换为PersionStream并且循环调用toString方法输出
        String str3 = "11,123,133,123";

        Stream.of(str3.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).forEach(System.out::print);//peek 用来在执行后面的方法之前修改方法
        System.out.println(integer2);
        System.out.println(integer3);
        System.out.println(integer4);
        System.out.println(collect);
        System.out.println(sum);
    }
}




