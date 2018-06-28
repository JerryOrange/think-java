/**
 * 同步静态方法
 *
 * Created by Jiacheng on 2018/6/28.
 */
public class SynchronizedStatic {

    public static synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public static synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedStatic test = new SynchronizedStatic();
        final SynchronizedStatic test2 = new SynchronizedStatic();
        new Thread(() -> method1()).start();
        new Thread(() -> method2()).start();
    }
}
