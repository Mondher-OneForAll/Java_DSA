package Trees;

public class BinarySearchTree {
    Node root;
    public BinarySearchTree(){
        this.root = null;
    }
    public void insert(int value){
        this.root = insertHelper(this.root, value);
    }

    private Node insertHelper(Node currentRoot, int value) {
        if (currentRoot == null){
            currentRoot = new Node(value);
            return currentRoot;
        }
        else if (value < currentRoot.value)
            currentRoot.left = insertHelper(currentRoot.left, value);
        else currentRoot.right = insertHelper(currentRoot.right, value);

        return currentRoot;
    }

    public void displayInOrder(){
        displayInOrderHelper(this.root);
    }

    private void displayInOrderHelper(Node currentRoot) {
        if (currentRoot != null){
            displayInOrderHelper(currentRoot.left);
            System.out.println(currentRoot.value);
            displayInOrderHelper(currentRoot.right);
        }
    }

    public boolean search(int value){
        return searchHelper(this.root, value);
    }

    private boolean searchHelper(Node currentRoot, int value) {
        if (currentRoot == null) return false;
        else if (value == currentRoot.value) return true;
        else if (value < currentRoot.value) return searchHelper(currentRoot.left, value);
        else  return searchHelper(currentRoot.right, value);
    }
}
