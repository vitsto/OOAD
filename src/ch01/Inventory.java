package ch01;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private final List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, String builder, String model,
                          String type, String backWood, String topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        Optional<Guitar> optional = guitars.stream()
                .filter(g -> serialNumber.equals(g.getSerialNumber()))
                .findFirst();

        Guitar guitar = null;
        if (optional.isPresent()) {//Check whether optional has element you are looking for
            guitar = optional.get();//get it from optional
        }

        return guitar;
    }

    public Guitar search(Guitar searchGuitar) {
        Guitar guitar = null;

        Optional<Guitar> optional = guitars.stream()
                .filter(g ->
                        searchGuitar.getBuilder().equals(g.getBuilder())
                                && searchGuitar.getModel().equals(g.getModel())
                                && searchGuitar.getType().equals(g.getType())
                                && searchGuitar.getBackWood().equals(g.getBackWood())
                                && searchGuitar.getTopWood().equals(g.getTopWood())
                ).findFirst();

        if (optional.isPresent()) {//Check whether optional has element you are looking for
            guitar = optional.get();//get it from optional
        }

        return guitar;

    }
}
