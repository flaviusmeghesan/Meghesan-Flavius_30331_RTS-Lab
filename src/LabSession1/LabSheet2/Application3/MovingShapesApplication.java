package Laboratory1.LabSheet2.Application3;

import Laboratory1.LabSheet2.Application3.MovingSquare;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

class MovingShapesApplication extends JFrame {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private static final int SQUARE_SIZE = 50;
    private static final int MAX_ROUNDS = 3; // Numărul maxim de runde

    private MovingSquare[] squares;
    private int roundCount = 0; // Numărul de runde completate

    public MovingShapesApplication(int[] maxSpeeds) {
        setTitle("Moving Shapes");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        squares = new MovingSquare[3];

        // Add squares to the window
        for (int i = 0; i < 3; i++) {
            MovingSquare square = new MovingSquare("Square" + (i + 1),
                    maxSpeeds[i], WINDOW_WIDTH / 3 * i, 0, SQUARE_SIZE, WINDOW_HEIGHT - SQUARE_SIZE, this);
            add(square);
            squares[i] = square;
        }

        setVisible(true);
    }

    public void startMoving() {
        // Start threads for moving squares
        for (MovingSquare square : squares) {
            Thread thread = new Thread(square);
            thread.start();
        }
    }

    public void checkFinished() {
        boolean allFinished = true;
        for (MovingSquare square : squares) {
            if (!square.isFinished()) {
                allFinished = false;
                break;
            }
        }
        if (allFinished &&roundCount <= MAX_ROUNDS ) {
            restartSquares();
        }

    }

    public void restartSquares() {
        roundCount++;
        if (roundCount <= MAX_ROUNDS) {
            for (MovingSquare square : squares) {
                square.restart();
                Thread thread = new Thread(square);
                thread.start();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Jocul a fost finalizat!");
            // În acest punct, puteți face orice acțiune adițională necesară după ce jocul este finalizat
        }
    }
}