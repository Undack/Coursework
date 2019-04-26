//Authored by B00336796 and B00335847
//Github at https://github.com/Undack/Coursework/tree/master/dealership

import java.util.ArrayList;

public class DealershipTest {
	public static void main(String[] args) {
		Dealership dealership = new Dealership();
		
		String input;
		ArrayList<Tree> result;
		boolean exit = false;
		while(exit == false) {
			System.out.println("Welcome to the stock control interface, please select an option: ");
			input = Input.getString("\n0. Add a new make of car\n1. Search makes of car\n2. Remove a make of car\n3. Add Car\n4. Search Car\n5. Remove Car\n6. Show all makes\n7. Show all stock\n8. Exit\n");
			switch(input) {
			  case "0"://Add make
				  input = Input.getString("Please enter make of car you would like to add to stock\n");
				  if(dealership.addMake(input)) {
					  System.out.println("Make was successfully added");
				  } else {
					  System.out.println("Make was not added, it may already be present in stock");
				  }
			    break;
			  case "1"://Search make
				  input = Input.getString("Please enter make of car you would like to search for\n");
				  result = dealership.searchMake(input);
				  if (!result.isEmpty()) {
					  System.out.println("The following Makes matched your query:\n");
					  for (int i = 0; i > result.size(); i++) {
						  System.out.println(result.get(i));
					  }
				  } else {
					  System.out.println("Unable to find Make in stock");
				  }
				   break;
			  case "2"://remove make
				  input = Input.getString("Please enter make of car you would like to remove from stock\n");
				  if(dealership.removeMake(input)) {
					  System.out.println("Make was successfully removed");
				  } else {
					  System.out.println("Make was not removed, it may not be present in stock");
				  }
				  break;
			  case "3"://Add car
				  result = dealership.searchMake("*");
				  if (!result.isEmpty()) {
					  System.out.println("Please choose a make:\n");
					  for (int i = 0; i < result.size(); i++) {
						  Tree temp = result.get(i);
						  System.out.println(temp.contents);
					  }
					  input = Input.getString("");
					  Tree temp = dealership.searchMake(input).get(0);
					  if (temp != null) {
						  String model = Input.getString("Please enter the model of the car to be added\n");
						  String colour = Input.getString("Please enter the colour of the car to be added\n");
						  String registration = Input.getString("Please enter the registration of the car to be added\n");
						  boolean state = dealership.addCar(temp, new Car(model, colour, registration));
						  if (state) {
							  System.out.println("Car was successfully added");
						  } else {
							  System.out.println("Make was not added, it may already be present in stock");
						  }
					  } else {
						  System.out.println("Unable to find choice in tree, it may have been incorrectly typed");
					  }
				  } else {
					  System.out.println("Unable to find any Makes, please add makes and try again");
				  }
				   break;
			  case "4"://Search car
				  result = dealership.searchMake("*");
				  if (!result.isEmpty()) {
					  System.out.println("Please choose a make:\n");
					  for (int i = 0; i < result.size(); i++) {
						  Tree temp = result.get(i);
						  System.out.println(temp.contents);
					  }
					  input = Input.getString("");
					  Tree temp = dealership.searchMake(input).get(0);
					  result = dealership.searchCar(temp, new Make("*"));
					  for (int i = 0; i < result.size(); i++) {
						  temp = result.get(i);
						  Car thing = (Car) temp.contents;
						  System.out.println("Model: " + thing.model + "Colour: " + thing.colour + "Registration: " + thing.registration);
					  }
				  }
				  break;
			  case "5"://Remove car
				  result = dealership.searchMake("*");
				  if (!result.isEmpty()) {
					  System.out.println("Please choose a make:\n");
					  for (int i = 0; i < result.size(); i++) {
						  Tree temp = result.get(i);
						  System.out.println(temp.contents);
					  }
					  input = Input.getString("");
					  Tree temp = dealership.searchMake(input).get(0);
					  if (temp != null) {
						  String model = Input.getString("Please enter the model of the car to be removed\n");
						  String colour = Input.getString("Please enter the colour of the car to be removed\n");
						  String registration = Input.getString("Please enter the registration of the car to be removed\n");
						  boolean state = dealership.removeCar(temp, new Car(model, colour, registration));
						  if (state) {
							  System.out.println("Car was successfully removed");
						  } else {
							  System.out.println("Make was not removed, it may not be present in tree");
						  }
					  } else {
						  System.out.println("Unable to find choice in tree, it may have been incorrectly typed");
					  }
				  } else {
					  System.out.println("Unable to find any Makes, please add makes and try again");
				  }
				   break;
			  case "6"://Show make
				  result = dealership.searchMake("*");
				  if(!result.isEmpty()) {
					  System.out.println("The following makes were found");
					  System.out.println(result);
				  } else {
					  System.out.println("No makes were found");
				  }
				  break;
			  case "7"://
				  result = dealership.searchMake("*");
				  if (!result.isEmpty()) {
					  for (int i = 0; i < result.size(); i++) {
						  Tree temp = result.get(i);
						  System.out.println(((Make) temp.contents).make + ": ");
						  ArrayList<Tree> result2 = dealership.searchCar(temp, new Make("*"));
						  for (int a = 0; a < result2.size(); a++) {
							  Car thing = (Car) result2.get(a).contents;
							  System.out.println("\tModel: " + thing.model + " Colour: " + thing.colour + " Registration: " + thing.registration);
						  }
					  }
				  } else {
					  System.out.println("Unable to find any makes");
				  }
				  break;
			  case "8"://Exit
				  input = Input.getString("Sure you want to exit? (Y/N)\n");
				  if (input.compareToIgnoreCase("Y") == 0) {
					  exit = true;
				  }
				  break;
			  default:
				  System.out.println("Option not recognised, please try again");
			}
		}
	}
}
