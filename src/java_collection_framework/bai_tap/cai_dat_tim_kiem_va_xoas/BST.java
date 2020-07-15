package java_collection_framework.bai_tap.cai_dat_tim_kiem_va_xoas;

public class BST<E extends Comparable<E>> {
    TreeNode<E> root;
    int size;

    public void insert(E e) {

        if (this.root == null) {
            this.root = new TreeNode<>(e);
        } else {
            TreeNode<E> rootTmp = this.root;
            TreeNode<E> parent = null;

            while (rootTmp != null) {
                if (e.compareTo(rootTmp.e) < 0) {
                    parent = rootTmp;
                    rootTmp = rootTmp.left;
                } else if (e.compareTo(rootTmp.e) > 0) {
                    parent = rootTmp;
                    rootTmp = rootTmp.right;
                } else {
                    return;
                }
            }

            if (e.compareTo(parent.e) < 0) {
                parent.left = new TreeNode<>(e);
            } else {
                parent.right = new TreeNode<>(e);
            }
        }
        size++;
    }

    public void print(TreeNode root) {
        if (root != null) {
            System.out.println(root.e);
            print(root.left);
            print(root.right);
        }
    }
    public boolean search(TreeNode<E> root, E e){
        if (root == null) {
            return  false;
        }else {
            if(root.e == e){
                return  true;
            }else {
                if(e.compareTo((E)root.e) < 0){
                    return search(root.left, e);
                }else {
                    return search(root.right,e);
                }
            }

        }
    }
    public TreeNode<E> delete(TreeNode<E> root, E e){
        if(root==null){
            return null;
        }else if(e.compareTo((E)root.e) < 0){
            root.left=delete(root.left,e);
        }else if(e.compareTo((E)root.e) > 0){
            root.right=delete(root.right,e);
        } else {
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }else {
                root.e= rightMinValue(root.right);
                root.right= delete(root.right,root.e);
            }
        }
        return root;
    }
    public E rightMinValue(TreeNode<E> root){

        while ( root.left !=null ){
            root = root.left;
        }
        return root.e;
    }
}
