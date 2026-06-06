package concurrency;

/**
 * 多线程基础示例
 */
public class ThreadDemo {
    
    /**
     * 方式1: 继承Thread类
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 方式2: 实现Runnable接口
     */
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Runnable: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // 启动线程
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());
        
        t1.start();
        t2.start();
        
        // 主线程
        for (int i = 0; i < 5; i++) {
            System.out.println("Main: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
