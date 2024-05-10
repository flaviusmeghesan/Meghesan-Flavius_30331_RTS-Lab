package Laboratory1.LabSheet2.Application3;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int[] maxSpeeds = {6, 8, 7};
            MovingShapesApplication app = new MovingShapesApplication(maxSpeeds);
            app.startMoving();
        });
    }
}

