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

    public List<Guitar> search(GuitarSpec searchSpec) {
              List<Guitar> matchingGuitars = guitars.stream()
                .filter(g ->
                        searchSpec.getBuilder().equals(g.getSpec().getBuilder())
                                && searchSpec.getModel().equalsIgnoreCase(g.getSpec().getModel())
                                && searchSpec.getType().equals(g.getSpec().getType())
                                && searchSpec.getBackWood().equals(g.getSpec().getBackWood())
                                && searchSpec.getTopWood().equals(g.getSpec().getTopWood())
                ).collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        return matchingGuitars;

    }
}
