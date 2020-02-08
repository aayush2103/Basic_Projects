package guitarDesign;

public class Instrument {
	
	private String serialNumber;
	private double price;
	private InstrumentSpec spec;
	
	public Instrument(String serialNumber, double price, InstrumentSpec spec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}
	
	public String getSerialNumber() {
		return this.serialNumber;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public InstrumentSpec getSpec() {
		return this.spec;
	}
	
}
