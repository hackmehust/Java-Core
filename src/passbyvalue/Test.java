package passbyvalue;

public class Test {
    public static void modify(Foo x, Foo y) {
        System.out.println("Địa chỉ của x truyền vào: " + x);
        System.out.println("Địa chỉ của y truyền vào: " + y);
        x.num += 1;
        y = new Foo(1);
        System.out.println("Địa chỉ của y sau khi khai báo mới: " + y);
        y.num++;
    }
    public static void main(String[] args) {
        Foo x = new Foo(1);
        System.out.println("Địa chỉ của x: " + x);
        Foo y = new Foo(1);
        System.out.println("Địa chỉ của y: " + y);
        modify(x, y);
        System.out.println("X: " + x.num); // 2
        System.out.println("Y: " + y.num); // 1
    }

}

class Foo {
    public int num;
    public Foo(int num) {
        this.num = num;
    }
}
