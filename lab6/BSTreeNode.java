package lab6;

public class BSTreeNode {
	private int key;
	private BSTreeNode left, right;
	public BSTreeNode ( int key, BSTreeNode leftPtr, BSTreeNode rightPtr ){ 
		this.key = key;
		left = leftPtr;
		right = rightPtr;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	public void setLeftPtr( BSTreeNode leftPtr) {
		this.left = leftPtr;
	}
	
	public BSTreeNode getLeftPtr() {
		return left;
	}
	public void setRightPtr( BSTreeNode rightPtr) {
		this.right = rightPtr;
	}
	
	public BSTreeNode getRightPtr() {
		return right;
	}
	
}
