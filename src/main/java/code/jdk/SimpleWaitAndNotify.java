package code.jdk;

/**
 * wait和sleep的共同点和区别
 * 共同点：
 * 都可以暂停线程的执行
 * 区别：
 * 1.wait是Object的方法;sleep是Thread类的方法
 * 2.wait需在同步代码块中，会释放锁；sleep不需要在同步代码块中，不释放锁
 * 3.wait不带参数的方法需要notify唤醒；sleep将在休眠时间结束后自动唤醒继续执行
 */
public class SimpleWaitAndNotify {
    private static final Object object = new Object();

    public static class T1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start! ");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object! ");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end! ");
            }
        }
    }

    public static class T2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread");
                    object.notify();
                    System.out.println(System.currentTimeMillis() + ":T2 end! ");
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        // t2.start();
    }
}
