class StepThread extends Thread {

    // общий для всех потоков lock
    private Object lock;

    public StepThread(Object object) {
        this.lock = object;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(currentThread().getName() + " wrote its' name");
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class NameByName {
    public static void main(String[] strings) {
        Object lock = new Object();
        StepThread thread1 = new StepThread(lock);
        thread1.start();
        new StepThread(lock).start();
        new StepThread(lock).start();

    }
}