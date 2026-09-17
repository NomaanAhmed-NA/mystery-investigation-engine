public class Evidence {
    String id;
    String description;

    public Evidence(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public void show() {
        System.out.println("[" + id + "] " + description);
    }
}
