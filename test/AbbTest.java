import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AbbTest {
	
	private Abb tree;
	
	public AbbTest() {
		tree = new Abb();
	}
	
	@Test
	public void add_to_root() {
		Branch root = this.tree.add(10);
		assertEquals(root, this.tree.getRoot());
	}
	
	@Test
	public void add_a_less_value() {
		this.tree.add(5);
		Branch left_root = this.tree.add(2);
		assertEquals(left_root, this.tree.getRoot().getLeft());
	}
	
	@Test
	public void add_a_greater_value() {
		this.tree.add(5);
		Branch right_root = this.tree.add(15);
		assertEquals(right_root, this.tree.getRoot().getRight());
	}

	@Test
	public void remove_a_branch_without_child_and_less_value() {
		Branch parent = this.tree.add(20);
		Branch child = this.tree.add(15);
		this.tree.remove(child);
		assertEquals(null, parent.getRight());
	}
	
	@Test
	public void remove_a_branch_without_child_and_greater_value() {
		Branch parent = this.tree.add(20);
		Branch child = this.tree.add(25);
		this.tree.remove(child);
		assertEquals(null, parent.getRight());
	}
	
	@Test
	public void remove_a_branch_with_one_right_child_and_less_that_parent() {
		this.tree.add(20);
		Branch parent = this.tree.add(15);
		Branch child = this.tree.add(18);
		this.tree.remove(parent);
		assertEquals(child, parent.getParent().getLeft());
	}
	
	@Test
	public void remove_a_branch_with_one_right_child_and_greater_that_parent() {
		this.tree.add(20);
		Branch parent = this.tree.add(30);
		Branch child = this.tree.add(35);
		this.tree.remove(parent);
		assertEquals(child, parent.getParent().getRight());
	}
	
	@Test
	public void remove_a_branch_with_one_left_child_and_less_that_parent() {
		this.tree.add(35);
		Branch parent = this.tree.add(30);
		Branch child = this.tree.add(29);
		this.tree.remove(parent);
		assertEquals(child, parent.getParent().getLeft());
	}
	
	@Test
	public void remove_a_branch_with_one_left_child_and_greater_that_parent() {
		this.tree.add(35);
		Branch parent = this.tree.add(40);
		Branch child = this.tree.add(38);
		this.tree.remove(parent);
		assertEquals(child, parent.getParent().getRight());
	}
	
	@Test
	public void remove_a_branch_with_two_children_check_left() {
		this.tree.add(35);
		Branch parent = this.tree.add(30);
		this.tree.add(25);
		this.tree.add(34);
		this.tree.add(33);
		this.tree.add(32);
		Branch child = this.tree.add(31);
		this.tree.remove(parent);
		assertEquals(child.getValue(), parent.getParent().getLeft().getValue());
	}
	
	@Test
	public void remove_a_branch_with_two_children_check_right() {
		this.tree.add(35);
		Branch parent = this.tree.add(40);
		this.tree.add(38);
		this.tree.add(45);
		this.tree.add(42);
		Branch child = this.tree.add(41);
		this.tree.remove(parent);
		assertEquals(child, parent.getParent().getRight());
	}
	
	@Test
	public void allValues() {
		tree.add(10);
		tree.add(2);
		tree.add(25);
		tree.add(13);
		tree.add(9);
		tree.add(18);
		tree.add(33);
		tree.add(11);
		tree.add(28);
		
		Abb expected = new Abb();
		expected.add(2);
		expected.add(9);
		expected.add(10);
		expected.add(11);
		expected.add(13);
		expected.add(18);
		expected.add(25);
		expected.add(28);
		expected.add(33);
		assertEquals(expected.allValues(), tree.allValues());
	}
	
	@Test
	public void height() {
		tree.add(20);
		tree.add(10);
		tree.add(30);
		tree.add(80);
		tree.add(40);
		tree.add(60);
		tree.add(50);
		tree.add(70);
		
		assertEquals(5, tree.height());
	}
	
	@Test
	public void findHeight() {
		tree.add(20);
		tree.add(10);
		Branch branch = tree.add(30);
		tree.add(80);
		tree.add(40);
		tree.add(60);
		tree.add(50);
		tree.add(70);
		
		assertEquals(4, tree.findHeight(branch));
	}
	
	@Test
	public void toStringTest() {
		tree.add(20);
		tree.add(10);
		tree.add(30);
		tree.add(80);
		tree.add(40);
		tree.add(60);
		tree.add(50);
		tree.add(70);
		assertEquals("10 20 30 40 50 60 70 80", tree.toString());
	}
	
	@Test
	public void balacing() {
		tree.add(20);
		tree.add(10);
		tree.add(30);
		tree.add(80);
		tree.add(40);
		tree.add(60);
		tree.add(50);
		tree.add(70);
		
		tree.balance();
		assertTrue(tree.isBalanced());
	}
	
	@Test
	public void isBalancedReturnsTrueForTreeBalancedEmpty() {
		Abb tree = new Abb();

		tree.balance();
		assertTrue(tree.isBalanced());
	}
	
	@Test
	public void isBalancedReturnsTrueForTreeBalancedNotEmpty() {
		tree.add(20);
		tree.add(10);
		tree.add(30);
		tree.add(80);
		tree.add(40);
		tree.add(60);
		tree.add(50);
		tree.add(70);

		tree.balance();
		assertTrue(tree.isBalanced());
	}
	
	@Test
	public void isBalancedReturnsFalseForTreeNotBalancedNotEmpty() {
		tree.add(20);
		tree.add(10);
		tree.add(30);
		tree.add(80);
		tree.add(40);
		assertFalse(tree.isBalanced());
	}

}
