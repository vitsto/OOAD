package dogDoor;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        // Simulate the hardware hearing a bark
        System.out.println("Fido starts barking...");
        recognizer.recognize("Woof");
        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) { }

        System.out.println("... but he's stuck outside");
        System.out.println("Fido starts barking...");
        recognizer.recognize("Woof");
        System.out.println("\nFido's back inside");

    }
}
