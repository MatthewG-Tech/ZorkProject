import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;

public class gardenItem implements InventoryItem{
	private String name;
	private String description;
	private double weight;
	private static double health;
	private boolean growing = false;
	private static InventoryItem itemGrowing;
	private int numberItems;
	private double itemHealth;
	private static Timer timer = new Timer();
	/**
	 * The Item constructor 
	 * It constructs a new instance of an Item object
	 * @param: a string to set the name of an Item object
	 * @param: a string to set the description of an Item object
	 * @param: a double to set the starting weight of an Item object
	*/
	public gardenItem(String name, String description, double weight){
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.health = 5;
	}
	public gardenItem(String name, String description, double weight, double health){
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.health = health;
	}
	
	/**
	 * setName mutator method
	 * This method is used to change the name of an Item object
	 * @param: a String to update the name of an Item object
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * setDescription mutator method
	 * This method is used to change the description of an Item object
	 * @param: a String to update the description of an Item object
	*/
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	 * setWeight mutator method
	 * This method is used to change the weight of an Item object
	 * @param: a double to update the weight of an Item object
	*/	
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	/**
	 * getName accessor method
	 * This method is used to retrieve the name of an Item object
	 * @return: a String that is the name of an Item object
	*/	
	
	public String getName(){
		return this.name;
	}

	/**
	 * getDescription accessor method
	 * This method is used to retrieve the description of an Item object
	 * @return: a String that is the description of an Item object
	*/	
	
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * getWeight accessor method
	 * This method is used to retrieve the weight of an Item object
	 * @return: a double that is the weight of an Item object
	*/	
	
	public double getWeight(){
		return this.weight;
	}
	
	/**
	 * toString accessor method
	 * This method overwrites the default toString method and 
	 * is used to retrieve all of the characteristics of an Item object	 
	 * @return: a String that is all of the characteristics of an Item object
	*/		
	public void setGrowing(boolean bool){
		startGrowing();
		growing = bool;
	}
	public boolean isGrowing(){
		return growing;
	}
	public String toString(){
		return "name: " + name +
				"\ndescription: " + description +
				"\nweight: " + weight;
	}
	public void setItemGrowing(InventoryItem item){
		itemGrowing = item;
		health = ((Food) (item)).getHealthValue();
	}
	public double pickItem(){
		if(health <= 5.0){
			return 0.0;
		}
		//health -= 5;
		//if(health <= 5.0){
			//setGrowing(false);
		//}
		return 1.0 * (int)(Math.random()*5);
	}
	public double getHealth(){
		if(growing == false){
			return (Double) null;
		}
		return health;
	}
	public static void startGrowing(){
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				if(health  <= 0.0){
					cancel();
				}else{
					health++;
				}
			}
		};
		timer.schedule(task, 0, 1000);
	}
}
