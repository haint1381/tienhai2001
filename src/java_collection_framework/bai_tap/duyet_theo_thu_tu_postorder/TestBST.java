package java_collection_framework.bai_tap.duyet_theo_thu_tu_postorder;

public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(45);
        tree.insert(57);
        tree.insert(59);
        tree.insert(100);
        tree.insert(67);
        tree.insert(107);
        tree.insert(101);
        //traverse tree
        System.out.println("postOrder (sorted): ");
        tree.postOrder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
