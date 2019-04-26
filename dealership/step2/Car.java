public class Car{
	String model;
	String colour;
	String registration;
	
	Car(String model, String colour, String registration){
		 this.model = model;
		 this.colour = colour;
		 this.registration = registration;
	}
	
	public String toString() {
		//this is the sort order for querying cars, compareToIgnoreCase sorts by unicode ignoring case, effectively sorting alphabetically
		String string = this.model + this.colour + this.registration;
		return string;
	}
} 