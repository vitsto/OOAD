package ricksGuitars;

public class GuitarSpec {
    private final String model;
    private final Builder builder;
    private final Type type;
    private final Wood backWood;
    private final Wood topWood;

    private final int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
        this.model = model;
        this.builder = builder;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numStrings = numStrings;
    }

    public String getModel() {
        return model;
    }

    public Builder getBuilder() {
        return builder;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public int getNumStrings() {
        return numStrings;
    }

    public boolean matches(GuitarSpec otherSpec) {
        return getBuilder().equals(otherSpec.getBuilder())
                && getModel().equalsIgnoreCase(otherSpec.getModel())
                && getType().equals(otherSpec.getType())
                && getNumStrings() == otherSpec.getNumStrings()
                && getBackWood().equals(otherSpec.getBackWood())
                && getTopWood().equals(otherSpec.getTopWood());
    }
}
