package SemaphoreRobot;

import java.util.concurrent.Semaphore;

public class Controller extends Thread{
	P p1;
	P_user p_i1, p_o1;
	P_move p2;
	P_arrived pi2;
	public void init(P_user p_i1, P_user p_o1, P_move p2, P_arrived pi2) {
		p1 = new P();
		p1.x = 0;
		this.p2 = p2;
		this.p_i1 = p_i1;
		this.p_o1 = p_o1;
		this.pi2 = pi2;
	} 

	public void run(){
		try {
			while (true) {
				p_i1.acquire();
				if (p_i1.x == p1.x) { p2.move = 0;}
				if (p_i1.x > p1.x) { p2.move = 1; p_i1.release();}
				if (p_i1.x < p1.x) { p2.move = -1; p_i1.release(); }
				p2.release();
				
				pi2.acquire();
				p1.x = pi2.x;
				p_o1.x = pi2.x;
				p_o1.release();
			}
		} catch (Exception e){}
	}
}

class P { // class for P1, Pi_1
	int x;
}
class P2 {
	int move;
}
class P_user extends Semaphore{ // class for user demand and user display
	int x;
	public P_user(int permits) {
		super(permits);
	}
}

