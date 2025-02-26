package program16;

/**
* @author:	 	Maya Taylor
* Date:   	 	FEB2025
* Course: 	 	APCSA 3RD
* Description:	Tree hides nodes from any other class
* 				A Tree class that implements the BSTree 
* 				interface and uses TreeNode class
* @param <T>
*/

public class BinaryTree<T extends Comparable<T>> implements BSTree<T>
{
	private TreeNode<T> myRoot;
	
	/**
	 * constructor with init TreeNode root=null
	 */
	public BinaryTree()
	{
		myRoot=null;
	}
	
	/**
	 * the public interface to add an object to the tree 
	 */
	public void add(T data)
	{
		myRoot = addData(myRoot,data);
	}
	
	/**
	 * Need a generic implementation to add an object to the tree.
	 * Private helper method.
	 * Creates TreeNode with ln and rn pointing to null.
	 * Adds TreeNodes lexicographically: less to ln/greater to rn
	 * check if comparable before casting
	 * Comparable data parameter
	 * @param data
	 * @param r
	 */
	private TreeNode<T> addData(TreeNode<T> r, T data)
	{
		if(r==null) {r =  new TreeNode<>(data, null, null);}
		

		//keeps duplicates by placing to leftNode <=
		else {
			
			if(data.compareTo(r.getData()) <= 0)
			{
				r.setLeftNode(addData(r.getLeftNode(), data));
			}
		
			else {
			r.setRightNode(addData(r.getRightNode(), data));
			}	
		}
		return r;
	}

	/**
	 * the public interface to search the tree 
	 */
	public boolean search(Comparable<T> o) 
	{
		return search(o,myRoot);
	}
	
	/**
	 * Generic implementation to search an object of the tree.
	 * private helper
	 * @param c
	 * @param r
	 * @return
	 */
	private boolean search(Comparable<T> c, TreeNode<T> r)
	{
		if(r==null) return false;
		int compare = c.compareTo(r.getData());

	    if (compare == 0) return true;
	    else if (compare < 0) return search(c, r.getLeftNode());
	    else return search(c, r.getRightNode());
	}

	/**
	 * Generic implementation to return height of tree
	 */
	public int height() 
	{
		return height(myRoot);
	}
	
	/**
	 * private helper 
	 * uses recursive call
	 * @param root
	 * @return
	 */
	private int height(TreeNode<T> root)
	{
		if (root==null) return 0;
		return 1+Math.max(height(root.getLeftNode()), 
				height(root.getRightNode()));
	}
	
	/**
	 * generic implementation of toString printing inOrder
	 */
	public String toStringinOrder()
	{
		return toStringinOrder(myRoot);
	}
	
	/**
	 * private helper to toStringinOrder
	 * LPR
	 * in order parent is always inbetween recursive calls L and R
	 * @param r
	 * @return
	 */
	private String toStringinOrder(TreeNode<T> r)
	{
		if(r==null) return "";

		return "{" + toStringinOrder(r.getLeftNode())+ 
				r.getData() + 
				toStringinOrder(r.getRightNode())+ "}"; 
	}
	
	/**
	 * generic implementation of toString printing preOrder
	 */
	@Override
	public String toStringPreOrder() 
	{
		return toStringPreOrder(myRoot);
	}

	/**
	 * private helper to toStringPreOrder()
	 * PLR order
	 * @param r
	 * @return
	 */
	private String toStringPreOrder(TreeNode<T> r)
	{
		if(r==null) return "";
		return "{" + r.getData() + 
				toStringPreOrder(r.getLeftNode())+ 
				toStringPreOrder(r.getRightNode())+ "}"; 
	}
	
	/**
	 * generic implementation to remove from tree
	 */
	public void remove(Comparable<T> data) 
	{
		remove(data,myRoot);
	}
	
    /**
     * Private helper for remove
     * @param data
     * @param r
     * @return
     */
    private void remove(Comparable<T> data, TreeNode<T> r) 
    {
    	if(r==null) return; //case1: tree is null
    	
    	//case2: only one child
    	TreeNode<T> deleteN = nodeSearch(data,r);
    	if(deleteN==null) return;
    	TreeNode<T> parent = parentNodeSearch(data,myRoot);
    	
    	//deleting leaf node
    	if(deleteN.getLeftNode()==null && deleteN.getRightNode()==null)
    	{
    		if (parent == null && myRoot.getLeftNode()==null 
    				&& myRoot.getRightNode()==null)
    		{
    			//deleting root with no children
    			myRoot=null;
              
            } else if (parent.getLeftNode().equals(deleteN)) {
                parent.setLeftNode(null);
            } 
            else {
                parent.setRightNode(null);
            }	
    	}
    	
    	//deleting node that only has rightNode
    	else if(deleteN.getLeftNode()==null && deleteN.getRightNode()!=null)
    	{
    		TreeNode <T> deleteNChild = deleteN.getRightNode();
    		if(parent==null) 
    		{
    			//deleting root if no left branches
    			myRoot=myRoot.getRightNode();
    			return;
    		}
    		
    		if(parent.getLeftNode().equals(deleteN))
    		{
    			parent.setLeftNode(deleteNChild);
    		}
    		else parent.setRightNode(deleteNChild);
    	}
    	
    	//delete node that only has LeftNode
    	else if(deleteN.getLeftNode()!=null && deleteN.getRightNode()==null)
    	{
    		if(parent==null) 
    		{
    			//deleting root that only has left branches
    			TreeNode<T> replacer       = findMax(deleteN.getLeftNode());
    			TreeNode<T> replacerParent = parentNodeSearch(replacer.getData(),myRoot);
    			myRoot.setData(replacer.getData());
    			 if (replacerParent.getRightNode().equals(replacer)) {
    	                replacerParent.setRightNode(replacer.getLeftNode());
    	            } else {
    	                replacerParent.setLeftNode(replacer.getLeftNode());
    	            }
    			 return;
    		}
    		
    		TreeNode <T> deleteNChild = r.getLeftNode();
    		if(parent.getLeftNode()!=null)
    		{
    			if(parent.getLeftNode().equals(deleteN))
    			{
    				parent.setLeftNode(deleteNChild);
    			}
    		}
    		else parent.setRightNode(deleteNChild);
    	}
    	
    	//deleting node with two children
    	else {
            TreeNode<T> deleteReplacement = findMin(deleteN.getRightNode());
            TreeNode<T> replaceParent=parentNodeSearch(deleteReplacement.getData(),myRoot);

            deleteN.setData(deleteReplacement.getData());
  
            if (replaceParent.getLeftNode().equals(deleteReplacement)) {
                replaceParent.setLeftNode(deleteReplacement.getRightNode());
            } else {
                replaceParent.setRightNode(deleteReplacement.getRightNode());
            }
    	}
    }

    /**
     * Private helper to find the minimum value in the tree
     * @param r
     * @return
     */
    private TreeNode<T> findMin(TreeNode<T> r) 
    {
        while (r!= null && r.getLeftNode() != null) 
        {
            r = r.getLeftNode();
        }
        return r;
    }
    
    /**
     * helper to find max if root only has left branches and deleting root
     * @param r
     * @return
     */
    private TreeNode<T> findMax(TreeNode<T> r) 
    {
        while (r!= null && r.getRightNode() != null) 
        {
            r = r.getRightNode();
        }
        return r;
    }
    
    /**
     * search that returns a node
     * @param c
     * @param r
     * @return
     */
    private TreeNode<T> nodeSearch(Comparable<T> c, TreeNode<T> r)
	{
		if(r==null) return null;
		else if(c.equals(r.getData())) return r;
		else if(c.compareTo(r.getData())<=0)
		{
			return nodeSearch(c,r.getLeftNode());
		}
		else return nodeSearch(c,r.getRightNode());
	}
	
    /**
     * returns the parent of a node
     * @param c
     * @param r
     * @return
     */
	private TreeNode<T> parentNodeSearch(Comparable<T> c, TreeNode<T> r)
	{
		TreeNode <T> parent = null;
	
		 while (r != null && c.compareTo(r.getData()) != 0)
		 {
	            parent = r;
	            if (c.compareTo(r.getData()) < 0) 
	            {
	                r = r.getLeftNode();
	            } else {
	                r= r.getRightNode();
	            }
		 }
		 return parent;
	}
}

	