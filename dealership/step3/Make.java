
public class Make {
	String make;
	Tree cars;
	
	Make(String make){
		this.make = make;
		cars = new Tree(null);
	}
	
	public String toString() {
		String string = this.make;
		return string;
	}
}
