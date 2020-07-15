package java_collection_framework.bai_tap.cai_dat_tim_kiem;


public class BSTTest {

    public static void main(String[] args) {
        BST<Integer> treeBST = new BST<Integer>();
        treeBST.insert(5);
        treeBST.insert(3);
        treeBST.insert(4);
        treeBST.insert(6);
        treeBST.insert(7);
        treeBST.insert(8);
        treeBST.delete(treeBST.root,4);
        System.out.println(treeBST.search(treeBST.root,6));
        treeBST.print(treeBST.root);
        System.out.println("Size " + treeBST.size);

    }
}