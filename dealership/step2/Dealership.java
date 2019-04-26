import java.util.ArrayList;

public class Dealership {
	Tree stock;
	
	Dealership(){
		stock = new Tree(null);
	}
	
	public boolean addMake(String make) {
		return this.stock.recursiveAdd(new Make(make));
	}
	
	public boolean addCar(Tree make, Car car) {
		Make thing = (Make) make.contents;
		return thing.cars.recursiveAdd(car);
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
	
	public boolean removeCar(Tree make, Car car) {
		Make thing = (Make) make.contents;
		return (thing.cars.recursiveRemove(car).contents != null);
	}
		
	public ArrayList<Tree> searchMake(String make) {
		return this.stock.recursiveSearch(new Make(make));
	}

	public ArrayList<Tree> searchCar(Tree root, Make make) {
		Make thing = (Make) root.contents;
		return thing.cars.recursiveSearch(make);
	}
	}
