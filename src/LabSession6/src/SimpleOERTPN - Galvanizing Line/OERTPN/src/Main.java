
public class Main {

	public static void main(String[] args) {
		Supervizor supervizor=new Supervizor();
		Controller controller = new Controller();
		Robot robot = new Robot ();

		controller.r = robot;
		controller.s=supervizor;
		robot.c = controller;
		supervizor.c=controller;

		controller.start();
		robot.start();
		supervizor.start();
	}
}
