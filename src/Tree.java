import java.util.ArrayList;
import java.util.List;

public class Tree {
    
    protected Branch root;
    
    public Tree() {
        this.root = null;
    }
    
    public void remove(Branch branch) {
        if(branch.getRight() == null && branch.getLeft() == null) {
            if(branch.getParent().getValue() > branch.getValue()) {
                branch.getParent().setLeft(null);
            }
            
            if(branch.getParent().getValue() < branch.getValue()) {
                branch.getParent().setRight(null);
            }
            return;
        }
        
        if(branch.getRight() == null && branch.getLeft() != null) {
        	if (branch.getValue() < branch.getParent().getValue()) {
        		branch.getParent().setLeft(branch.getLeft());
        	}
        	
        	if (branch.getValue() > branch.getParent().getValue()) {
        		branch.getParent().setRight(branch.getLeft());
        	}
            return;
        }
        
        if(branch.getRight() != null && branch.getLeft() == null) {
        	if (branch.getValue() < branch.getParent().getValue()) {
        		branch.getParent().setLeft(branch.getRight());
        	}
        	
        	if (branch.getValue() > branch.getParent().getValue()) {
        		branch.getParent().setRight(branch.getRight());
        	}
            return;
        }
        
        Branch successor = successor_of(branch);
        successor.getParent().setLeft(null);
        successor.setParent(branch.getParent());
        successor.setLeft(branch.getLeft());
        successor.setRight(branch.getRight());
        
        if(successor.getValue() < branch.getParent().getValue()) {
            branch.getParent().setLeft(successor);
        }
        
        if(successor.getValue() > branch.getParent().getValue()) {
            branch.getParent().setRight(successor);
        }
    }
    
    public int height() {
    	return findHeight(this.root);
    }
    
    public int findHeight(Branch current) {
    	if (current == null) {
    		return -1;
    	}
    	int leftHeight = findHeight(current.getLeft());
    	int rightHeight = findHeight(current.getRight());
    	return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public List<Integer> allValues() {
    	List<Integer> result = new ArrayList<Integer>();
    	List<Branch> all_branches = this.all();
    	for (Branch branch : all_branches) {
    		result.add(branch.getValue());
    	}
    	return result;
    }
    
    public boolean isBalanced() {
		if (this.root == null)
			return true;
 
		List<Branch> all_elements = this.all();
		for (Branch branch : all_elements) {
			int coefficient_number = coefficient(branch);
			if (coefficient_number < -1 || coefficient_number > 1) {
				return false;
			}
		}
 
		return true;
	}
    
    protected int coefficient(Branch branch) {
    	return this.findHeight(branch.getRight()) - this.findHeight(branch.getLeft());
    }

    protected Branch insert(Integer value, Branch position) {
        Branch new_branch = new Branch(value);
        
        if(this.root == null) {
            this.root = new_branch;
        } else {
            new_branch.setParent(position);
            
            if(value < position.getValue()) {
                position.setLeft(new_branch);
            } else {
                if(value > position.getValue()) {
                    position.setRight(new_branch);
                }
            }
        }
        
        return new_branch;
    }

    protected List<Branch> all() {
    	return this.visit(this.root);
    }
    
    private Branch successor_of(Branch branch) {
    	Branch successor = branch.getRight();
    	while(successor.getLeft() != null) {
    		successor = successor.getLeft();
        }
    	return successor;
    }
    
    private List<Branch> visit(Branch branch) {
    	List<Branch> list = new ArrayList<Branch>();
    	if (branch != null) {
			if(branch.getLeft() != null) {
				list.addAll(this.visit(branch.getLeft()));
			}
			list.add(branch);
			if(branch.getRight() != null) {
				list.addAll(this.visit(branch.getRight()));
			}
    	}
		return list;
    }
    
    public Branch getRoot() {
        return root;
    }
    
    @Override
    public String toString() {
        List<Branch> all_elements = this.all();
        int length = all_elements.size();
        String result = "";
        for(int i = 0; i < length; i++) {
            result += all_elements.get(i).getValue();
            if(i < (length - 1)) {
                result += " ";
            }
        }
        return result;
    }
    
}