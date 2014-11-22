import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BranchTest {
	
	@Test
	public void returns_value() {
		Branch branch = new Branch(10);
		assertEquals(new Integer(10), branch.getValue());
	}
	
	@Test
	public void returns_parent() {
		Branch branch = new Branch(10);
		Branch parent = new Branch(20);
		branch.setParent(parent);
		assertEquals(parent, branch.getParent());
	}
	
	@Test
	public void returns_right() {
		Branch branch = new Branch(10);
		Branch right = new Branch(15);
		branch.setRight(right);
		assertEquals(right, branch.getRight());
	}
	
	@Test
	public void returns_left() {
		Branch branch = new Branch(10);
		Branch left = new Branch(20);
		branch.setLeft(left);
		assertEquals(left, branch.getLeft());
	}
	
	@Test
	public void returns_coefficient() {
		Branch branch = new Branch(10);
		branch.setCoefficient(10);
		assertEquals(new Integer(10), branch.getCoefficient());
	}
	
}
