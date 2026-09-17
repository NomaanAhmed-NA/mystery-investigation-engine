public class AnalysisThread extends Thread {
    String taskName;
    ConfidenceEngine engine;

    public AnalysisThread(String taskName, ConfidenceEngine engine) {
        this.taskName = taskName;
        this.engine = engine;
    }

    @Override
    public void run() {
        System.out.println("starting " + taskName + "...");
        try {
            Thread.sleep(1500); // simulate work
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted.");
        }
        
        // update score
        engine.addScore(10);
        System.out.println(taskName + " complete.");
    }
}
