package stream.api;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

/**
 * @Author jbzm
 * @Date Create on 2018/3/12 1:37
 */
public class StreamParalel {
    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","5");  //设置内部线程使用数
        //通过打印线程名称查看并行线程，添加parallel（）函数可以开启并行执行命令
        Stream.iterate(1, x -> x + 1).parallel().limit(50).peek(x -> {
            System.out.println(Thread.currentThread().getName());
        }).filter((x) -> x % 2 == 0).peek(x -> {
            System.out.println(Thread.currentThread().getName());
        }).forEach(System.out::print);
    }
}