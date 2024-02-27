package oop;

import java.util.ArrayList;
import java.util.List;

public class Static {
    private static String subject;

    List<String> s = new ArrayList<>();

    static {
        System.out.println("Khối static được gọi");
    }

    public void setSubject(String subject) {
        this.subject = subject;
        this.in();
    }

    public void in() {
        System.out.println(subject);
    }

    Static () {
        System.out.println("hàm main() được gọi");
        subject = "Khối static (static blocks)";
//        this.setSubject("Khối static (static blocks)");
        System.out.println("Subject = " + subject);
    }

    public static void main(String[] args) {
        Static ex1 = new Static();

        Static ex2 = new Static();
        ex2.setSubject("Tự ý thay đổi");
    }
}
