/*
 * PolySolver class
 * Dion de Jong 3/26/2014
 * Ver: 1.00
 * Description: This class creates the LList object. all methods needed for
 * manipulating and adding to the linked list are found here.  
 * Last modified: 3/26/14
 */
public class LList implements ListInterface
{
	private Node firstNode;  // reference to first node
	private Node lastNode;  //reference to last node
	private Node currentNode; //reference to the current node
	private int  length;    // number of entries in list
	private int iterator; 


	public LList()
	{
		//constructor initializes all variables
		firstNode = null;
		currentNode = firstNode; 
		length = 0;
		iterator = 0;
	} // end default constructor

	public final void clear()
	{
		//clears all entries
		firstNode = null;
		length = 0;
	} // end clear

	//add method to create a new node and entry in the list. 
	public boolean add(Object newEntry)
	{
		Node newNode = new Node(newEntry);

		if (isEmpty())
		{
			//must maintain the currentNode variable by setting it to firstNode
			firstNode = newNode;
			currentNode = firstNode; 
		}

		else                   // add to end of nonempty list
		{
			Node lastNode = getNodeAt(length);
			lastNode.next = newNode; // make last node reference new node
		} // end if

		length++;
		return true;
	}  // end add

	//checks if the list is empty
	public boolean isEmpty()
	{
		if (firstNode != null)
		{
			return false;
		}
		return true;
	}// end isEmpty

	// ---------------private!----------------------------- 
	/** Task: Returns a reference to the node at a given position.
	 *  Precondition: List is not empty; 1 <= givenPosition <= length. */
	private Node getNodeAt(int givenPosition)
	{
		Node currentNode = firstNode;

		// traverse the list to locate the desired node
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.next;

		return currentNode;
	}  // end getNodeAt

	private class Node// private inner class
	{
		private Object data; // data portion
		private Node   next; // link to next node

		private Node(Object dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(Object dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node

	//return the data portion of the currentNode
	@Override
	public Object getCurrentEntry() 
	{
		return this.currentNode.data; 
	}

	//iterate to the next node in a linked list
	@Override
	public Object Next()
	{
		//if it's already null (or the last item) return null
		if(currentNode == null)
		{
			return null; 
		}
		//if the next item is not the end, set the current value to the next node (step forward)
		else if (currentNode.next != null)
		{
			this.currentNode = this.currentNode.next; //current node updated.
			this.iterator++;
		}
		
		//if it's the end of the list, specify with a print message. 
		else if (currentNode.next == null)
		{
			currentNode = null; 
			System.out.println("End of the list!");
			this.iterator++;
		} 
		return currentNode;
	}

	//just display the current node
	@Override
	public Object getCurrentNode() 
	{
		return this.currentNode; 
	}

	//print an instance of LList
	public void printList()
	{
		//start at the first node
		Node temp = firstNode;
		//step until you reach the last item
		while (temp != null)
		{
			//take the data portion and parse it to a Data object 
			Data DispData = (Data)temp.data;  
			//save the coefficient and exponent values
			int DispCoeff = DispData.getM_coeff(); 
			int DispExp = DispData.getM_exp(); 
			//display each of these values
			System.out.print(DispCoeff + "x^" + DispExp + " + ");
			//iterate through the list
			temp = temp.next;
		}
	}


} // end LList