package Laboratory1.LabSheet2.Application2;

class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // Add the view as an observer to the model
        model.addObserver(view);
    }

    public void startThreads(int noOfThreads, int processorLoad) {
        for (int i = 0; i < noOfThreads; i++) {
            new Fir(i, i + 2, model, processorLoad).start();
        }
    }
}