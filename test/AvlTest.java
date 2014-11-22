import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AvlTest {

	private Avl tree;

	public AvlTest() {
		this.tree = new Avl();
	}

	@Test
	public void insert_and_still_balanced() {
		tree.add(20);
		tree.add(30);
		tree.add(10);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void insert_and_rotate_right() {
		tree.add(15);
		tree.add(10);
		tree.add(5);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void insert_and_rotate_left() {
		tree.add(25);
		tree.add(30);
		tree.add(35);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void insert_and_rotate_left_right() {
		tree.add(45);
		tree.add(15);
		tree.add(30);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void insert_and_rotate_right_left() {
		tree.add(20);
		tree.add(30);
		tree.add(25);
		assertTrue(tree.isBalanced());
	}
	
	@Test
	public void remove_and_still_balanced() {
		tree.add(10);
		tree.add(30);
		Branch to_delete = tree.add(5);
		tree.delete(to_delete);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void remove_and_rotate_right() {
		tree.add(10);
		tree.add(5);
		Branch to_delete = tree.add(20);
		tree.add(2);
		tree.delete(to_delete);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void remove_and_rotate_left() {
		tree.add(10);
		Branch to_delete = tree.add(5);
		tree.add(20);
		tree.add(30);
		tree.delete(to_delete);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void remove_and_rotate_right_left() {
		tree.add(10);
		tree.add(5);
		Branch to_delete = tree.add(12);
		tree.add(8);
		tree.delete(to_delete);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void remove_and_rotate_left_right() {
		tree.add(10);
		Branch to_delete = tree.add(5);
		tree.add(12);
		tree.add(15);
		tree.delete(to_delete);
		assertTrue(tree.isBalanced());
	}

	@Test
	public void remove_special_case() {
		tree.add(6);
		Branch to_delete = tree.add(2);
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.delete(to_delete);
		assertTrue(tree.isBalanced());
	}
	
}