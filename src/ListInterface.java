/**
 *  Version1.5
 *  This version is used for project 6.
 */

/** An interface for the ADT list.
 *  Entries in the list have positions that begin with 1.
 */
public interface ListInterface
{
	/**Task: Returns current node object  
	 * @return null if the current object is null, 
	 *  otherwise current node is returned.
	 */
	public Object getCurrentNode();
	
	/**Task: Returns current Node data
	 * @return Returns current Node data
	 */
	public Object getCurrentEntry();
	
	/**Task: Move the CurrentNode forward.
	 * @return returns CurrentNode object. 
	 * Returns null if list is empty or CurrentNode is null 
	 */
	public Object Next();
	
	/** Task: Adds a new entry to the end of the list.
	 *  @param newEntry  the object to be added as a new entry
	 *  @return true if the addition is successful, or false if not */
	public boolean add(Object newEntry);
		
	
	/** Task: Determines whether the list is empty.
	 *  @return true if the list is empty, or false if not */
	public boolean isEmpty();

} // end ListInterface