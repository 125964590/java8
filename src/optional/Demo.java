package optional;

import optional.module.Essay;

import java.util.Optional;

/**
 * @author jbzm
 * @date 3/19/20 3:36 PM
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Object o =
                Optional.ofNullable(test(2))
                        .orElseThrow(
                                () -> {
                                    return new ExceptionInInitializerError("12");
                                });
        System.out.println(o);
    }

    public void createOptional() {
        Optional<Essay> empty = Optional.empty();
        Optional<Essay> essayOptional = Optional.of(new Essay());
        Essay essay = null;
        Optional<Essay> essayNullOptional = Optional.ofNullable(essay);
    }

    public static Object test(int a) throws Exception {
        if (a == 2) {
            throw new Exception("lol");
        }
        return 1;
    }
}
