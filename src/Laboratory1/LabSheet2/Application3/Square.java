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
}
