package tree;

public abstract class AbstractTree<E> implements Tree<E> {
    public void inorder(TreeNode<E> root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }
}
