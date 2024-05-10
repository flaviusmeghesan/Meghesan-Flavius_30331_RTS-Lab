package LabSession2.Example4;

public class ThreadGroupDemo {
    public static void main(String args[]) throws Exception {
        ThreadGroup tg = new ThreadGroup("Group of threads");
        ThreadEx fir1 = new ThreadEx(tg, "ThreadEx #1");
        ThreadEx fir2 = new ThreadEx(tg, "ThreadEx #2");
        ThreadEx fir3 = new ThreadEx(tg, "ThreadEx #3");
        fir1.start();
        fir2.start();
        fir3.start();
        Thread.sleep(1000);
        System.out.println(tg.activeCount() + " Thread in group.");
        Thread threads[] = new Thread[tg.activeCount()];
        tg.enumerate(threads);
        for (Thread t : threads) {
            System.out.println(t.getName());
        }
        fir1.stopThread();
        Thread.sleep(1000);
        System.out.println(tg.activeCount() + " Thread in group.");
        tg.interrupt();
    }
}

