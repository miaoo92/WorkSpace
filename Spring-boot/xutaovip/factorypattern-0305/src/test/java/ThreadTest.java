import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    static Thread thread1 = new Thread(new Runnable() {
        public void run() {
            System.out.println("thread1");
        }
    });

    static Thread thread2 = new Thread(new Runnable() {
        public void run() {
            System.out.println("thread2");
        }
    });

    static Thread thread3 = new Thread(new Runnable() {
        public void run() {
            System.out.println("thread3");
        }
    });

    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();
//        thread3.start();
        //通过join()的方式，控制线程的执行顺序。
        //join()：让主线程等待子线程结束以后才能继续执行

        executor.submit(thread1);
        executor.submit(thread2);
        executor.submit(thread3);
        executor.shutdown();
        //创建只有一个线程的线程池来操作，不限数量的队列，把线程放进一个队列中
    }

}
