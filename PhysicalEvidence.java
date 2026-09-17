public class PhysicalEvidence extends Evidence {
    String locationFound;

    public PhysicalEvidence(String id, String description, String locationFound) {
        super(id, description);
        this.locationFound = locationFound;
    }

    // override to add location
    @Override
    public void show() {
        System.out.println("[" + id + "] (physical) " + description + " found at " + locationFound);
    }
}
