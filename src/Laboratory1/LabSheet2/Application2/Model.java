package Laboratory1.LabSheet2.Application2;

import java.util.Observable;

class Model extends Observable {
    private int[] progressValues;

    public Model(int nrThreads) {
        progressValues = new int[nrThreads];
    }

    public void setProgressValue(int id, int val) {
        progressValues[id] = val;
        setChanged();
        notifyObservers(id);
    }

    public int getProgressValue(int id) {
        return progressValues[id];
    }
}