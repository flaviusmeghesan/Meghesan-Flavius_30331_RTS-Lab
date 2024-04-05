package Laboratory1.LabSheet2.Application3;

import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.JProgressBar;

import java.util.Observer;

import java.util.Observable;

public class Window extends JFrame implements Observer {

    ArrayList<JProgressBar> bars=new ArrayList<JProgressBar>();

    public Window(int nrThreads) {

        setLayout(null);

        setSize(450,400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init(nrThreads);

        this.setVisible(true);
    }
    private void init(int n){

        for(int i=0 ;i<n; i++){

            JProgressBar pb=new JProgressBar();

            pb.setMaximum(1000);

            pb.setBounds(50,(i+1)*30,350,20);

            this.add(pb);

            this.bars.add(pb);
        }
    }
    @Override
    public void update(Observable fir, Object arg){

        bars.get(((Fir)fir).getId()).setValue(((Fir)fir).getC());
    }
}