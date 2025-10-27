package chatGPT.dataStructure.tree;

/**
 * 트리 - 이진 탐색 트리 생성 및 탐색
 */
class Employee {
	int id;
	String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%d: %s", id, name);
	}
}

public class BST {
	static class  Node {
		Employee data;
		Node left, right;

		Node( Employee data) {
			this.data = data;
		}
	}

	private Node root;

	//노드 추가
	public void insert(Employee employee) {
		root = insertNode(root, employee);
	}

	private Node insertNode(Node root, Employee data) {
		if( root == null ) return new Node(data);

		if( data.id < root.data.id ) {
			root.left = insertNode( root.left, data );
		}else if( data.id > root.data.id ) {
			root.right = insertNode( root.right, data );
		}

		return root;
	}

	//전위 순회
	public void preorderTraversal() {
		preorder(root);
	}

	private void preorder(Node node) {
		if( node == null ) return;

		System.out.println(node.data.toString());

		preorder( node.left );
		preorder( node.right );
	}

	//중위 순회
	public void inorderTraversal() {
		inorder(root);
	}

	private void inorder(Node node) {
		if( node == null ) return;

		inorder(node.left);
		System.out.println( node.data.toString() );
		inorder(node.right);
	}

	//후위 순회
	public void postorderTraversal() {
		postorder(root);
	}

	private void postorder(Node node) {
		if( node == null ) return;

		postorder( node.left );
		postorder( node.right );
		System.out.println( node.data.toString() );
	}

	//사원 검색
	public Employee search(int id) {
		Node found = searchNode(root, id);

		return found == null ? null : found.data;
	}

	private Node searchNode(Node root, int id) {
		if( root == null || root.data.id == id ) {
			return root;
		}

		if( id < root.data.id ) {
			return searchNode( root.left, id );
		}else {
			return searchNode( root.right, id );
		}
	}

	public int height() {
		return getLevel(root);
	}

	private int getLevel(Node node) {
		if( node == null ) return 0;

		int leftHeight = getLevel(node.left);
		int rightHeight = getLevel(node.right);

		return Math.max( leftHeight, rightHeight ) + 1;
	}

	//서브트리 삭제
	public void deleteSubtree(int id) {

	}

	public static void main(String[] args) {
		BST bst = new BST();

		bst.insert(new Employee(101, "Alice"));
		bst.insert(new Employee(102, "Bob"));
		bst.insert(new Employee(100, "Charlie"));
		bst.insert(new Employee(103, "David"));

		Employee e = bst.search(102);
		System.out.println(e.name);

		System.out.println("높이: " + bst.height());

		bst.postorderTraversal();
	}
}