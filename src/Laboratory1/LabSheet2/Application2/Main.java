package Laboratory1.LabSheet2.Application2;
public class Main {

    private static final int noOfThreads = 6;

    private static final int processorLoad = 1000000;

    public static void main(String args[]) {

        Window win = new Window(noOfThreads);

        for (int i = 0; i < noOfThreads; i++) {

            Fir f =  new Fir(i, i + 2, win, processorLoad);
            f.addObserver(win);
            f.start();

        }

    }

}