package Laboratory1.LabSheet2.Application3;

import Laboratory1.LabSheet2.Application2.Fir;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class Window extends JFrame implements Observer {
    final int SQUARE_SIZE = 88;
    ArrayList<Square> squares = new ArrayList<>();

    public Window(int nrThreads) {
        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (int i = 0; i < nrThreads; i++) {
            Square sq = new Square();
            sq.setLocation(50 + i * 100, 0);
            add(sq);
            squares.add(sq);
        }

        setVisible(true);
    }

    public void updateSquarePosition(int id, int newY) {
        Square sq = squares.get(id);
        sq.setLocation(sq.getX(), newY);
        repaint();
    }
    public int getSquareHeight() {
        return SQUARE_SIZE;
    }
    @Override
    public void update(Observable fir, Object arg){

    updateSquarePosition(((Fir)fir).getId(), ((Fir)fir).getC());
    }
}
