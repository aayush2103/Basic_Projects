package guitarDesign;

public enum Wood {
	INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, ALDER;
	
	public String toString() {
		switch(this) {
			case INDIAN_ROSEWOOD : return "Indian Rosewood";
			case BRAZILIAN_ROSEWOOD : return "Brazilian Rosewood";
			case MAHOGANY : return "Mahogany";
			case ALDER : return "Alder";
			default : return "others";
		}
	}
}
