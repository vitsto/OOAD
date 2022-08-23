package dogDoor;

public class BarkRecognizer {
    private final DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("    BarkRecognizer: Heard a '" + bark.getSound() + "'");
        if (door.getAllowedBarks().stream().anyMatch(b -> b.equals(bark)))
            door.open();
        else
            System.out.println("This dog is not allowed");
    }
}
