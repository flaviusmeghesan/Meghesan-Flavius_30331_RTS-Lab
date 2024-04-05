package Laboratory1.LabSheet2.Application3;

public class Square {
    private int x, y, size, speed;

    public Square(int x, int y, int size, int minSpeed, int maxSpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        // Random speed between minSpeed and maxSpeed.
        this.speed = minSpeed + (int)(Math.random() * ((maxSpeed - minSpeed) + 1));
    }

    public void move() {
        y += speed;
    }

    // Getters and setters for x, y, size, speed.
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


