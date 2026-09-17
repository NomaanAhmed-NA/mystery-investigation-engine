public class ConfidenceEngine {
    int score = 0;

    // match evidence to suspect
    public synchronized void addScore(int points) {
        score += points;
        if (score > 100) score = 100;
        if (score < 0) score = 0;
    }

    public synchronized void removeScore(int points) {
        score -= points;
        if (score < 0) score = 0;
    }

    public synchronized void printBar() {
        System.out.print("confidence: [");
        int filled = score / 10;
        for (int i = 0; i < 10; i++) {
            if (i < filled) {
                System.out.print("█");
            } else {
                System.out.print("░");
            }
        }
        System.out.println("] " + score + "%");
    }
}
