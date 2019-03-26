package cn.itcast.demo;

public class ThreadDemo1 {

    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    System.out.println("T1线程");
                }
            }
        });
         t1.start();
        final Thread t2 = new Thread(new Runnable() {

            public void run() {

                try {
                    t1.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
                for (int i = 0; i < 1000; i++) {
                    System.out.println("T2线程");
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 1000; i++) {
                    System.out.println("T3线程");
                }
            }
        });
        t3.start();
    }
}
