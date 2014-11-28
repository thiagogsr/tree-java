import java.util.ArrayList;


public class MinHeap {
	
	public ArrayList<Branch> list;
	
	public MinHeap() {
		this.list = new ArrayList<Branch>();
	}
	
	public void insert(Integer value) {
		this.list.add(new Branch(value));
		this.bubbleUp(this.last());
	}
	
	public Branch next() {
		Branch result = this.list.get(0);
		if (this.listLength() > 1) {
			this.list.set(0, this.list.get(this.last()));
			this.list.remove(this.last());
			this.bubbleDown(0);
		}
		return result;
	}
	
	public int listLength() {
		return this.list.size();
	}
	
	private void bubbleUp(Integer index) {
		Integer idx_parent = this.getParent(index);
		Branch current = this.list.get(index);
		while (index > 0 && this.list.get(idx_parent).getValue() > current.getValue()) {
			this.list.set(index, this.list.get(idx_parent));
			index = idx_parent;
			idx_parent = this.getParent(index);
		}
		this.list.set(index, current);
	}

	private void bubbleDown(Integer index) {
		Integer idx_smaller, idx_right, idx_left;
		Branch current = this.list.get(index);
		Integer listSize = listLength();
		while ((index + 1) * 2 <= listSize) { 
			idx_left = this.getLeft(index);
			idx_right = this.getRight(index);
			if ((idx_right <= this.last()) && (this.list.get(idx_right).getValue() < (this.list.get(idx_left).getValue()))) {
				idx_smaller = idx_right;
			} else {
				idx_smaller = idx_left;
			}
			if (current.getValue() < this.list.get(idx_smaller).getValue()) {
				break;
			}
			this.list.set(index, this.list.get(idx_smaller));
			index = idx_smaller;
		}
		this.list.set(index, current);
	}
	
	private Integer getParent(Integer index) {
		return (index + 1) / 2 - 1;
	}
	
	private Integer getLeft(Integer index) {
		return 2 * (index + 1) - 1;
	}
	
	private Integer getRight(Integer index) {
		return this.getLeft(index) + 1;
	}
	
	private int last() {
		return listLength() - 1;
	}

}
