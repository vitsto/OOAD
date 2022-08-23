package ricksGuitars;

public abstract  class InstrumentSpec {
    private final String model;
    private final Builder builder;
    private final Type type;
    private final Wood backWood;
    private final Wood topWood;

    public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.model = model;
        this.builder = builder;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
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

    public boolean matches(InstrumentSpec otherSpec) {
        return getBuilder().equals(otherSpec.getBuilder())
                && getModel().equalsIgnoreCase(otherSpec.getModel())
                && getType().equals(otherSpec.getType())
                && getBackWood().equals(otherSpec.getBackWood())
                && getTopWood().equals(otherSpec.getTopWood());
    }
}
