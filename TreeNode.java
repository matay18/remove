package program16;

/**
* @author:	 	Maya Taylor
* Date:   	 	FEB2025
* Course: 	 	APCSA 3RD
* Description:	each TreeNode has data and pointers for
* 				left and right nodes
*/

public class TreeNode<T>
{
	private T   data;
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;
	
	/**
	 * TreeNode constructor w/ parameters:
	 * @param initData
	 * @param ln
	 * @param rn
	 */
	public TreeNode(T initData, TreeNode<T> ln, TreeNode<T> rn)
	{
		data      =initData;
		leftNode  = ln;
		rightNode = rn;
	}

	/**
	 * @return the data
	 */
	public T getData() 
	{
		return data;
	}

	/**
	 * @param d the data to set
	 */
	public void setData(T d) 
	{
		data = d;
	}

	/**
	 * @return the leftNode
	 */
	public TreeNode<T> getLeftNode() 
	{
		return leftNode;
	}

	/**
	 * @param ln the leftNode to set
	 */
	public void setLeftNode(TreeNode<T> ln) 
	{
		leftNode = ln;
	}

	/**
	 * @return the rightNode
	 */
	public TreeNode<T> getRightNode() 
	{
		return rightNode;
	}

	/**
	 * @param rn the rightNode to set
	 */
	public void setRightNode(TreeNode<T> rn) 
	{
		rightNode = rn;
	}
}
