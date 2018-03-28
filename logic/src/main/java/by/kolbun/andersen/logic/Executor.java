package by.kolbun.andersen.logic;

public class Executor implements Runnable {

    private String name;
    private static boolean blocked = false;
    private int delay = 1000;

    public Executor(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println(name + " starts");
        while (!blocked) {
            System.out.println("Thread " + name + " exec");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " finish");
    }

    public static void setBlocked() {
        blocked = true;
    }
}
