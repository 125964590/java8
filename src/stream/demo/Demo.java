package stream.demo;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.function.IntFunction;
import java.util.stream.Stream;

/**
 * @author zhengyi
 * @date 2019-01-29 13:55
 **/
public class Demo {
    private static int[] i = new int[10];

    private static Semaphore semaphore = new Semaphore(9);

    private IntFunction intFunction = (a) -> {
        System.out.println(semaphore.drainPermits() + "   " + a);
        i[semaphore.drainPermits()] = a;
//            System.out.println(i[semaphore.drainPermits()]);
        semaphore.release();
        return a;
    };

    public static void main(String[] args) {
        Demo demo = new Demo();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach((x) -> demo.intFunction.apply(x));
        Arrays.stream(i).forEach(System.out::print);
    }
}