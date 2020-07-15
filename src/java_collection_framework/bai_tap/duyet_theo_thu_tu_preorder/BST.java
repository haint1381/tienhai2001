package java_collection_framework.bai_tap.duyet_theo_thu_tu_preorder;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }
    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void preOrder() {
        preOrder(root);
    }

    protected void preOrder(TreeNode<E> root) {
        if (root != null) {
            System.out.println(root.element + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}