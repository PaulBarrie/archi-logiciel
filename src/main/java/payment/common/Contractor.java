package payment.common;

public abstract class Contractor {
    private String name;
    private String endpoint;

    public Contractor(String name, String endpoint) {
        this.name = name;
        this.endpoint = endpoint;
    }

    public String getName() {
        return name;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
