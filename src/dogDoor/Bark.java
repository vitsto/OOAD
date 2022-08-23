package dogDoor;

public class Bark {
    private final String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public boolean equals(Bark bark) {
        return this.getSound().equalsIgnoreCase(bark.getSound());
    }
}
