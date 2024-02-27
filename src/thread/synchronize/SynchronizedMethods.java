package thread.synchronize;

class ShareMemory {
    // Thời gian chờ giữa các luồng khá lớn
    public synchronized void printData(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
        }
    }
}
class WorkingThread extends Thread {
    private ShareMemory mShareMemory;
    private String mThreadName;
    public WorkingThread(ShareMemory sm, String threadName) {
        this.mShareMemory = sm;
        this.mThreadName = threadName;
    }
    @Override
    public void run() {
        mShareMemory.printData(mThreadName);
    }
}

public class SynchronizedMethods {
    public static void main(String[] args) {

        ShareMemory sm = new ShareMemory();
        WorkingThread thread1 = new WorkingThread(sm, "Thread1");
        WorkingThread thread2 = new WorkingThread(sm, "Thread2");
        WorkingThread thread3 = new WorkingThread(sm, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
