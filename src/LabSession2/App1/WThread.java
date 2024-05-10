package LabSession2.App1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class WThread extends Thread{
    String fileName;
    public WThread(String fileName) {
        this.fileName = fileName;
    }
    public void run(){
        while(!Main.isStopThreads()){
            synchronized (this){
                String msg=String.valueOf(Math.round(Math.random()*100));
                PrintWriter out = null;
                try {
                    out = new PrintWriter(new FileWriter(fileName, true));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Date date = new Date(System.currentTimeMillis());
                out.println("Date: " + date);
                out.println("Message: " + msg);
                out.flush();
            }



            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
