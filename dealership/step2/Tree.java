import java.util.ArrayList;

public class Tree {
		Object contents;
		Tree branch1;
		Tree branch2;
		
		Tree(Object contents){
			this.contents = contents;
		}
	
	public boolean recursiveAdd(Object victim) {
		if (this.contents == null) {
			this.contents = victim;
			this.branch1 = new Tree(null);
			this.branch2 = new Tree(null);
			return true;
		}
		String rootVal = this.contents.toString();
		String vicVal = victim.toString();
		if (rootVal.compareToIgnoreCase(vicVal) == 0) {
			return false;
		} else if (rootVal.compareToIgnoreCase(vicVal) > 0) {
			return this.branch1.recursiveAdd(victim);
		} else if (rootVal.compareToIgnoreCase(vicVal) < 0) {
			return this.branch2.recursiveAdd(victim);
		}
		return false;
	}
	public boolean recursiveAdd(Tree victim) {
		if (victim.contents != null) {
			if (this.contents == null) {
				this.contents = victim.contents;
				this.branch1 = victim.branch1;
				this.branch2 = victim.branch2;
				return true;
			}
			String rootVal = this.contents.toString();
			String vicVal = victim.contents.toString();
			if (rootVal.compareToIgnoreCase(vicVal) == 0) {
				return false;
			} else if (rootVal.compareToIgnoreCase(vicVal) > 0) {
				return this.branch1.recursiveAdd(victim);
			} else if (rootVal.compareToIgnoreCase(vicVal) < 0) {
				return this.branch2.recursiveAdd(victim);
			}
		}
		return false;
	}
	
	public Tree recursiveRemove(Object victim) {
		if (this.contents != null) {
			String rootVal = this.contents.toString();
			String vicVal = victim.toString();
			if (rootVal.compareToIgnoreCase(vicVal) == 0) {
				Tree temp = new Tree(this.contents);
				temp.branch1 = this.branch1;
				temp.branch2 = this.branch2;
				this.contents = null;
				this.branch1 = null;
				this.branch2 = null;
				return temp;
			} else if (rootVal.compareToIgnoreCase(vicVal) > 0) {
				return this.branch1.recursiveRemove(victim);
			} else if (rootVal.compareToIgnoreCase(vicVal) < 0) {
				return this.branch2.recursiveRemove(victim);
			}
		}
		return null;
	}
	
	public ArrayList<Tree> recursiveSearch(Object victim) {
		ArrayList<Tree> alreadyFound = new ArrayList<Tree>();
		if (this.contents != null) {
			String rootVal = this.contents.toString();
			String vicVal = victim.toString();
			if ((vicVal.contains("*")) || (rootVal.compareToIgnoreCase(vicVal) == 0)) {
				alreadyFound.add(this);
			} 
			if ((vicVal.contains("*")) || (rootVal.compareToIgnoreCase(vicVal) > 0)) {
				alreadyFound.addAll(this.branch1.recursiveSearch(victim));
			} 
			if ((vicVal.contains("*")) || (rootVal.compareToIgnoreCase(vicVal) < 0)) {
				alreadyFound.addAll(this.branch2.recursiveSearch(victim));
			}
		}
		return alreadyFound;
	}
}
