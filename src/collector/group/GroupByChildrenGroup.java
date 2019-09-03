package collector.group;

import collector.module.Menu;
import org.junit.Test;

import java.util.stream.Collectors;

import static collector.module.Menu.collect;

/**
 * @author jbzm
 * @date 2019-04-23 22:06
 */
public class GroupByChildrenGroup {

    /** 在分组的基础上使用收集器 */
    @Test
    public void test01() {
        collect.stream()
                .collect(Collectors.groupingBy(Menu::getType, Collectors.counting()))
                .forEach((key, value) -> System.out.printf("%s,%s\n", key, value));
    }
}
