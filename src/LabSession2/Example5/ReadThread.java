package LabSession2.Example5;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class ReadThread extends Thread{
    private PipedInputStream pi;
    ReadThread(){
        pi = new PipedInputStream();
    }
    public void run(){
        try{
            while (true){
                if (pi.available()>0)
                {System.out.println("Read Thread is received : "+pi.read());}
                }
            }catch(Exception e){}
        }
        void conect(PipedOutputStream os)throws Exception{
            pi.connect(os);
        }

    }

