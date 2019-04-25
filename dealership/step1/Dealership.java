import java.util.ArrayList;

public class Dealership {
	Tree stock;
	
	Dealership(){
		stock = new Tree(null);
	}
	
	public boolean addMake(String make) {
		return this.stock.recursiveAdd(new Make(make));
	}
	
	public boolean removeMake(String make) {
		Tree removed = this.stock.recursiveRemove(new Make(make));
		if (removed == null) {
			return false;
		}
		this.stock.recursiveAdd(removed.branch1);
		this.stock.recursiveAdd(removed.branch2);
		return true;
	}
		
	public ArrayList<Object> searchMake(String make) {
		return this.stock.recursiveSearch(new Make(make));
	}

	}
