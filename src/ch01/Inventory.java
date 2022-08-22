package ch01;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private final List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, Builder builder, String model,
                          Type type, Wood backWood, Wood topWood) {
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

    public List<Guitar> search(Guitar searchGuitar) {
              List<Guitar> matchingGuitars = guitars.stream()
                .filter(g ->
                        searchGuitar.getBuilder().equals(g.getBuilder())
                                && searchGuitar.getModel().equalsIgnoreCase(g.getModel())
                                && searchGuitar.getType().equals(g.getType())
                                && searchGuitar.getBackWood().equals(g.getBackWood())
                                && searchGuitar.getTopWood().equals(g.getTopWood())
                ).collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        return matchingGuitars;

    }
}
