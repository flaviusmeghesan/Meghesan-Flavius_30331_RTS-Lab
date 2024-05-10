package LabSession2.App1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

public class RThread extends Thread{

    String fileName;
    public RThread(String filename) {
        this.fileName=filename;
    }
    public void run(){
        while (!Main.isStopThreads()){
            try {
                synchronized (this) {
                    BufferedReader in = new BufferedReader(new FileReader(fileName));
                    String iterator, last = "no message to read";
                    while ((iterator = in.readLine()) != null) {
                        last = new Date(System.currentTimeMillis()) + " - "
                                + iterator;
                    }
                    String readMsg = last;
                    System.out.println(readMsg);
                    Thread.sleep(3000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

