package Laboratory1.LabSheet2.Application2;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

class View extends JFrame implements Observer {
    private ArrayList<JProgressBar> bars;

    public View(int nrThreads) {
        bars = new ArrayList<>();
        setLayout(null);
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        setVisible(true);
    }

    private void init(int n) {
        for (int i = 0; i < n; i++) {
            JProgressBar pb = new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50, (i + 1) * 30, 350, 20);
            add(pb);
            bars.add(pb);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        int id = (int) arg;
        int val = ((Model) o).getProgressValue(id);
        bars.get(id).setValue(val);
    }
}