// ------------------------------------------------------- 
// Assignment 1
// Package 3 
// Written by: Thomas-Tang-Allard (id) and Jana El Madhoun, 40272201
// -------------------------------------------------------



package first_package;

import second_package.Client;
import second_package.Employee;
import third_package.Book;
import third_package.Item;
import third_package.Journal;
import third_package.Media;

public class Library {
	public static Item[] item;
	private Client[] client;
	private Employee[] employees;
	public static int itemIndex = 0;
	private int clientIndex;
	private Item[] leasedItems;
	private int count; //for leased items
	
	
	//these attributes are final because we don't want the maximum values to change
	private static final int MAX_ITEMS = 50;
	private static final int MAX_CLIENTS = 50;
	private static final int MAX_LEASED = 15;
	

	
	
	//constructor
	public Library() {
		item = new Item[MAX_ITEMS];
		client = new Client[MAX_CLIENTS];
		leasedItems = new Item[MAX_LEASED];
		itemIndex = 0;
		clientIndex = 0;
	}
	
	 
	
	
	//methods
	public void addItem(Item obj) { 
		if (itemIndex < MAX_ITEMS) {
			item[itemIndex] = obj;
			itemIndex++;
		} 
		else
			System.out.println("The library is full!");
	}
	
	
	public void deleteItem(String itemID) {
		int index = findItemIndexByItemID(itemID);
        if (index != -1) {
            //this will shift the items to the left to fill in the gap 
            for (int i = index; i < itemIndex - 1; i++) {
                item[i] = item[i + 1];
            }
            item[itemIndex - 1] = null; //makes the last item in the array null
            itemIndex--;
            System.out.println("Item " + itemID + " deleted successfully.");
        } 
        else {
            System.out.println("Item not found in the library.");
        }	
        
	}
	
	public int findItemIndexByItemID(String itemID) {
		//this will look at each item in the array until the item ID entered as an argument matches with the item ID of the item in the array 
		for (int i = 0; i < itemIndex; i++) {
			if (item[i].itemID.equals(itemID)) {
				//will return the item's index
				return i;
			}
		}
		return -1;
	}
	
	public Item getItembyIndex(int index) {
		//this method will take an item's index and return the the item itself 
        if (index >= 0 && index < itemIndex) {
            return item[index];
        } else {
            return null; 
        }
        
	}
	public void updateInformation(String itemID, String newname, String newauthor, int newPublication) {
		//this method will update the global attributes that are common to all items
		int index = findItemIndexByItemID(itemID);
		if (index != -1) {
			Item updated = item[index];
			updated.updateInformation(newname, newauthor, newPublication);
		}else {
			System.out.println("Item " + itemID + "was not found.");
		}		
	}
	
	public void updateBookInformation(String itemID, int newNumberOfPages) {
		//this method will update the item specific attribute
		int index = findItemIndexByItemID(itemID);
		if (index != -1) {
			Book updated = (Book) item[index];
			updated.changeNumberOfPages(newNumberOfPages);
			System.out.println("Item " + itemID + " updated successfully.");
		}else {
			System.out.println("Item " + itemID + " was not found.");
		}
	
	}
	
	public void updateJournalInformation(String itemID, int volumeNumber) {
		//this method will update the item specific attribute
		int index = findItemIndexByItemID(itemID);
		if (index != -1) {
			Journal updated = (Journal) item[index];
			updated.changeVolumeNumber(volumeNumber);
			System.out.println("Item " + itemID + " updated successfully.");
		}else {
			System.out.println("Item " + itemID + " was not found.");
		}
	
	}
	
	public void updateMediaInformation(String itemID, String mediaType) {
		//this method will update the item specific attribute
		int index = findItemIndexByItemID(itemID);
		if (index != -1) {
			Media updated = (Media) item[index];
			updated.changeMediaType(mediaType);
			System.out.println("Item " + itemID + " updated successfully.");
		}else {
			System.out.println("Item " + itemID + " was not found.");
		}
	
	}
	
	
	
	public void listBook() {
		//this method will list all books in the library
		System.out.println("List of all books:");
		
		boolean found = false;
		for (int i = 0; i < itemIndex; i++) {
			if (item[i] instanceof Book) {
				System.out.println(item[i].toString());
				found = true;
				
			} 
		} if (!found) {
				System.out.println("\nThere are no books!");
				
		}
		System.out.println();
	}
	
	public void listJournal() {
		//this method will list all journals in the library
		System.out.println("List of all journals: ");
		boolean found = false;
		for (int i = 0; i < itemIndex; i++) {
			if (item[i] instanceof Journal) {
				System.out.println(item[i].toString());
				found = true;
			}
		} if (!found) {
				System.out.println("\nThere are no journals!");
		} System.out.println();
	}
	
	
	
	public void listMedia() {
		//this method will list all media in the library
		System.out.println("List of all media:\n");
		
		boolean found = false;
		for (int i = 0; i < itemIndex; i++) {
			if (item[i] instanceof Media) {
				System.out.println(item[i].toString());
				found = true;
			}
		} 	if (!found) {
			System.out.println("\nThere is no media!");
		}
		System.out.println();		
}
	
	
	public void listAll() {
		//this method will list all items in the library
		System.out.println("List of all items: ");
		for (int i = 0; i < itemIndex; i++) {
			System.out.println(item[i].toString());
		} 
	}
	
	public void addClient(Client obj) {
		//this method will add a client object to the client array in the library 
		if (clientIndex < MAX_CLIENTS) {
			client[clientIndex] = obj;
			clientIndex++;
		} 
		else
			System.out.println("The client list is full!");
	}

	
	public void deleteClient(String clientID) {
		//this method will delete a client object to the client array in the library 
		int index = findClientIndexByClientID(clientID);
        if (index != -1) {
            //this will shift the items to the left to fill in the gap 
            for (int i = index; i < clientIndex - 1; i++) {
                client[i] = client[i + 1];
            }
            client[clientIndex - 1] = null; //makes the last item in the array null
            clientIndex--;
            System.out.println("Client " + clientID + " deleted successfully.");
        } 
        else {
            System.out.println("Client not found in the library.");
        }	
        
	}
	
	public int findClientIndexByClientID(String clientID) {
		//this method will take a client's ID and return the index of that client ID
		for (int i = 0; i < clientIndex; i++) {
			if (client[i].getClientID().equals(clientID)) {
				return i;
			}
		}
		return -1;
	}
	
	public void editClient(String clientID, String newName, String newNumber, String newEmail) {
		//this method will edit the existing client's attrbutes 
		int index = findClientIndexByClientID(clientID);
		if (index != -1) {
			client[index].updateClientInfo(newName, newNumber, newEmail);
			System.out.println("\nInformation updated successfully.");
			System.out.println("\nNew information: " + client[index].toString());
		}else {
			System.out.println("Client ID not found.");
		}	
	}
	
	public int findLeasedItem(Item item) {
		//this methos will find the index of the leased item 
		for (int i = 0; i < count; i++) {
			if (leasedItems[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}
	 public void leaseItem(String clientID, String itemID) {
		 //this method will associate an item to a client 
		 int index = findItemIndexByItemID(itemID);
		 int index2 = findClientIndexByClientID(clientID);
		 
		 if (index != -1 && index2 != -1 && count < MAX_LEASED) {
			 Item i = item[index];
		     Client c = client[index2];
		     
			 leasedItems[count] = i;
			 i.setLeasedByClient(c); // sets client who leased the item
			 count++;
			 System.out.println("Item leased successfully by " + c.getName()+ ".");
		 } else {
			 System.out.println("Client cant lease more items.");
		 }
	 }
	
	 public void returnItem(String itemID) {
		 //this method will remove an item that was associated to a client 
		 int index = findItemIndexByItemID(itemID);
		 if (index != 1) {
			 for (int i = index; i < (count -1); i++) {
				 leasedItems[i] = leasedItems[i+1];
		 } 
			 leasedItems[count-1]= null;
			 count --;
			 System.out.println("Item returned successfully by " + client[index].getName());
		 } else {
         System.out.println("Item not leased.");
     }	 
}
	 
	 public void showLeasedItems(String clientID) {
		 //this method simply lists all the leased items of a client 
		 int index = findClientIndexByClientID(clientID);
		 
		 for (int i =0; i <count; i++) {
			 if (leasedItems[i] != null && leasedItems[i].getClient().equals(client[index])) {
				 System.out.println("Items leased by " + client[index].getName() + ": ");
				 System.out.println(leasedItems[i].toString());
		 } 	else {
			 System.out.println("No items leased by " + client[index].getName() + ". ");
		 }
	 } 
}

	 public void showAllItems() {
		 //this method shows all the leased items in the whole library
		 System.out.println("All leased items: ");
		 for (int i = 0; i < count; i++) {
			 System.out.println(leasedItems[i].toString());
		 }
	 }

		
	 
	 
}