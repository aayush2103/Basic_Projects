package guitarDesign;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindGuitarTester {

	public static void main(String[] args) {
		//Set up inventory
		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		//Search for Instrument
		Map prop = new HashMap();
		prop.put("type", Type.ACOUSTIC);
		prop.put("builder", Builder.GIBSON);
		InstrumentSpec instrumentSpecToSearch = new InstrumentSpec(prop);
		
		List instruments = inventory.search(instrumentSpecToSearch);
		if(!instruments.isEmpty()) {
			System.out.println("Erin, you might like these instruments :");
			for(Iterator i = instruments.iterator(); i.hasNext();) {
				Instrument instrument = (Instrument)i.next();
				InstrumentSpec spec = (InstrumentSpec) instrument.getSpec();
				System.out.println(" We have a " + spec.getProperty("instrumentType") + 
						" with the following properties :");
				for(Iterator j = spec.getProperties().keySet().iterator(); j.hasNext();) {
					String propertyName = (String) j.next();
					System.out.println("   " + propertyName + " : " + spec.getProperty(propertyName));
				}
				System.out.println("You can have this " + spec.getProperty("instrumnetType") +
						" for $" + instrument.getPrice() + "\n----");
			}
		}
		else
			System.out.println("Sorry, we have nothing for you.");
	}
	
	private static void initializeInventory(Inventory inventory) {
		Map prop1 = new HashMap();
		prop1.put("instrumentType", InstrumentType.GUITAR);
		prop1.put("builder", Builder.FENDER);
		prop1.put("model", "Stratocastor");
		prop1.put("type", Type.ELECTRIC);
		prop1.put("numStrings", 12);
		prop1.put("topWood", Wood.ALDER);
		prop1.put("backWood", Wood.ALDER);
		inventory.addInstrument("G95693", 1499.95, new InstrumentSpec(prop1));
		
		Map prop2 = new HashMap();
		prop2.put("instrumentType", InstrumentType.MANDOLIN);
		prop2.put("builder", Builder.GIBSON);
		prop2.put("model", "Stratocastor");
		prop2.put("type", Type.ACOUSTIC);
		prop2.put("style", Style.A);
		prop2.put("topWood", Wood.BRAZILIAN_ROSEWOOD);
		prop2.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
		inventory.addInstrument("G9512", 1549.95, new InstrumentSpec(prop2));
		
		Map prop3 = new HashMap();
		prop3.put("instrumentType", InstrumentType.BANJO);
		prop3.put("builder", Builder.GIBSON);
		prop3.put("model", "Stratocastor");
		prop3.put("type", Type.ACOUSTIC);
		prop3.put("topWood", Wood.INDIAN_ROSEWOOD);
		prop3.put("backWood", Wood.INDIAN_ROSEWOOD);
		inventory.addInstrument("M954", 2199, new InstrumentSpec(prop3));
		
		Map prop4 = new HashMap();
		prop4.put("instrumentType", InstrumentType.DOBRO);
		prop4.put("builder", Builder.OLSON);
		prop4.put("model", "Stratocastor");
		prop4.put("type", Type.ELECTRIC);
		prop4.put("topWood", Wood.MAHOGANY);
		prop4.put("backWood", Wood.MAHOGANY);
		prop4.put("style", Style.F);
		inventory.addInstrument("M996", 2599, new InstrumentSpec(prop4));	
	}	
}
