package Laboratory1.LabSheet2.Application3;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

class MovingSquare extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;

    private int maxSpeed;
    private static final Random random = new Random();
    private String name;
    private int minY;
    private int maxY;
    private boolean stop = false;
    private boolean finished = false;
    private MovingShapesApplication app;

    public MovingSquare(String name, int maxSpeed, int x, int y, int size, int maxY, MovingShapesApplication app) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        setBounds(x, y, size, size);
        setBackground(Color.BLUE);
        this.minY = size;
        this.maxY = maxY - size;
        this.app = app;
    }

    @Override
    public void run() {
        while (!stop) {
            int speed = random.nextInt(maxSpeed) + 1;
            setLocation(getX(), getY() + speed);
            if (getY() > maxY) {
                stop = true;
                finished = true;
                app.checkFinished(); // Verificăm dacă toate pătratele au terminat

            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public void restart() {
        stop = false;
        finished = false;
        setLocation(getX(), minY);
    }
}