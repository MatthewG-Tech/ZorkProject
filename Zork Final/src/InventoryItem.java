/*
 * Read: Contains Checkpoint 4 tasks
 */
 
 /**
 * This is an Interface called "InventoryItem".  
 * 
 * It allows objects that meet the following criteria to be included in
 * an InventoryItem Type.
 * 
 * Classes that can implement the InventoryItem Interface must be able to get their name,
 * description, and weight.
 * 
 * Note that you cannot create an InventoryItem object
 */
 
 //TODO Checkpoint 4: create the InventoryItem interface and be sure to add the methods noted above to enforce the rules above
 
interface InventoryItem{
	public String getName();
	public String getDescription();
	public double getWeight();
}