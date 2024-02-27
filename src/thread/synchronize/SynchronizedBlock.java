package thread.synchronize;

public class SynchronizedBlock {
    public void printData(String threadName) {
        // Do Something before synchronized ...
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + ": " + i);
            }
        }
    }
}
