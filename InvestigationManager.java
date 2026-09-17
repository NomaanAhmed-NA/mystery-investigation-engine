import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class InvestigationManager {
    ArrayList<Suspect> suspects = new ArrayList<>();
    ArrayList<Evidence> evidenceList = new ArrayList<>();
    ConfidenceEngine engine = new ConfidenceEngine();

    public InvestigationManager() {
        // load dummy data
        suspects.add(new Suspect("bob the janitor", 45, "employee", "cleaning the 3rd floor"));
        suspects.add(new Suspect("alice carter", 29, "manager", "in a zoom meeting"));
        suspects.add(new Suspect("dave smith", 34, "security", "taking a nap"));

        evidenceList.add(new PhysicalEvidence("E01", "bloody wrench", "basement"));
        evidenceList.add(new DigitalEvidence("E02", "deleted emails", "laptop"));
        evidenceList.add(new PhysicalEvidence("E03", "muddy footprint", "hallway"));
    }

    public void showSuspects() {
        System.out.println("--- suspects ---");
        for (int i = 0; i < suspects.size(); i++) {
            System.out.print(i + ": ");
            suspects.get(i).display();
        }
    }

    public void showEvidence() {
        System.out.println("--- evidence ---");
        for (Evidence e : evidenceList) {
            e.show();
        }
    }
    
    public void viewCrimeScene() {
        System.out.println("the room is a mess. papers everywhere. window is broken.");
    }
    
    // interview specific suspect
    public void interview(int id) throws InvalidSuspectException {
        if (id < 0 || id >= suspects.size()) {
            throw new InvalidSuspectException("suspect id not found in system.");
        }
        System.out.println("interviewing suspect...");
        suspects.get(id).display();
        engine.addScore(10);
        engine.printBar();
    }
    
    // examine specific evidence
    public void examine(String id) throws InvalidEvidenceException {
        boolean found = false;
        for (Evidence e : evidenceList) {
            if (e.id.equals(id)) {
                System.out.println("examining evidence...");
                e.show();
                found = true;
                engine.addScore(15);
                engine.printBar();
                break;
            }
        }
        if (!found) {
            throw new InvalidEvidenceException("evidence id not valid.");
        }
    }

    public void runAnalysis() {
        System.out.println("running background checks...");
        AnalysisThread t1 = new AnalysisThread("fingerprint scan", engine);
        AnalysisThread t2 = new AnalysisThread("cctv review", engine);
        AnalysisThread t3 = new AnalysisThread("phone records trace", engine);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("analysis was interrupted");
        }
        System.out.println("analysis done.");
        engine.printBar();
    }

    public void saveReport() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("case_report_047.txt"));
            writer.write("CASE REPORT #047\n");
            writer.write("----------------\n");
            writer.write("final confidence score: " + engine.score + "%\n");
            if (engine.score >= 80) {
                writer.write("status: ready for accusation\n");
            } else {
                writer.write("status: needs more evidence\n");
            }
            writer.close();
            System.out.println("report saved to case_report_047.txt");
        } catch (IOException e) {
            System.out.println("could not save report.");
        }
    }
}
