package ch01;

public class Guitar {
    private final String serialNumber;
    private double price;
    GuitarSpec spec;

    public Guitar(String serialNumber,  double price, GuitarSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GuitarSpec getSpec() {
        return spec;
    }
}
