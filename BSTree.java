package program16;

/**
* @author:	 	Maya Taylor
* Date:   	 	FEB2025
* Course: 	 	APCSA 3RD
* Description:	BSTree interface has methods to be defined
* 				in another class. Uses parameterization
*/

public interface BSTree<T> 
{
	/**
	 * adds object to Tree
	 * @param c
	 */
	public void add(T c);
	
	/**
	 * return true if object is in Tree
	 * false otherwise
	 * @param s
	 * @return
	 */
	public boolean search(Comparable<T> s);
	
	/**
	 * returns height of tree
	 * Level or Order of node is # of parents
	 * +1 to include current level
	 * @return
	 */
	public int height();
	
	/**
	 * prints Tree in preOrder
	 * PLR
	 * @return
	 */
	public String toStringPreOrder();
	
	/**
	 * prints Tree in inOrder
	 * LPR
	 * @return
	 */
	public String toStringinOrder();
	
	/**
	 * removes object from tree if
	 * tree contains else do nothing
	 * @param r
	 */
	public void remove(Comparable<T> r);
}
