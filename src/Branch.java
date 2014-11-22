public class Branch {

    private Integer value;
    private Branch parent;
    private Branch left;
    private Branch right;
    private Integer coefficient;
    
    public Branch(Integer value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.coefficient = 0;
    }

    public Integer getValue() {
        return value;
    }

    public Branch getParent() {
        return parent;
    }

    public void setParent(Branch parent) {
        this.parent = parent;
    }

    public Branch getLeft() {
        return left;
    }

    public void setLeft(Branch left) {
        this.left = left;
    }

    public Branch getRight() {
        return right;
    }

    public void setRight(Branch right) {
        this.right = right;
    }

	public Integer getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Integer coefficient) {
		this.coefficient = coefficient;
	}

}