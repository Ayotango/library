// ------------------------------------------------------- 
// Assignment 1
// Package 2 
// Written by: Thomas-Tang-Allard (id) and Jana El Madhoun, 40272201
// -------------------------------------------------------



package second_package;

import first_package.Library;
import third_package.Book;
import third_package.Item;


public class Client extends Person implements Employee{

	public String clientID;
	private Item[] leasedItems;
	private int count; // counter for leased items
	private static final int max_leased = 15; // max number for leased books
	private Library library;
	private static int ClientCounter = 0;
	
	
	//getters and setters
	public static int getClientCounter() {
		return ClientCounter;
	}
	
	public static void setClientCounter(int ClientCounter) {
		Client.ClientCounter = ClientCounter;
	}
	
	public String getClientID() {
		return clientID;
	}
	
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
	
	//constructors
	//default constructor
	public Client() {
		
	}
	
	//copy constructor 
	public Client(Client copy) {
		 super(copy.getName(), copy.getNumber(), copy.getEmail());
		  this.count = copy.count;
		  this.clientID = copy.clientID; 
		   ClientCounter++;
		  
}
	
	//constructor with parameters
	public Client(String name, String phoneNumber, String emailAddress) {
		super(name, phoneNumber, emailAddress);
		count = 0;
		leasedItems = new Item[max_leased];
		ClientCounter++;
		clientID = "C" + ClientCounter;
		
	}

	//methods	
	public String toString() { //toString method gets overridden
		return ("\nName: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress + "\nClient ID: " + clientID );
	}
	public void changeClientID(String clientID) {
		this.clientID = clientID;
	}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public void changePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void changeEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	 public void updateClientInfo(String newname, String newNumber,String newEmail) {
		 changeName(newname);
		 changePhoneNumber(newNumber);
		 changeEmailAddress(newEmail);
		
	 }
	 
	 	public void leaseItem(String clientID, String itemID) {
	        library.leaseItem(clientID, itemID); 
	    }

	    public void returnItem(String itemID) {
	        library.returnItem(itemID);  
	    }
	    public void showLeasedItems(String clientID) {
	        library.showLeasedItems(clientID);  
	    }

	    public void showAllItems() {
	        library.showAllItems();  
	    }
	 


}


