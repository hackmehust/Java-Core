package lazy_evaluation;

import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
        System.out.println("log1");
        log(false, getMessage());
        log(true, getMessage());

        System.out.println("log2");
        log2(false, () -> getMessage());
        log2(true, Test::getMessage);
    }

    public static String getMessage() {
        System.out.println("Retrieving message...");
        return "Hello world";
    }

    // Thường thì có log level, mà ở đây dùng boolean cho dễ
    public static void log(boolean enabled, String message) {
        if (enabled)
            System.out.println(message);
    }

    public static void log2(boolean enable, Supplier<String> message) {
        if (enable)
            System.out.println(message.get());
    }
}
