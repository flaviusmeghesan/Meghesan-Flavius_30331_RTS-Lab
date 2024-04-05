package Laboratory1.LabSheet2.Application3;

import java.util.Observable;
import java.util.Random;

class Fir extends Observable implements Runnable {

    private Thread thread;
    private int id;
    private Window window;
    private boolean running = true;
    private int speed;
    int priority;

    Fir(int id, int priority, Window win) {
        this.id = id;
        this.priority = priority;
        this.window = win;
        Random rand = new Random();
        this.speed = rand.nextInt(5) + 1;
    }

    @Override
    public void run() {
        int windowHeight = window.getHeight();
        int squareHeight = window.getSquareHeight();
        int y = 0;

        while (y + squareHeight <= windowHeight && running) {
            y += speed;
            window.updateSquarePosition(id, y);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
        stop();
    }
    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.setPriority(this.priority);
            thread.start();
        }
    }
    public void stop() {
        running = false;
        if (thread != null) {
            thread.interrupt();
        }
    }
}
