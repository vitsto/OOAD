package ch01;

public class Guitar {
    private final String serialNumber;
    private double price;
    GuitarSpec spec;

    public Guitar(String serialNumber,  double price, Builder builder, String model,
                  Type type, Wood backWood, Wood topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = new GuitarSpec(builder, model, type, backWood, topWood);
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
