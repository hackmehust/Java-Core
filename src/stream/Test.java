package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> result = Stream.of("bạn", "hãy", "like", "Fanpage", "loda","dể","cập","nhật","nhiều","hơn")
                .filter(s -> {
                    System.out.println("[filtering] " + s);
                    return s.length()>=4;
                })
                .map(s -> {
                    System.out.println("[mapping] " + s);
                    return s.toUpperCase();
                })
                .limit(3)
                .toList(); // .collect(Collectors.toList());
        System.out.println("----------------------");
        System.out.println("Result:");
        result.forEach(System.out::println);

        Stream<String> stream =
                Stream.of("loda", ".", "me","like").filter(element -> element.contains("e"));
        Optional<String> anyElement = stream.findAny(); //Lấy ra một phần tử bất kỳ trong Stream, nó sẽ trả ra Optional

        stream.forEach(s -> System.out.println(s));

        // Thực hiện dòng lệnh tiếp theo sẽ bắn ra IllegalStateException
//        Optional<String> firstElement = stream.findFirst();
    }
}
