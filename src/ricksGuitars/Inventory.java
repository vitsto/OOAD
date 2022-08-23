package ricksGuitars;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private final List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
        Guitar guitar = new Guitar(serialNumber, price,spec);
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
                .filter(g -> g.getSpec().matches(searchSpec))
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        return matchingGuitars;

    }
}
