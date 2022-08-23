package ricksGuitars;

import java.util.List;

public class FindGuitarTester {
    public static void main(String[] args) {
        // Set up Rick's guitar inventory
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
                Wood.ALDER, Wood.ALDER);
        MandolinSpec whatLisaLikes = new MandolinSpec(Builder.RYAN, "MD-22", Type.ACOUSTIC, Style.F, Wood.CEDAR, Wood.SITKA);

        List<Guitar> matchingGuitars = inventory.search(whatErinLikes);
        if (!matchingGuitars.isEmpty()) {
            matchingGuitars.forEach(guitar -> {
                InstrumentSpec guitarSpec = guitar.getSpec();
                System.out.println(" We have a " + guitarSpec.getBuilder() + " " +
                        guitarSpec.getModel() + " " + guitarSpec.getType() + " guitar:\n  " +
                        guitarSpec.getBackWood() + " back and sides,\n  " +
                        guitarSpec.getTopWood() + " top.\n You can have it for only $" +
                        guitar.getPrice() + "!\n -----"
                );
            });
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }

        List<Mandolin> matchingMandolins = inventory.search(whatLisaLikes);
        if (!matchingMandolins.isEmpty()) {
            matchingMandolins.forEach(mandolin -> {
                InstrumentSpec mandolinSpec = mandolin.getSpec();
                System.out.println(" We have a " + mandolinSpec.getBuilder() + " " +
                        mandolinSpec.getModel() + " " + mandolinSpec.getType() + " mandolin:\n  " +
                        mandolinSpec.getBackWood() + " back and sides,\n  " +
                        mandolinSpec.getTopWood() + " top.\n You can have it for only $" +
                        mandolin.getPrice() + "!\n -----"
                );
            });
        } else {
            System.out.println("Sorry, Lisa, we have nothing for you.");
        }
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addInstrument("11277", 3999.95,
                new GuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC, 6, Wood.INDIAN_ROSEWOOD, Wood.SITKA));
        inventory.addInstrument("V95693", 1499.95,
                new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("V9512", 1549.95,
                new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,  Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("122784", 5495.95,
                new GuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC, 6, Wood.MAHOGANY, Wood.ADIRONDACK));
        inventory.addInstrument("76531", 6295.95,
                new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("70108276", 2295.95,
                new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("82765501", 1890.95,
                new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("77023", 6275.95,
                new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("1092", 12995.95,
                new GuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC, 12, Wood.INDIAN_ROSEWOOD, Wood.CEDAR));
        inventory.addInstrument("566-62", 8999.95,
                new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 12, Wood.COCOBOLO, Wood.CEDAR));
        inventory.addInstrument("6 29584", 2100.95,
                new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAPLE));
        inventory.addInstrument("12345", 12000.0,
                new MandolinSpec(Builder.FENDER, "MD-12", Type.ACOUSTIC, Style.A, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("12346", 12350.0,
                new MandolinSpec(Builder.ANY, "MD-15", Type.ELECTRIC, Style.F, Wood.ALDER, Wood.ADIRONDACK));
        inventory.addInstrument("12347", 14100.0,
                new MandolinSpec(Builder.RYAN, "MD-22", Type.ACOUSTIC, Style.F, Wood.CEDAR, Wood.SITKA));
        inventory.addInstrument("12348", 18000.20,
                new MandolinSpec(Builder.MARTIN, "MD-35", Type.ELECTRIC, Style.A, Wood.BRAZILIAN_ROSEWOOD, Wood.CEDAR));

    }

}
