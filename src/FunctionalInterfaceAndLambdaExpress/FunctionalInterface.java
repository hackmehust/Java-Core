package FunctionalInterfaceAndLambdaExpress;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {
        Consumer<Integer> print = num -> System.out.println(num);
        print.accept(3);

        Function<String, Integer> getLength = str -> str.length();
        System.out.println(getLength.apply("John Doe")); // 8

        Predicate<Integer> checkAge = age -> age > 18;
        System.out.println(checkAge.test(10)); // false

        Supplier<Double> generate = () -> Math.random();
        System.out.println(generate.get()); // Số random nào đó
    }
}
