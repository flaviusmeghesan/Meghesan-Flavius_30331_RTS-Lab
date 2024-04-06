package Laboratory1.LabSheet2.Application3;
class Main {
    private static final int noOfThreads = 3;

    public static void main(String[] args) {
        Window win = new Window(noOfThreads);
        for (int i = 0; i < noOfThreads; i++) {
            Fir f = new Fir(i, i+2, win);
            f.addObserver(win);
            f.start();
        }

    }


}

