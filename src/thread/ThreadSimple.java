package thread;

public class ThreadSimple extends Thread {
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        ThreadSimple t1 = new ThreadSimple();
        t1.run();
//        t1.start();
    }
}

// .start() sẽ cấp phát tài nguyên cho luồng mới rồi chạy phương thức run().
// Nếu gọi run() tương đương như gọi phương thức bthg. Không tạo ra luồng mới.
