package LabSession2.Example5;
import java.io.PipedOutputStream;
import java.io.*;
public class Main{
    public static void main(String args[]) {
        ReadThread rt = new ReadThread();
        WriteThread wt = new WriteThread();
        try{
            rt.conect(wt.getPipe());
            rt.start();wt.start();
        }catch(Exception e){e.printStackTrace();}
    }
}
