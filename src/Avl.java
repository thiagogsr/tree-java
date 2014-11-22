
public class Avl extends Tree {
	
	private Branch pivot;
	
	public Avl() {
		this.pivot = null;
	}
	
	public Branch add(Integer value) {
		Branch new_branch = this.insert(value, this.search(value));
		if (this.updateCoefficientAndReturnsIsBallanced(new_branch)) {
			this.rotate();
		}
		return new_branch;
	}
	
	public void delete(Branch branch) {
		Branch parent = branch.getParent();
		this.remove(branch);
		if (this.updateCoefficientAndReturnsIsBallanced(parent)) {
			this.rotate();
		}
	}
	
	private Branch search(Integer value) {
        Branch current = this.root;
        Branch position = null;
        
        while(current != null) {
            position = current;
            if (current.getCoefficient() != 0) {
            	this.pivot = current;
            }
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
    
    private boolean updateCoefficientAndReturnsIsBallanced(Branch branch) {
    	Branch current = branch;
    	boolean result = false;
    	while (current != null) {
    		current.setCoefficient(coefficient(current));
    		if (current.getCoefficient() == 2 || current.getCoefficient() == -2) {
    			result = true;
    			break;
    		}
    		current = current.getParent();
    	}
    	return result;
    }

    private void rotate() {
    	switch (this.pivot.getCoefficient()) {
    	case -2:
    		if (this.pivot.getLeft().getCoefficient() > 0) {
    			this.rotateLeft(this.pivot.getLeft());
    		}
    		this.rotateRight(this.pivot);
    		break;
    	case 2:
    		if (this.pivot.getRight().getCoefficient() < 0) {
    			this.rotateRight(this.pivot.getRight());
    		}
    		this.rotateLeft(this.pivot);
    		break;
    	}
    }

    private void rotateRight(Branch branch) {
    	Branch left = branch.getLeft();
    	left.setParent(branch.getParent());
    	branch.setParent(left);
    	branch.setLeft(left.getRight());
    	left.setRight(branch);
    	this.updateCoefficientAndReturnsIsBallanced(branch);
    }
    
    private void rotateLeft(Branch branch) {
    	Branch right = branch.getRight();
    	right.setParent(branch.getParent());
    	branch.setParent(right);
    	branch.setRight(right.getLeft());
    	right.setLeft(branch);
    	this.updateCoefficientAndReturnsIsBallanced(branch);
    }
}