package collector.module;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jbzm
 * @date 2019-04-23 21:09
 */
public class Menu {
    private Integer id;
    private String name;
    private Integer money;
    private Integer heat;
    private Integer type;

    public static List<Menu> collect =
            Stream.generate(
                            () -> {
                                Menu menu = new Menu();
                                menu.setId(new Random().nextInt(10000));
                                menu.setHeat(new Random().nextInt(200));
                                menu.setMoney(new Random().nextInt(100));
                                menu.setType(new Random().nextInt(5));
                                menu.setName(Menu.getRandomString(5));
                                return menu;
                            })
                    .limit(100)
                    .collect(Collectors.toList());

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    @Override
    public String toString() {
        return "Menu{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", money="
                + money
                + ", heat="
                + heat
                + ", type="
                + type
                + '}';
    }
}
