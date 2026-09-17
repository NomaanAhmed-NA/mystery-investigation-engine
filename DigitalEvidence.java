public class DigitalEvidence extends Evidence {
    String deviceType;

    public DigitalEvidence(String id, String description, String deviceType) {
        super(id, description);
        this.deviceType = deviceType;
    }

    @Override
    public void show() {
        System.out.println("[" + id + "] (digital) " + description + " on " + deviceType);
    }
}
