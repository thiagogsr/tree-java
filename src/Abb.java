import java.util.ArrayList;
import java.util.List;

public class Abb extends Tree {
	
	public Branch add(Integer value) {
		return this.insert(value, this.search(value));
	}
    
    public void balance() {
    	List<Branch> all_elements;
    	List<Branch> right_sub_tree = new ArrayList<Branch>();
    	List<Branch> left_sub_tree = new ArrayList<Branch>();
    	all_elements = this.all();
    	
    	int size = all_elements.size();
    	if (size > 0) {
	    	int middle = Math.round(size / 2);
	
	    	right_sub_tree.addAll(all_elements.subList(0, middle));
	    	left_sub_tree.addAll(all_elements.subList(middle + 1, size));
	
	    	this.root = new Branch(all_elements.get(middle).getValue());
	    	all_elements.remove(middle);
	    	
	    	Branch current;
	    	
	    	while (!all_elements.isEmpty()) {
	    		if (!left_sub_tree.isEmpty()) {
	    			middle = Math.round(left_sub_tree.size() / 2);
	    			current = left_sub_tree.get(middle);
	    			this.add(current.getValue());
	    			left_sub_tree.remove(current);
	    			all_elements.remove(current);
	    		}
	    		if (!right_sub_tree.isEmpty()) {
	    			middle = Math.round(right_sub_tree.size() / 2);
	    			current = right_sub_tree.get(middle);
	    			this.add(current.getValue());
	    			right_sub_tree.remove(current);
	    			all_elements.remove(current);
	    		}
	    	}
    	}
    }
    
    private Branch search(Integer value) {
        Branch current = this.root;
        Branch position = null;
        
        while(current != null) {
            position = current;
            if(value < current.getValue()) {
                current = current.getLeft();
            } else {
                if(value > current.getValue()) {
                    current = current.getRight();
                }
            }
        }
        
        return position;
    }

}