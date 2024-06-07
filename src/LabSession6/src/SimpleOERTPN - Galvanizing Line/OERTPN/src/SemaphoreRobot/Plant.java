package SemaphoreRobot;

import java.util.concurrent.Semaphore;

public class Plant extends Thread{
	P01 p0, p1;
	P_move pi;
	P_arrived po;
	public void init(P_move pi, P_arrived po) {
		p0 = new P01();
		p0.x = 0;
		p1 = new P01();
		this.pi = pi;
		this.po = po;
	} 

	public void run(){
		try {
			while (true) {
				pi.acquire(); // wait for Pi
				// System.out.println("am at "+p1.x+", request move: " + pi.move);
				p1.x = p0.x + pi.move;
				Thread.sleep(5000);
				po.x = p1.x;
				po.release();
				p0.x = p1.x;
			}
		} catch (Exception e){}
	}
}

class P01 { // class for P0 and P1
	int x;
}

class P_move extends Semaphore{
	int move; // can be -1,0,1
	public P_move(int permits) {
		super(permits);
	}
}

class P_arrived extends Semaphore{
	int x;
	public P_arrived(int permits) {
		super(permits);
	}
}
