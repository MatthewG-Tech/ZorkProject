/*
 * 
 * In Checkpoint 4, students you will add an inventory, update
 *  your map to your own world, and then make it fully functional.
 *
 */


/*
 * CLASS CONTAINS: 4 tasks
 * 
 * All green comments are tasks for this checkpoint
 * 
 */


import java.util.*;
import java.io.*;

/**
 * Creates the class Commands, 
 * There will only be one instance used by the game
 * therefore all of its methods are static to prevent multiple
 */
public class Commands {

/**
 * Variable to end the game
 */
 
  public static boolean quit;

/**
 * Class level variables that need to be accessible throughout the code
 **/
  public static int gameCounter = 100;
  public static Room[][] map;
  public static int row;
  public static int column;
  public static Room currentRoom;
  private static double health = 105;
  private static Timer timer = new Timer();
  private static String command;
  private static boolean done;
  private static boolean inRover;
/* 
 * TODO: Checkpoint 4 Task
 * 
 * Declare an ArrayList called "inventory".  
 * This should be type InventoryItem
 * This ArrayList will be needed to carry your various objects
 */

  public static ArrayList<InventoryItem> inventory;  
  
  
	
/**
 * runGame method
 * method responsible for running a console version of the game
 * this method returns nothing and has no parameters
 * it contains the while loop that is used to run the game
 */
	public static void runGame(){
	  

/* 
 * TODO: Checkpoint 4 Tasks 
 * 
 * Declare and Construct the objects for your game.
 * 
 */
 
		InventoryItem apple = new Food("apple","Increaces life. You can eat it or save it to grow it", 0.5);
		InventoryItem orange = new Food("orange", "Increaces life", 1);
		InventoryItem banana = new Food("banana", "Increaces life", 0.75);
		InventoryItem potato = new Food("potato", "Increaces life", 1.5);
		InventoryItem soil = new Item("soil", "Can be used to grow food", 5);
		InventoryItem waterBottle = new Food("water bottle", "Increaces life", 2);
		InventoryItem rover = new Item("rover", "Transportation", 100000000000.0);
		InventoryItem knife = new Item("knife", "Utility tool", 0.5);
		InventoryItem spoon = new Item("spoon", "Utility tool", 0.5);
		InventoryItem fork = new Item("fork", "Utility tool", 0.5);
		InventoryItem bed = new Item("bed", "Sleep to gain health", 1000000000.0);
		InventoryItem computer = new Item("computer", "Can be used to gain information", 1000000000.0);
		InventoryItem rock = new Item("rock", "Does something", 10);
		InventoryItem chemicals = new Item("chemicals", "Does something", 5);
		//InventoryItem spaceSuit = new Item("spacesuit", "You now look like Starman", 100);
		InventoryItem pot = new gardenItem("garden pot", "Used to grow food", 100000000.0);
		//InventoryItem keyRover = new Key("Rover Key", "open rover", )
		
		InventoryItem keyComunications = new Key("Communications Key", "open a door", "Dining Room", "West");
		ArrayList<String> tempFoodKey = new ArrayList<String>();
		tempFoodKey.add("Dining Room");
		tempFoodKey.add("Kitchen");
		tempFoodKey.add("Kitchen");
		ArrayList<String> tempFoodDirection = new ArrayList<String>();
		tempFoodDirection.add("East");
		tempFoodDirection.add("North");
		tempFoodDirection.add("South");
		InventoryItem keyFood = new Key("Kitchen Key", "opens door to kitchen, garden and storage", tempFoodKey, tempFoodDirection);
		InventoryItem labKey = new Key("Lab key", "opens door to the lab", "Communications", "South");
		InventoryItem marsKey = new Key("Spacesuit", "is needed to go on to mars surface", "Hall", "North");

		
		
		
		
    
    
		
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the map values for the rows and columns to the size required for your world
 * your world might not be 3 rows and 3 columns as noted below
 */
 
    map = new Room[4][3];

    
    
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the Room constructors to match the Rooms in your world and add constructors
 * for additional Rooms.
 * 
 * Be sure to construct every Room in your map (especially if you changed the size of 
 * the map)
 * 
 * If the space on the map is not actually a Room, use the default constructor
 *
 * Finally, construct Rooms that have objects by using the new 7 parameter 
 * constructor you made in the Room class.
 */    
    ArrayList<InventoryItem> gardenItems = new ArrayList<InventoryItem>();
    //gardenItems.add(soil);
    //gardenItems.add(apple);
    gardenItems.add(pot);
    ArrayList<InventoryItem> diningRoomItems = new ArrayList<InventoryItem>();
    diningRoomItems.add(keyComunications);
    ArrayList<InventoryItem> labItems = new ArrayList<InventoryItem>();
    labItems.add(chemicals);
    labItems.add(rock);
    labItems.add(keyFood);
    ArrayList<InventoryItem> livingRoomItems = new ArrayList<InventoryItem>();
    livingRoomItems.add(bed);
    livingRoomItems.add(apple);
    ArrayList<InventoryItem> communciationsItems = new ArrayList<InventoryItem>();
    communciationsItems.add(marsKey);
    for (int r = 0; r < map.length; r++){
		for(int c = 0; c < map[r].length; c++){
			if(r == 0 && c == 1){
				map[0][1] = new Room(false, true, true, false, "Mars Surface", "Mars landscape with a landing pad in the east");
			}else if(r == 0 && c == 2){
				map[0][2] = new Room(false, false, false, true, "Mars Landing Pad", "The landing pad for the rocket",labKey);
			}else if(r == 1 && c == 0){
				//map[1][0] = new Room(false, true, false, false, "Servers", "The base's server room");
			}else if(r == 1 && c == 1){
				map[1][1] = new Room(false, false, true, false, "Hall", "A hallway for people to exit to mars surface");
			}else if(r == 1 && c == 2){
				map[1][2] = new Room(false, false, true, false, "Storage", "The storage has extra food and and tools ",soil);
			}else if(r == 2 && c == 0){
				map[2][0] = new Room(false, true, false, false, "Communications", "A room with tools to add items to get communications to earth",communciationsItems);
			}else if(r == 2 && c == 1){
				map[2][1] = new Room(true, false, true, false, "Dining Room", "A room with old food plates and utensils", diningRoomItems);
			}else if(r == 2 && c == 2){
				map[2][2] = new Room(false, false, false, true, "Kitchen", "Has some food but not a lot of food but lots of kitchen supplies",apple);
			}else if(r == 3 && c == 0){
				map[3][0] = new Room(true, false, false, false, "Lab", "A room with different experiments and tools that could help the you",labItems);
			}else if(r == 3 && c == 1){
				map[3][1] = new Room(true, false, false, false, "Living Rooms", "The place where people will sleep",livingRoomItems);
			}else if(r == 3 && c == 2){
				map[3][2] = new Room(true, false, false, false, "Garden", "Where you can grow food",gardenItems);
			}else{
				map[r][c] = new Room();
			}
		}
	}
    
    
    
    
    

    
/* 
 * Checkpoint 4 alternate solution to adding items to Rooms for teacher reference
 * 
 * (optional) TODO: add items to desired Rooms if not done with constructors
 */


    
    
    


/*
 * TODO: Checkpoint 4 Task
 * 
 * Change the values of row and column to match the starting locations of your world
 * 
 */
    row = 2;
    column = 1;
  
  
    
    
    //Informational: initializes the currentRoom to the starting location 
    currentRoom = map[row][column];


/*
 * TODO: Checkpoint 4 Task
 * 
 * initialize the player's inventory
 */
 


    	inventory = new ArrayList<InventoryItem>();
    
    
    
    

		/* Informational: Variables for the command, the command broken up, 
		*  the scanner, and boolean for game over
		*/ 
		String userInput = "";
		command = "";
		String item = "";
		Scanner s = new Scanner(System.in);
		done = false;
		quit = false;
		
		/* Informational:  
		 *  get the intro to the game and print
		 */
		String output = gameIntro();
		System.out.println(output);
		theTimer();
		/* Informational:  
		 * run the game until it is over
		 */
		while(!done){
			
			//Informational: get the user input
			System.out.print("\n\n>>");       //Informational: note this is for readability
			userInput = s.nextLine().toLowerCase();
			
			//Informational: get the command from the user input
			command = getFirstWord(userInput);
			
			//Informational: get the rest of the string after the first word if available
			
			item = getRestOfSentence(userInput);
			
			//Informational: use the command and item to determine the proper output
			
			output = executeCommand(command, item);

			//if(quit == true){
				//done = true;
				//command = "quit";
			//}
			
			
			//Informational: print the output for the user
			if(health > 0&&(!(command.equals("look")||command.equals("quit")))){
				//System.out.println(currentRoom.getName());
				
				System.out.println(output +"\n" + currentRoom.getName()+"\n"+currentRoom.getDescription());
			}else if(health <= 0){
				
				System.out.println("You lost all of your life.");
				done = true;
			}else{
				System.out.println(output);
			}

/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the win condition to match your winning Room or scenario
 * if the player is in the winning room, provide the Room Name and
 * the Room description
 * then end the game
 *
 * Optional --
 * add losing conditions
 */
			if(gameCounter == 0){
				System.out.println(currentRoom.getName());
				System.out.println(currentRoom.getDescription());
				System.out.println("You survived enough to get back to earth.");
				done = true;
			}
	     
				
		  	if(command.equals("quit"))
			  done = true;
		
		}
		
		s.close();
	
	}
	
/**
 * gameIntro method 
 * used to set the scene to the opening of your game 
 * @return: a String that is the opening description to your game, 
 *          be sure to note the help option 
 *          (i.e. "type help for a list of commands").  
 */

/*
 * TODO: Checkpoint 4 Task
 * 
 * Update this to the Intro for your game.  You should be able to copy it
 * from checkpoint 3
 */
	public static String gameIntro(){
		return "You are stuck on a Mar base and you are running out of food. The must be able to find keys \nand supplies that other astronauts left to gain more access. You need to get enough supplies\nto survive till the next food supply ship comes. You do not know when the rocket\nwill land but must maintain enough food to survive. You will find tools and keys in\nvarious room that may or may not help you in surviving until the rocket comes."
				+ "\n (Type \"help\" to see a list of commands)";
	}
	
/**
 * getFirstWord method
 * pulls the first word out of any phrase (1 or more words)
 * @param a string that contains the commands from the user
 * @return a string that is only the first word, 
 *         returns a blank string "" if nothing entered, 
 *         do not use print or println
 */
	public static String getFirstWord(String input){
		int spaceLocation = input.indexOf(" ");
		if(spaceLocation > 0)
			return input.substring(0,spaceLocation).toLowerCase();
		if(input.length() >0)
			return input;
		return "";
	}

/**
 * getRestOfSentence 
 * pulls everything after the first word and the space behind it
 * @param a string that contains the commands from the user
 * @return a string that returns everything after the first word 
 *         and the space behind it, returns a blank string "" if 1 word entry 
 *         or nothing entered. 
 *         Do not use print or println
 */	
	public static String getRestOfSentence(String input){
		int spaceLocation = input.indexOf(" ");
		if(spaceLocation >= 0)
			return input.substring(spaceLocation+1).toLowerCase();
		return "";
	}	

	
/**
 * north method
 * Method to state that you moved north, you will add movement functionality
 * in checkpoint 3
 * @return a string that states you moved North, do not use print or println	
 */

	public static String north(){
	  if(currentRoom.getCanGoNorth()){
	    row-=1;
	    updateRoom();
	    return "You moved North.";  
	  } else {
	    return "You cannot move North.";
	  }
		
	}



/**
 * south method
 * Method to state that you moved south, you will add movement functionality
 * in checkpoint 3
 * @return a string that states you moved South, do not use print or println
 */		

	public static String south(){
	  if(currentRoom.getCanGoSouth()){
	    row++;
	    updateRoom();
	    return "You moved South.";
	  } else {
	    return "You cannot move South.";  
	  }
		
	}

/**
 * east method
 * Method to state the you moved East,  you will add movement functionality in 
 * checkpoint 3
 * @return a string that states you moved East, do not use print or println
 */
	

	public static String east(){
	  if(currentRoom.getCanGoEast()){
	    column++;
	    updateRoom();
	    return "You moved East";
	  } else {
		  return "You cannot move East.";
	  }
	}

/**
 * west method
 * Method to state the you moved West, you will add movement functionality in 
 * checkpoint 3
 * @return a string that states you moved West, do not use print or println
 */
	
	public static String west(){
	  if(currentRoom.getCanGoWest()){
	    column--;
	    updateRoom();
	    return "You moved West";
	  } else {
	    return "You cannot move West.";   
	  }
	}

/**  
 * updateRoom method
 * Method to update the room you are in (currentRoom)
 * this method uses the row and column values to 
 * update the currentRoom location
 * no parameters or return values
 */

	public static void updateRoom(){
		currentRoom = map[row][column];
	}	
	
	
	
/**
 * take method
 * Method to allow you to take an item, for now you will just state that 
 * "You took the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You took the apple." 
 * 
 * You will actually pick up items in checkpoint 4
 * 
 * @param takes in a String to determine what object was picked up
 * @return a String that states "You took the <itemName>", do not use print or println
 */
	
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "take" method to pick up an object specified only if it is in the room. 
 * This should add the object to your inventory if it is in the room.
 * @param name of the object to pick up
 * @return a String stating the you either picked up or cannot pick up the object as 
 * appropriate
 */

	public static String take(String item){
		//System.out.println(map[row][column].hasObject(item));
		if(currentRoom.hasObject(item)){
			if(currentRoom.getObjectWeight(item) < 1000){
				inventory.add(currentRoom.removeObject(item));
				//System.out.println(inventory.get(0));
				return "You took the " + item +".";
			}else{
				return "You can't pick that up";
			}
		}else{
			return "That item is not in the room";
		}
	}
	public static String sleep(){
		//System.out.println(map[row][column].hasObject(item));
		if(map[row][column].hasObject("bed")){
			health += 5;
			return "You slept";
		}else{
			return "You cant sleep in here";
		}
	}
	
/** 
 * drop method
 * Method to allow you to drop an item, for now you will just state that 
 * "You dropped the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You dropped the apple."
 * 
 * You will actually drop items in checkpoint 4
 * @param takes in a string to determine what object was dropped
 * @return a string that states "You dropped the <itemName>", do not use print or println 
 */
	
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "drop" method to drop an object only if it is in the player inventory. 
 * The object should be added to the room inventory.
 * @param name of the object to drop
 * @return a String stating the you either dropped or cannot drop the object as 
 * appropriate
 */
 
	public static String drop(String objectName){
		int temp =-1;
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().equals(objectName)){
				temp = i;
			}
		}
		if(temp != -1){
			map[row][column].addObject(inventory.get(temp)); 
			inventory.remove(temp);
    		return "You dropped the " + objectName +".";
		}else{
			return "You cant drop that item";
		}
	}
	
/** 
 * look method
 * Method to allow you to look around the room
 * In checkpoint3, this will change to the room description
 *  @return a string that states "You looked around the room", do not use print or println
 */	
 
/* 
 * TODO: Checkpoint 4 task
 * 
 * add a new line with the names of the objects that can be picked up in the Room
 */
 
	public static String look(){
		if(getCurrentRoom().getNamesOfObjectsInRoom().equals("")){
			return currentRoom.toString() + "\nThere are not items in the room.";
		}
		return currentRoom.toString() + "\n" + getCurrentRoom().getNamesOfObjectsInRoom();
	}
	
/** 
 * inventory method
 * Method to display the items in your inventory, for now state
 * "The current items in your inventory are:"
 * 
 * In checkpoint 4 you will create a String that consists of all of the 
 * items in your inventory
 *  @return the "The current items in your inventory are:", do not use print or println
 */
 
/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "inventory" method to state the items and their description from your inventory. 
 * @return a String that is all of the items in your inventory with descriptions, ideally on new lines
 */
	public static String inventory(){
		//System.out.println("in inventory");
		String temp = "The current items in your inventory are:";
		for(int i = 0; i<inventory.size(); i++){
			//System.out.println(inventory.get(i));
			//System.out.println(inventory.get(i).getName());
			//System.out.println(inventory.get(i).getDescription());
			temp+= "\n" + inventory.get(i).getName() + ": " + inventory.get(i).getDescription();
		}
		if(temp.equals("The current items in your inventory are:")){
			return "There are no items in your inventory";
		}
		return temp;
	}	
	
/**
 * examine method
 * Method that returns the description on an item in your inventory, for now state:
 * "Description of <itemName>" where <itemName> is the itemName
 * 
 * example return statement:
 * "Description of apple"
 * 
 * In checkpoint 4 you will return the description of the object you are examining
 * @param takes in a string to determine what item you want the description of
 * @return a string that is the description of the item, do not use print or println
 */

/*
 * TODO: Checkpoint 4 Task
 * 
 * Update the "examine" method to check if the item is in the player's inventory
 * If it is in the inventory, return the description of the item
 * If it is not in the player's inventory (even if it is in the room), state that
 * the player does not have that item
 */
	public static String examine(String item){
		int temp =-1;
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().toLowerCase().equals(item)){
				temp = i;
			}
		}
		if(temp != -1){
			return inventory.get(temp).getDescription();
		}else{
			return "You cant examine this item";
		}
	}	

/**
 * eat method
 * Method that allows you to eat a Food object, for now state:
 * "You ate the <itemName>" where <itemName> is the name of the itemName
 * 
 * example return statement:
 * "You ate the apple."
 * 
 * In checkpoint 4, you will update this method to remove it from your inventory, 
 * but not drop it in the room.  Advanced: this could be useful for a health system
 * 
 * 
 * @param takes in a string to determine what item you want to eat
 * @return a string that states you ate the item, do not use print or println
 */	
 
/*
 * TODO: Checkpoint 4 Task
 * Update the Eat method to allow the player to eat an Item only if
 * the item is in the player's inventory and is a food.
 * 
 * If it is in the player's inventory and not a food, state that you cannot eat the item
 * 
 * If it is not in the player's inventory, state that you do not have the item
 * 
 * Optional: if you are including a health system, do so here
 */
	public static String eat(String item){
		int temp =-1;
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().toLowerCase().equals(item)){
				temp = i;
			}
		}
		if(temp != -1){
			if(inventory.get(temp) instanceof Food){
				
				health += ((Food)inventory.get(temp)).getHealthValue();
				inventory.remove(temp);
				return "You ate the " + item + ".";
			}else{
				return "You can not eat that item";
			}
		}else{
			return "You do not have that item";
		}
		
	}		
	

/**  
 * use method
 * Method that allows you to use an item it, for now state:
 * "You used the <itemName>", where <itemName> is the name of the item.
 * 
 * example return statement:
 * "You used the apple."
 * 
 * In checkpoint 4 this will be updated to only allow the player to use a Key
 * in the room where the key can open a door
 * 
 * @param takes in a string to determine what item you want to use
 * @return a string that You used the item, do not use print or println
 */

/* 
 * TODO: Checkpoint 4 Task
 * 
 * Update the "use" method to make a Key open the door of a specific Room
 * 
 * If the player is in the Room where the key works and has the key, the door should be opened.  
 * You will need to update all impacted Rooms
 * 
 * If the player has the key but is not in the correct Room, state that the key will not work here
 * 
 * If the item noted by the player cannot be used ever, then state that the player cannot use that item
 * 
 * If the player does not have the item, state that the player does not have the item.
 */
		public static String pick(String item){
			if(currentRoom.hasObject(item + " plant")){
				//System.out.println((gardenItem) (currentRoom.findPlantedPot(item)));
				gardenItem garden = (gardenItem) (currentRoom.findPlantedPot(item));
				if(garden != null){
					double tempHealth = garden.pickItem();
					health+=tempHealth;					
					return "You just picked and ate the " + item + ". You increased your health by " + tempHealth;
				}
			}
			return "You cant pick that";
		}
		public static String grow(String item){
			int temp =-1;
			for(int i = 0; i < inventory.size(); i++){
				
				if(inventory.get(i).getName().toLowerCase().equals(item)){
					temp = i;
				}
			}
			int temp2 =-1;
			for(int i = 0; i < inventory.size(); i++){
				
				if(inventory.get(i).getName().toLowerCase().equals("soil")){
					temp2 = i;
				}
			}
			if(temp != -1 && temp2 != -1){
				if(inventory.get(temp) instanceof Food){
					
					if(currentRoom.hasObject("garden pot")){
						//System.out.println((gardenItem) (currentRoom.findOpenPot()));
						gardenItem garden = (gardenItem) (currentRoom.findOpenPot());
						if(garden != null){
							garden.setItemGrowing(inventory.get(temp));
							garden.setGrowing(true);
							//System.out.println(temp);
							//System.out.println(temp2);
							//System.out.println(inventory.get(temp));
							//System.out.println(inventory.get(temp2));
							inventory.remove(temp);
							//error
							for(int i = 0; i < inventory.size(); i++){
								
								if(inventory.get(i).getName().toLowerCase().equals("soil")){
									inventory.remove(i);
								}
							}
							garden.setName(item + " plant");
							return "You are now growing a " + item;
						}
					}
					return "You cant use that item item";
				}else{
					return "You cant use that item item";
				}
			}else{
				return "You don't have all of the items";
			}
		}
		public static String use(String item){
			int temp =-1;
			for(int i = 0; i < inventory.size(); i++){
				
				if(inventory.get(i).getName().toLowerCase().equals(item)){
					temp = i;
				}
			}
			if(temp != -1){
				if(inventory.get(temp) instanceof Key){
					Key temp1 = (Key)inventory.get(temp);
					for(int i = 0; i < temp1.getRoomWorkIn().size(); i++){
						if(temp1.getRoomWorkIn().get(i).equals(getCurrentRoom().getName())){
							if(temp1.getRoomWorkIn().size() == 1){
								inventory.remove(temp);
							}
							if(temp1.getDirection().get(i).equals("North")){
								getCurrentRoom().setCanGoNorth(true);
							}else if(temp1.getDirection().get(i).equals("East")){
								getCurrentRoom().setCanGoEast(true);
							}else if(temp1.getDirection().get(i).equals("South")){
								getCurrentRoom().setCanGoSouth(true);
							}else if(temp1.getDirection().get(i).equals("West")){
								getCurrentRoom().setCanGoWest(true);
							}
							temp1.getRoomWorkIn().remove(i);
							temp1.getDirection().remove(i);
							return "You used the " + item + ".";
						}
					}
					return "You cant use that item";
				}else{
					return "You cant use that item";
				}
			}else{
				return "You dont have that item";
			}
			//return "ERROR";
		}	
	
		public static void theTimer() {
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(quit == false){
						if(health <= 0.0){
							quit();
							done = true;
							command = "quit";
							quit = true;
							//String INPUT_FILE_NAME = "zorkFinalQuit.in.txt";
							//try{
								//File inFile = new File(INPUT_FILE_NAME);
								//FileReader fr = new FileReader(inFile);
								//BufferedReader br = new BufferedReader(fr);
								//String inLine = null;;
								
								/*int t = Integer.parseInt(br.readLine());
								for(int i = 0; i < t; i++){
									inLine = br.readLine();
									System.out.println(inLine);
								}
								BufferedInputStream in = new BufferedInputStream(new FileInputStream("Commands.java"));
								
								*/
								//System.out.println("about to change");
								//System.setIn(new FileInputStream("zorkFinalQuit.in.txt"));
								//System.out.println("Changed");
							//}catch (Exception e){
							//	e.printStackTrace();
							//}
	
						}else{
							health-=2.5;
							gameCounter-=1.5;
						}
					}else{
						cancel();
					}
				}
			};
			timer.schedule(task, 0, 5000);
		}
		public static double getHealth(){
			return health;
		}
		public static String health(){
			return "Your health is " + health;
		}
/**
 * help method
 * Method that returns all of the commands and what they do
 * 
 * example return output:
 * "Command      Example      Description
 *  take         take apple   used to pick up objects"
 * 
 * @return a String that contains all the command names, an example of use, and a description of what they do.  Be sure to consider readability of the player.  Do not use print or println.
 */
	public static String help(){
		return "The following commands are used to play the game\n"
				+ "Command    Example      Description\n"
				+ "North      North        Allows you to move North\n"
				+ "South      south        Allows you to move South\n"
				+ "East       east         allows you to move East\n"
				+ "West       west         allows you to move West\n"
				+ "Look       Look         provides a detailed descriptoin of the room\n"
				+ "Take       take key     adds an item in a room to your inventory\n"
				+ "Drop       drop key     removes an item from your inventory and leaves it in the room\n"
				+ "Inventory  inventory    displays the names of items in your inventory\n"
				+ "Examine    examine key  provides a detailed description of the specified item, it must be in your inventory\n"
				+ "Eat        eat apple    Allows you to eat an edible item\n"
				+ "Use        use key      Allows you to use the item\n"
				+ "Health     health       Returns your current health\n"
				+ "Grow       grow apple   You start the process of growing an item. You must also have soil.\n"
				+ "Pick       pick apple   You will pick the item and eat it to increase your health.\n"
				+ "Help       help         displays the help menu\n"
				+ "Quit       quit         player initiated end of game\n";
	}

/**
 * quit Method
 * Method that states "You have decided to quit the game"
 * @return a message saying You have decided to quit the game, do not use print or println
 */
	public static String quit(){
		if(health <= 0){
			return "You ran out of life";
		}
		return "You have decided to quit the game.";
	}
	
/**
 * invalid method
 * Method called when a player tries a command that is not used in the game
 * @return message "I do not understand", do not use print or println
 */
		public static String invalid(){
			return "I do not understand.";
		}

		
/**
 * getCurrentRoom method
 * @return the currentRoom of the player
 */
		public static Room getCurrentRoom(){
			return currentRoom;
		}
		
		
		
/**
 * executeCommand method
 * This method uses the first word to call the appropriate method that you
 * made above.  Basically, this method manages complexity by hosting the 
 * logic to detemine which method should be used.
 * (for example, if the command is north, call the north() method). 
 * @param the String command used to check which method to call
 * @param the String item used for methods that interact with objects 
 * @return a String that is passed back from the appropriate method, 
 *         do not use print or println
 */
	public static String executeCommand(String command, String item){
		if(!(health <= 0.0)){
			if(command.equals("north"))
				return north();
			if(command.equals("south"))
				return south();
			if(command.equals("east"))
				return east();
			if(command.equals("west"))
				return west();
			if(command.equals("inventory"))
				return inventory();
			if(command.equals("look"))
				return look();
			if(command.equals("take"))
				return take(item);
			if(command.equals("drop"))
				return drop(item);
			if(command.equals("examine"))
				return examine(item);
			if(command.equals("eat"))
				return eat(item);
			if(command.equals("use"))
				return use(item);
			if(command.equals("sleep"))
				return sleep();
			if(command.equals("health"))
				return health();
			if(command.equals("help"))
				return help();
			if(command.equals("grow"))
				return grow(item);
			if(command.equals("quit"))
				return quit();
			if(command.equals("pick"))
				return pick(item);
			return invalid();
		}
		return "You lost all of your health";
	}
}

