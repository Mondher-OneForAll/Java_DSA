package Trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(4);
        bst.insert(7);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(9);
        bst.insert(3);
        bst.insert(6);
        bst.insert(2);

        bst.displayInOrder();

        System.out.println(bst.search(1));
    }
}
