
public class AVLTree {
	private AVLTreeNode root;

	public AVLTree (){ 
		root = null;

	}

	public void insert (int newElement){
		if(retrieve(newElement) == null) {  //check if the key is already in the tree
			root = insert_recursive(root, newElement);  //insert the key recursively
		}
		return;


	}

	public int checkBalance(AVLTreeNode node) {  //check the balance of given node
		if(node == null) return 0;
		if(node.getLeft() == null && node.getRight() == null) return 0;

		if(node.getLeft() == null) return -1 - node.getRight().getHeight();
		if(node.getRight() == null) return 1 + node.getLeft().getHeight();


		return node.getLeft().getHeight() - node.getRight().getHeight();

	}

	int max(int a, int b) { 
		return (a > b) ? a : b; 
	} 


	int height(AVLTreeNode node) { // calculate the height of given node
		if (node == null) return 0; 

		if(node.getLeft() == null && node.getRight() == null) return 0;

		if(node.getLeft() == null) return 1 + node.getRight().getHeight();

		if(node.getRight() == null) return 1 + node.getLeft().getHeight();



		return 1 + max(node.getRight().getHeight(), node.getLeft().getHeight()); 
	}





	private AVLTreeNode insert_recursive(AVLTreeNode node, int newKey) {


		if(node == null){
			return new AVLTreeNode(newKey, 0, null, null);
		}
		if(node.getKey() > newKey) {
			node.setLeft( insert_recursive(node.getLeft(), newKey));

		}
		else {
			node.setRight( insert_recursive(node.getRight(), newKey));
		}
		node.setHeight(height(node));

		int balance = checkBalance(node);

		if(balance > 1 && checkBalance(node.getLeft()) >= 0) { // left left rotate
			return LL(node);
		}
		if (balance >1 && checkBalance(node.getLeft()) < 0 ) { // left right rotate
			return LR(node); 
		}

		if (balance < -1 && checkBalance(node.getRight()) <= 0) { //right right rotate
			return RR(node); 
		} 

		if (balance < -1 && checkBalance(node.getRight()) > 0) { //right left rotate
			return RL(node); 
		} 

		return node;


	}

	private AVLTreeNode LL(AVLTreeNode node) {  // left left rotate

		AVLTreeNode tmp = node.getLeft();
		node.setLeft(tmp.getRight());

		tmp.setRight(node);

		return tmp;
	}

	private AVLTreeNode LR(AVLTreeNode node) {// left right rotate
		node.setLeft(RR(node.getLeft()));

		return LL(node);
	}

	private AVLTreeNode RL(AVLTreeNode node) {  //right left rotate
		node.setRight(LL(node.getRight()));

		return RR(node);
	}

	private AVLTreeNode RR(AVLTreeNode node) {//right right rotate

		AVLTreeNode tmp = node.getRight();

		node.setRight(tmp.getLeft());

		tmp.setLeft(node);

		return tmp;
	}

	public AVLTreeNode retrieve (int searchKey){
		return retrieve_recursive(root, searchKey);
	}

	private AVLTreeNode retrieve_recursive(AVLTreeNode node, int searchKey) {

		if(node == null) return null;  //the key didn't found

		if(node.getKey() == searchKey ) {
			return node;
		}


		if(node.getKey() < searchKey) { return retrieve_recursive(node.getRight(), searchKey);

		} else if(node.getKey() >= searchKey) return retrieve_recursive(node.getLeft(), searchKey);

		return null;
	}

	public void clear (){
		root = null;
	}// Clear tree

	public boolean isEmpty (){
		if(root == null) return true;

		return false;
	}

	public boolean isFull (){
		return false;
	} 

	@Override
	public String toString(){
		return Inorder();
	} // Output the tree structure in InOrder
	// Recursive partners of the public member methods --- Insert these methods here.

	public int heigth(AVLTreeNode root) {  
		if (root == null) 
			return 0;   
		else 
		{ 
			// compute the depth of each subtree
			int lDepth = heigth(root.getLeft()); 
			int rDepth = heigth(root.getRight()); 

			// use the larger one 
			if (lDepth > rDepth) 
				return (lDepth + 1); 
			else 
				return (rDepth + 1); 
		} 	
	}

	private AVLTreeNode findParentRec(AVLTreeNode node, int key) {  //find the parent of the node with the given key
		if(node == null) {
			return null;
		}
		if(node.getKey() == key) {  //return the current node
			return node;
		}

		if(node.getKey() < key) { 

			if(node.getRight() == null) {
				return null;
			}
			if(node.getRight().getKey() == key) {
				return node;
			}
			return findParentRec(node.getRight(), key);
		}

		if(node.getKey() > key) {  //else search on the left
			if(node.getLeft() == null) {
				return null;
			}
			if(node.getLeft().getKey() == key) {
				return node;
			}

		}
		
		return findParentRec(node.getLeft(), key);

	}

	public AVLTreeNode findParent(int key) { //find the parent of the node with the given key

		if(root == null) return null;
		if(root.getLeft() != null && root.getLeft().getKey() == key) {  //make sure that the root has no son with the same value
			return findParentRec(root.getLeft(), key);
		}
		else if(root.getRight() != null && root.getRight().getKey() == key) {//make sure that the root has no son with the same value
			return findParentRec(root.getRight(), key);
		}

		else if(root.getKey() == key) {  //return the current node if there is no father
			return root;
		}
		return findParentRec(root, key);  //Search recursively
	}

	public String Inorder(){
		StringBuilder str = new StringBuilder();
		return Inorder_recursive(root, str); //change
	}

	public String  Inorder_recursive(AVLTreeNode node, StringBuilder str){
		if(node != null) {

			Inorder_recursive(node.getLeft(), str);
			str.append(node.getKey() + " ");
			Inorder_recursive(node.getRight(), str);
		}

		return str.toString();
	}


}
