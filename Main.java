import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvestigationManager manager = new InvestigationManager();
        boolean running = true;

        // main loop
        while (running) {
            System.out.println("\n==================================");
            System.out.println("||  MYSTERY INVESTIGATION CORE  ||");
            System.out.println("==================================");
            System.out.println(" [1] view crime scene");
            System.out.println(" [2] interview suspects");
            System.out.println(" [3] examine evidence");
            System.out.println(" [4] analyze case");
            System.out.println(" [5] save case report");
            System.out.println(" [6] exit");
            System.out.println("=================================");
            System.out.print(" -> command: ");

            // simple handle for bad inputs
            if (!scanner.hasNextInt()) {
                System.out.println("bad input.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    manager.viewCrimeScene();
                    break;
                case 2:
                    manager.showSuspects();
                    System.out.print("enter suspect id to interview: ");
                    int sid = scanner.nextInt();
                    try {
                        manager.interview(sid);
                    } catch (InvalidSuspectException e) {
                        System.out.println("error: " + e.getMessage());
                    }
                    break;
                case 3:
                    manager.showEvidence();
                    System.out.print("enter evidence id to examine: ");
                    String eid = scanner.next();
                    try {
                        manager.examine(eid);
                    } catch (InvalidEvidenceException e) {
                        System.out.println("error: " + e.getMessage());
                    }
                    break;
                case 4:
                    manager.runAnalysis();
                    break;
                case 5:
                    manager.saveReport();
                    break;
                case 6:
                    System.out.println("closing case...");
                    running = false;
                    break;
                default:
                    System.out.println("invalid option.");
            }
        }
        scanner.close();
    }
}
