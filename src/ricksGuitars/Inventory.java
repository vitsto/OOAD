package ricksGuitars;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Inventory {
    private final List<Instrument> inventory;

    public Inventory() {
        inventory = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = null;
        if (spec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec) spec);
        } else if (spec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec) spec);
        }
        inventory.add(instrument);
    }

    public Instrument getInstrument(String serialNumber) {
        Optional<Instrument> optional = inventory.stream()
                .filter(g -> serialNumber.equals(g.getSerialNumber()))
                .findFirst();

        Instrument instrument = null;
        if (optional.isPresent()) {//Check whether optional has element you are looking for
            instrument = optional.get();//get it from optional
        }

        return instrument;
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = inventory.stream()
                .filter(instrument -> instrument instanceof Guitar)
                .map(instrument -> (Guitar) instrument)
                .filter(instrument -> instrument.getSpec().matches(searchSpec))
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        return matchingGuitars;
    }

    public List<Mandolin> search(MandolinSpec searchSpec) {
        List<Mandolin> matchingMandolins = inventory.stream()
                .filter(instrument -> instrument instanceof Mandolin)
                .map(instrument -> (Mandolin) instrument)
                .filter(instrument -> instrument.getSpec().matches(searchSpec))
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        return matchingMandolins;
    }
}
