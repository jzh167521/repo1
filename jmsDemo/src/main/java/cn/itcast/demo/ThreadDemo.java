package cn.itcast.demo;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                for (int i = 0; i < 10; i++) {

                    System.out.println("我是子线程-------------");
                }
            }
        });
        //thread.setDaemon(true); // 设置子线程是不是守护线程 如果设置了是守护线程那么主线程执行完毕子线程就不会执行
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程");
        }
        System.out.println("主线程执行完毕");
    }
}
