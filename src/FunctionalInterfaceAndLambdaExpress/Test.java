package FunctionalInterfaceAndLambdaExpress;

public class Test {
    public static void main(String[] args) {

        // C1: Cách cũ
        MyInterface myInterface1 = new MyInterface() {
            @Override
            public void myMethod() {
                System.out.println("Hello");
            }
        };

        // C2: Sử dụng Lambda
        MyInterface myInterface2 = () -> {
            System.out.println("This is an anonymous function.");
        };

        // Sử dụng method Reference
        MyInterface myInterface3 = Test::helloWord;
        GenString genString1 = Test::changeName;

        // Nếu không sử dụng
        MyInterface myInterface4 = () -> Test.helloWord();
        GenString genString2 = a -> changeName(a);

        GenString genString3 = s -> s.toUpperCase();
        GenString genString4 = String::toUpperCase;

        System.out.println(genString3.myMethod("Thang"));
    }

    public static String helloWord() {
        return "Hello World";
    }

    public static String changeName(String c) {
        return c;
    }
}


interface MyInterface {
    void myMethod();
}

interface GenString {
    String myMethod(String name);
}