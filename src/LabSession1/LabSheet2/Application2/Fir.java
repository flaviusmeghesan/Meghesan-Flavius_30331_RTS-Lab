package Laboratory1.LabSheet2.Application2;


class Fir extends Thread {
    int id;
    Model model;
    int processorLoad;

    Fir(int id, int priority, Model model, int procLoad) {
        this.id = id;
        this.model = model;
        this.processorLoad = procLoad;
        setPriority(priority);
    }

    public void run() {
        int c = 0;
        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++) {
                j++;
                j--;
            }
            c++;
            model.setProgressValue(id, c);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}