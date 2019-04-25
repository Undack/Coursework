import java.util.ArrayList;

public class DealershipTest {
	public static void main(String[] args) {
		Dealership dealership = new Dealership();
		
		String input;
		boolean exit = false;
		while(exit == false) {
			System.out.println("Welcome to the stock control interface, please select an option: ");
			input = Input.getString("\n0. Add a new make of car\n1. Search makes of car\n2. Remove a make of car\n3. Display all stock data\n4. Exit\n");
			switch(input) {
			  case "0":
			    input = Input.getString("Please enter make of car you would like to add to stock\n");
			    if(dealership.addMake(input)) {
			    	System.out.println("Make successfully added");
			    } else {
			    	System.out.println("Make was not added, it may already be present in stock");
			    }
			    break;
			  case "1":
				  input = Input.getString("Please enter make of car you would like to search for\n");
				  	ArrayList<Object> result = dealership.searchMake(input);
				  	if (!result.isEmpty()) {
				  		System.out.println("The following Makes matched your query:");
				  		System.out.println(result);
				  	} else {
				  		System.out.println("Unable to find Make in stock");
				  	}
				    break;
			  case "2":
				  input = Input.getString("Please enter make of car you would like to remove from stock\n");
				    if(dealership.removeMake(input)) {
				    	System.out.println("Make successfully removed");
				    } else {
				    	System.out.println("Make was not removed, it may not be present in stock");
				    }
				    break;
			  case "3":
				  System.out.println("All makes currently stocked:");
				  System.out.println(dealership.searchMake("*"));
				  break;
			  case "4":
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
