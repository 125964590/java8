package collector.group;

import collector.module.Menu;
import org.junit.Test;

import java.util.stream.Collectors;

import static collector.module.Menu.collect;

/**
 * @author jbzm
 * @date 2019-04-23 21:08
 */
public class GroupByMultistageGroup {


    /** 测试分组功能,按照类型分组 */
    @Test
    public void test01() {
        collect.stream()
                .collect(Collectors.groupingBy(Menu::getType))
                .forEach((key, value) -> System.out.printf("%s,%s\n", key, value));
    }

    /** 测试根据指定函数进行分组 */
    @Test
    public void test02() {
        collect.stream()
                .collect(
                        Collectors.groupingBy(
                                (element -> {
                                    if (element.getMoney() < 25) {
                                        return "便宜";
                                    } else if (25 < element.getMoney() && element.getMoney() < 75) {
                                        return "中等";
                                    } else {
                                        return "贵";
                                    }
                                })))
                .forEach((key, value) -> System.out.printf("%s,%s\n", key, value));
    }

    /** 嵌套分组,在分组之后继续分组 */
    @Test
    public void test03() {
        collect.stream()
                .collect(
                        Collectors.groupingBy(
                                Menu::getType,
                                Collectors.groupingBy(
                                        element -> {
                                            if (element.getMoney() < 25) {
                                                return "便宜";
                                            } else if (25 < element.getMoney()
                                                    && element.getMoney() < 75) {
                                                return "中等";
                                            } else {
                                                return "贵";
                                            }
                                        })))
                .forEach(
                        (key, value) -> {
                            System.out.println(key);
                            value.forEach(
                                    (keyA, valueA) -> System.out.printf("%s,%s\n", keyA, valueA));
                        });
    }
}
