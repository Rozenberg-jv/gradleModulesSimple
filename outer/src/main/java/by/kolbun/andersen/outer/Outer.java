package by.kolbun.andersen.outer;

import by.kolbun.andersen.logic.Executor;

public class Outer {
    public static void main(String[] args) {

        System.out.println("Main thread starts");

        Thread t1 = new Thread(new Executor("T-1", 1200));
        Thread t2 = new Thread(new Executor("T-2", 1300));
        Thread t3 = new Thread(new Executor("T-3", 600));

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Executor.setBlocked();
        System.out.println("Main thread ends");
    }
}
