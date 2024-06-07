package OETPN;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread{

    CyclicBarrier barrier;
    Semaphore s1;
    Semaphore s2;
    int  k, permit,permit2,
            activity_min1, activity_max1, activity_min2, activity_max2,
            sleep_min1, sleep_max1, sleep2;
    ExecutionThread(CyclicBarrier barrier, Semaphore s1, Semaphore s2, int permit, int permit2,
                    int activity_min1, int activity_max1, int activity_min2, int activity_max2, int sleep_min1, int sleep_max1, int sleep2) {
        this.barrier = barrier;
        this.s1 = s1;
        this.s2 = s2;
        this.permit = permit;
        this.permit2 = permit2;
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
        this.activity_min2 = activity_min2;
        this.activity_max2 = activity_max2;
        this.sleep_min1 = sleep_min1;
        this.sleep_max1 = sleep_max1;
        this.sleep2 = sleep2;
    }



    public void run(){

            System.out.println(this.getName() + " STATE - 1");
            try{
                this.s1.acquire(this.permit);
                System.out.println(this.getName() + " took " + this.permit + " tokens from the semaphore P9");
                this.s2.acquire(this.permit2);
                System.out.println(this.getName() + " took " + this.permit + " tokens from the semaphore P11");

                System.out.println(this.getName() + " STATE - 2");

                k = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.s1.release(this.permit);
                System.out.println(this.getName() + " released " + this.permit + " tokens to the semaphore P9");
                Thread.sleep(Math.round(Math.random() * (sleep_max1 - sleep_min1) + sleep_min1));
                System.out.println(this.getName() + " STATE - 3");

                k = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                Thread.sleep(sleep2 * 500);
                this.s2.release(this.permit2);
                System.out.println(this.getName() + " released " + this.permit2 + " tokens to the semaphore P11");

                System.out.println(this.getName() + " STATE - 4");

                try{
                    barrier.await();

                }catch (InterruptedException e){
                    e.printStackTrace();
                } catch (BrokenBarrierException e){
                    e.printStackTrace();
                }

            } catch (InterruptedException e){
                e.printStackTrace();
            }


        }



}




