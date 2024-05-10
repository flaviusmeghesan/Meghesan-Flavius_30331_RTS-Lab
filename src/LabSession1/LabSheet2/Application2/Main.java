package Laboratory1.LabSheet2.Application2;

import java.util.Observer;

public class Main {
    private static final int noOfThreads = 6;
    private static final int processorLoad = 1000000;

    public static void main(String[] args) {
        View view = new View(noOfThreads);
        Model model = new Model(noOfThreads);
        Controller controller = new Controller(model, view);
        controller.startThreads(noOfThreads, processorLoad);
    }
}