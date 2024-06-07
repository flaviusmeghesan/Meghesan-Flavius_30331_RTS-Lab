package SemaphoreRobot;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		P_move pmove = new P_move(0);
		pmove.move = 0;
		P_arrived parr = new P_arrived(0);

		// create plant and controller
		Plant p = new Plant();
		p.init(pmove, parr);

		P_user userdemand = new P_user(0);
		P_user userdisplay = new P_user(0);
		Controller c = new Controller();
		c.init(userdemand, userdisplay, pmove, parr);
		
		p.start();
		c.start();
		
		// create message printer
		MessagePrinter printer = new MessagePrinter();
		printer.display = userdisplay;
		printer.start();

		// listen for requests
		Scanner in = new Scanner(System.in);
		System.out.print("enter places to go: ");
		while (true) {
			int demand = in.nextInt();
			userdemand.x = demand;
			userdemand.release();
		}
	}
}

class MessagePrinter extends Thread{ // this is the user display listener
	P_user display;
	public void run() {
		while (true) {
			try {
				display.acquire();
				System.out.println("arrived at: " + display.x);
			} catch (Exception e) { }
		}
	}
}