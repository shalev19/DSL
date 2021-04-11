package lab6;

public class BSTree {

	private BSTreeNode root;

	public BSTree ( ){ 
		root = null;  //initialized the root
	}
	
	
	// Binary search tree manipulation methods
	public void insert ( int newKey ){ 
		if(retrieve(newKey) == null) {  //check if the key is already in the tree
			root = insert_recursive(root, newKey);  //insert the key recursively
		}
		return;
	}
	
	
	public BSTreeNode retrieve ( int searchKey ){
		return retrieve_recursive(root, searchKey);
	}
	
	
	public void clear ( ){ root  = null;}// Clear tree
	// Binary search tree status methods
	
	public boolean isEmpty ( ){if(root == null) return true; return false;}
	
	
	public boolean isFull ( ){return false; }
	// Print tree methods
	
	
	public String Preorder(){
		StringBuilder str = new StringBuilder();
		return Preorder_recursive(root, str);
	}
	
	
	public String Inorder(){
		StringBuilder str = new StringBuilder();
		return Inorder_recursive(root, str);
	}
	
	
	public String Postorder(){
		StringBuilder str = new StringBuilder();
		return Postorder_recursive(root, str);
	}
	// Recursive partners of the public member methods --- Insert these methods here.

	private BSTreeNode insert_recursive(BSTreeNode node, int newKey) {

		if(node == null) {
			return new BSTreeNode(newKey, null, null);

		}
		if(newKey < node.getKey()) 
			node.setLeftPtr(insert_recursive(node.getLeftPtr(),  newKey));

		if(newKey > node.getKey())
			node.setRightPtr(insert_recursive(node.getRightPtr(), newKey));

		return node;
	}
	private BSTreeNode retrieve_recursive(BSTreeNode node, int searchKey) {
		if(node == null) return null;  //the key didn't found

		if(node.getKey() == searchKey ) return node;
		else if(node.getKey()< searchKey) return retrieve_recursive(node.getLeftPtr(), searchKey);
		else if(node.getKey()> searchKey) return retrieve_recursive(node.getRightPtr(), searchKey);

		return null;
	}
	public String  Preorder_recursive(BSTreeNode node, StringBuilder str){
		if(node != null) {
			str.append(node.getKey() + " ");
			Preorder_recursive(node.getLeftPtr(), str);
			Preorder_recursive(node.getRightPtr(), str);
		}

		return str.toString();
	}
	public String  Inorder_recursive(BSTreeNode node, StringBuilder str){
		if(node != null) {

			Inorder_recursive(node.getLeftPtr(), str);
			str.append(node.getKey() + " ");
			Inorder_recursive(node.getRightPtr(), str);
		}

		return str.toString();
	}
	public String  Postorder_recursive(BSTreeNode node, StringBuilder str){	
		if(node != null) {

			Postorder_recursive(node.getLeftPtr(), str);
			Postorder_recursive(node.getRightPtr(), str);
			str.append(node.getKey() + " ");
		}

		return str.toString();
	}
	
	
	public BSTreeNode getRoot() {
		return root;
	}
	
	
	public int heigth(BSTreeNode root) {  
		if (root == null) 
			return -1;   
		else 
		{ 
			/* compute the depth of each subtree */
			int lDepth = heigth(root.getLeftPtr()); 
			int rDepth = heigth(root.getRightPtr()); 

			/* use the larger one */
			if (lDepth > rDepth) 
				return (lDepth + 1); 
			else 
				return (rDepth + 1); 
		} 	
	}


}
