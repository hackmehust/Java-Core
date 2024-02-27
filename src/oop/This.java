package oop;

public class This {
    private int id;

    private String website;

    private String subject;

    public This() {
        this.id = 1;
    }

    public This setWebsite(String website) {
        this.website = website;
        return this;
    }

    public This setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public void print() {
        System.out.println("Id = " + id);
        this.printWebsite();
        this.printSubject();
    }

    private void printWebsite() {
        System.out.println("Subject = " + subject);
    }

    private void printSubject() {
        System.out.println("Website = " + website);
    }

    public static void main(String[] args) {
        This ex1 = new This()
                .setSubject("OOP")
                .setWebsite("gpcoder.com");
//        This ex1 = new This();
//        ex1.setSubject("A");
//        ex1.setWebsite("B");
        ex1.print();
    }

}
