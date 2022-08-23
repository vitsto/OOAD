package dogDoor;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBark(new Bark("rowlf"));
        door.addAllowedBark(new Bark("rooowlf"));
        door.addAllowedBark(new Bark("rawlf"));
        door.addAllowedBark(new Bark("woof"));
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        // Simulate the hardware hearing a bark
        System.out.println("Fido starts barking...");
        recognizer.recognize(new Bark("Woof"));

        System.out.println("\nFido has gone outside...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) { }

        System.out.println("\nFido's all done...");
        System.out.println("... but he's stuck outside");

        Bark smallDogBark = new Bark("yip");
        System.out.println("A small dog starts barking");
        recognizer.recognize(smallDogBark);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) { }

        System.out.println("Fido starts barking...");
        recognizer.recognize(new Bark("rooowlf"));

        System.out.println("\nFido's back inside");

    }
}
