package FunctionalInterfaceAndLambdaExpress;

import java.util.function.Predicate;

public class MethodReference {
    public boolean checkAge(int age) {
        return age > 18;
    }

    public static boolean checkAgeStatic(int age) {
        return age > 18;
    }

    Predicate<Integer> firstCheck = new MethodReference()::checkAge;
    Predicate<Integer> secondCheck = MethodReference::checkAgeStatic;
}


