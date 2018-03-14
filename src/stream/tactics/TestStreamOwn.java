package stream.tactics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jbzm
 * @date Create on 2018/3/13 22:26
 */
public class TestStreamOwn {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("red", 16)
                , new Apple("blue", 13)
                , new Apple("green", 23)
                , new Apple("red", 9)
                , new Apple("red", 24)
                , new Apple("blue", 17));
        AppleFilter<List<Apple>> listAppleFilter = new AppleFilter<>();
        listAppleFilter.filterColor(x -> {
            List<Apple> collect = x.stream().sorted(Comparator.comparing(Apple::getWeight)).collect(Collectors.toList());
            List<Apple> collectChanged = collect.stream().map(y -> new Apple(y.getColor(), y.getWeight() + 5)).collect(Collectors.toList());
            return collectChanged;
        }, apples, "red");
        listAppleFilter.filterWeight(x -> {
            List<Apple> collect = x.stream().sorted(Comparator.comparing(Apple::getWeight)).collect(Collectors.toList());
            List<Apple> collectChanged = collect.stream().map(y -> new Apple(y.getColor(), y.getWeight() + 5)).collect(Collectors.toList());
            return collectChanged;
        }, apples, 15);
    }


    interface FilterLol<T> {
        void filterColor(Function<T, T> filter, List<Apple> apples, String color);

        void filterWeight(Function<T, T> filter, List<Apple> apples, Integer weight);
    }

    static class AppleFilter<T> implements FilterLol<T> {

        @Override
        public void filterColor(Function<T, T> filter, List<Apple> apples, String color) {
            List<Apple> collect = apples.stream().filter(x -> (color).equals(x.getColor())).collect(Collectors.toList());
            T apply = filter.apply((T) collect);
            System.out.println(apply);
            System.out.println("入库  apples");
        }

        @Override
        public void filterWeight(Function<T, T> filter, List<Apple> apples, Integer weight) {
            List<Apple> collect = apples.stream().filter(x -> weight>x.getWeight()).collect(Collectors.toList());
            T apply = filter.apply((T) collect);
            System.out.println(apply);
            System.out.println("入库  apples");
        }

    }

    static class Apple {
        private String color;
        private Integer weight;

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }

        Apple(String color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }
}
