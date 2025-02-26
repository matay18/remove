/**
 * @author Emma Holt
 * Date: February 2025
 * Class: 3rd Hour AP CSA
 * 
 * Description: It is a tree.
 */
public class Tree implements BSTree {
	
    private TreeNode root;

    public Tree() {
        root = null;
    }
    
    /**
     * Add method. Calls recursive add.
     */
    public void add(Comparable data) {
        root = add(root, data);
    }

    /**
     * Private helper method.
     * Recursive method that adds a treeNode based on its value.
     * @param r
     * @param d
     * @return
     */
    private TreeNode add(TreeNode r, Comparable d) {
        if (r == null) {
            return new TreeNode(d, null, null);
        } else if (d.compareTo(r.getValue()) < 0) {
            r.setLeft(add(r.getLeft(), d));
        } else {
            r.setRight(add(r.getRight(), d));
        }
        return r;
    }

    /**
     * Search method. Calls recursive method.
     */
    public boolean search(Comparable data) {
        return search(root, data);
    }

    /**
     * Private helper method.
     * Recursive method, returns true of the treeNode with the
     * 	specified data is in the tree.
     * @param r
     * @param d
     * @return
     */
    private boolean search(TreeNode r, Comparable d) {
        if (r == null) {
            return false;
        } else if (d.compareTo(r.getValue()) == 0) {
            return true;
        } else if (d.compareTo(r.getValue()) < 0) {
            return search(r.getLeft(), d);
        } else {
            return search(r.getRight(), d);
        }
    }

    /**
     * Returns height. Calls recursive method.
     */
    public int height() {
        return height(root);
    }

    /**
     * Private helper method.
     * Returns height (based on levels).
     * @param r
     * @return
     */
    private int height(TreeNode r) {
        if (r == null) return 0;
        return 1 + Math.max(height(r.getLeft()), height(r.getRight()));
    }

    /**
     * Calls recursive toString (InOrder) method.
     * In-Order (Left, Root, Right)
     */
    public String toStringInOrder() {
        return toStringInOrder(root);
    }

    /**
     * Private helper method.
     * Recursive toString method that prints out in InOrder notation.
     * In-Order (Left, Root, Right)
     */
    private String toStringInOrder(TreeNode r) {
        if (r == null) return "";
        return toStringInOrder(r.getLeft()) + r.getValue() + " " + toStringInOrder(r.getRight());
    }

    /**
     * Pre-Order (Root, Left, Right)
     * Calls recursive toString (PreOrder) method.
     */
    public String toStringPreOrder() {
        return toStringPreOrder(root);
    }

    /**
     * Private helper method.
     * Recursive toString method. Prints in PreOrder notation.
     * @param r
     * @return
     */
    private String toStringPreOrder(TreeNode r) {
        if (r == null) return "";
        return r.getValue() + " " + toStringPreOrder(r.getLeft()) + toStringPreOrder(r.getRight());
    }
    
       /**
        * Remove method. Calls private recursive method.
        */
      public void remove(Comparable data) {
            root = remove(root, data);
        }

      private TreeNode remove(TreeNode r, Comparable d) {
    	    if (r == null) {
    	        return null;
    	    }

    	    if (d.compareTo(r.getValue()) < 0) {
    	        r.setLeft(remove(r.getLeft(), d));
    	    } else if (d.compareTo(r.getValue()) > 0) {
    	        r.setRight(remove(r.getRight(), d));
    	    } else {
    	        // Node with only one child or no child
    	        if (r.getLeft() == null) {
    	            return r.getRight();
    	        } else if (r.getRight() == null) {
    	            return r.getLeft();
    	        }

    	        // Node with two children: Get the inorder predecessor (largest in the left subtree)
    	        r.setValue(maxValue(r.getLeft()));

    	        // Delete the inorder predecessor
    	        r.setLeft(remove(r.getLeft(), (Comparable) r.getValue()));
    	    }

    	    return r;
    	}

    	/**
    	 * Private helper method to find the maximum value in a subtree.
    	 * @param r The root of the subtree.
    	 * @return The largest value in the subtree.
    	 */
    	private Comparable maxValue(TreeNode r) {
    	    Comparable maxv = (Comparable) r.getValue();
    	    while (r.getRight() != null) {
    	        maxv = (Comparable) r.getRight().getValue();
    	        r = r.getRight();
    	    }
    	    return maxv;
    	}
}