package Laboratory2.Exercise1;

import java.util.Observable;

public class Fir extends Observable implements Runnable {
    int id;
    int processorLoad;
    int priority;
    int c=0;
    Thread t;
    public void start(){
        if(t==null){
            t = new Thread(this);
            t.setPriority(this.priority);
            t.start();
        }
    }
    Fir(int id,int priority,Window win, int procLoad){
        this.id=id;
        this.addObserver(win);
        this.processorLoad=procLoad;
        this.priority = priority;
    }
    public int getC(){
        return this.c;
    }
    public int getId(){
        return this.id;
    }

    public void run(){
        c=0;
        while(c<1000){
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            c++;
            System.out.println("Thread " + this.id + ": c = " + this.c);
            this.setChanged();
            notifyObservers();
        }
    }
}