package LabSession2.Example4;

class ThreadEx extends Thread {
    boolean stop;

    ThreadEx(ThreadGroup tg, String name) {
        super(tg, name);
        stop = false;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " ON.");
        try {
            for (int i = 1; i <= 1000; i++) {
                System.out.println(". "+this.getName());
                Thread.sleep(500);
                synchronized (this) {
                    if (stop){
                        System.out.println("break"+this.getName());    break;}

                    else System.out.println("if "+ this.getName());
                }
            }
        } catch (Exception exc) {
            System.out.println(Thread.currentThread().getName() + " intrerupt.");
        }
        System.out.println(Thread.currentThread().getName() + " The end.");
    }

    public void stopThread() {
        stop = true;
    }
}
