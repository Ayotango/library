// ------------------------------------------------------- 
// Assignment 1
// Package 1 - Driver 
// Written by: Thomas-Tang-Allard (id) and Jana El Madhoun, 40272201
// -------------------------------------------------------


package first_package;

import second_package.Client;
import third_package.Book;
import third_package.Journal;
import third_package.Media;
import third_package.Item;

import java.util.Scanner;


	public class Driver {
		//this method returns null if the array is empty or return the book with the highest number of pages 
		private static Book getBiggestBook(Book[] books) {
				if (books.length == 0) {
					return null;
				}
			
			Book biggestBook = books[0];
			for (int i = 0; i < books.length; i++) {
				if (books[i].getNumberOfPages() > biggestBook.getNumberOfPages()) {
					biggestBook = books[i];
				}
			}
			return biggestBook;
			
		}
			//this method will make a deep copy of the array of books passed as parameter
			private static Book[] copyBooks(Book[] books) {
				Book[] copiedBooks = new Book[books.length];
				for (int i =0; i< books.length; i++) {
					copiedBooks[i] = new Book(books[i]);
				}
				return copiedBooks;
			}
			//this method will display the main menu 
			private static void menu() {
				Scanner key = new Scanner(System.in);		
				System.out.println("\nWhat would you like to choose?");
				System.out.println(		"1.   Add an item");
				System.out.println(		"2.   Delete an item");
				System.out.println(		"3.   Change the information of an item");
				System.out.println(		"4.   List all items in a specific category (book, journal, or media) ");
				System.out.println(		"5.   Print all items (from all categories)");
				System.out.println(		"6.   Add a client");
				System.out.println(		"7.   Edit a client");
				System.out.println(		"8.   Delete a client");
				System.out.println(		"9.   Lease an item to a client ");
				System.out.println(		"10.  Return an item from a client");
				System.out.println(		"11.  Show all items leased by a client");
				System.out.println();
				System.out.print("Please enter your choice > ");
			}
		
			
			
				//this method runs the predefined scenario 
				private static void runPredefinedScenario() {

					//creating the hypothetical items 
					Journal journal1 = new Journal("J1", "A1", 2000, 1);
					Journal journal2 = new Journal("J2", "A2", 2010, 1);
					Journal journal3 = new Journal("J3", "A3", 2020, 3);
					
					Book book1 = new Book("B1", "A1", 2020, 100);
					Book book2 = new Book("B1", "A1", 2020, 100);
					Book book3 = new Book("B3", "A3", 2005, 600);
					
					Media media1 = new Media("M1", "A1", 2000, "Audio");
					Media media2 = new Media("M2", "A2", 2015, "Interactive");
					Media media3 = new Media("M3", "A3", 2010, "Video");

					
					//displaying all item info
					System.out.println(journal1.toString());
					System.out.println(journal2.toString());
					System.out.println(journal3.toString());
					
					System.out.println(book1.toString());
					System.out.println(book2.toString());
					System.out.println(book3.toString());
					
					
					System.out.println(media1.toString());
					System.out.println(media2.toString());
					System.out.println(media3.toString());
					
					//two objects from the same class with similar values
					if (book1.equals(book2))
						System.out.println(book1.getBookID() + " and " + book2.getBookID() + " have the same values\n");
					else 
						System.out.println(book1.getBookID() + " and " + book2.getBookID() + " are not the same\n");
					
					//two objects from different class
					if (book1.equals(media1))
						System.out.println(book1.getBookID() + " and " + media1.getMediaID() + " have the same values\n");
					else 
						System.out.println(book1.getBookID() + " and " + media1.getMediaID() + " are not the same\n");
					
					//two objects from the same class with different values
					if (book1.equals(book3))
						System.out.println(book1.getBookID() + " and " + book3.getBookID() + " have the same values\n");
					else 
						System.out.println(book1.getBookID() + " and " + book3.getBookID() + " are not the same\n");
	
					
					//array for each type of items
					Journal[] journals = {journal1, journal2, journal3};
					Book[] books = {book1, book2, book3};
					Media[] medias = {media1, media2, media3};
					
					Item[] allItems = {journal1, journal2, journal3,book1, book2, book3, media1, media2, media3};
					
					//biggest book
					Book biggestBook = getBiggestBook(books);
					System.out.println("Biggest Book: " + biggestBook.getName());
					System.out.println();
					
					
					//copy media array
					Media[] MediaCopy = new Media[medias.length];
					    for (int i = 0; i < medias.length; i++) {
					        MediaCopy[i] = new Media(medias[i]); 
					    }

					    System.out.println("\nCopied Media: ");
					    for (int i =0; i < MediaCopy.length; i++) {
					        System.out.println(MediaCopy[i].toString());
					    }	
					
				}

				//main method 
				public static void main(String[] args) {
					
					 Scanner key = new Scanner(System.in);

				        System.out.println("What would you like to do?");
				        System.out.println("1. Run predefined scenario");
				        System.out.println("2. Go through the menu");
				        System.out.print("Enter your choice (1 or 2): ");

				        int choice = key.nextInt();
				        key.nextLine();  

				        if (choice == 1) {
				            runPredefinedScenario();
				        } else if (choice == 2) {
				            runMenu();
				        } else {
				            System.out.println("Invalid choice. Exiting program.");
				       }
				}
				
				//this method will run the menu, this is where program will execute the appropriate methods depending on the user's input 
				private static void runMenu() {
					Scanner key = new Scanner(System.in);

					//creating a library
			        Library library = new Library(); 

			        while (true) {
			        	
			        	menu();
						int input = key.nextInt();
				        key.nextLine();
					    
				  //using switch for each option the user decides to choose
			      switch (input) {
			        
			        case 1:  {
			        	
			        	//taking user input to be used in later switch
			            System.out.print("\nEnter item type (Book, Journal, or Media): ");
			            String type = key.nextLine();
			            
			            System.out.print("Enter item name: ");
			            String itemName = key.nextLine();

			            System.out.print("Enter item author: ");
			            String itemAuthor = key.nextLine();

			            System.out.print("Enter item publication year: ");
			            int pubYear = key.nextInt();
			            //consume the newline character
			           key.nextLine(); 
			           //switch method for which item type the user chooses
			            switch (type.toLowerCase()) {
			                case "book":
			                    System.out.print("Enter number of pages: ");
			                    int numberOfPages = key.nextInt();
			                    //creating an object with each argument the user typed earlier
			                    Book newB = new Book(itemName, itemAuthor, pubYear, numberOfPages);
			                    //adding that object to the main library where all the objects are stored
			                    library.addItem(newB);
			                    //success message and gives the user info about the item ID for the item they added
			                    System.out.println("Book added successfully. The ID of this book is: " + newB.itemID);
			                    break;
			                case "journal":
			                    System.out.print("Enter volume number: ");
			                    int volumeNumber = key.nextInt();
			                    Journal newJ = new Journal(itemName, itemAuthor, pubYear, volumeNumber);
			                    library.addItem(newJ);
			                    System.out.println("Journal added successfully. The ID of this journal is: " + newJ.itemID);
			                    break;
			                case "media":
			                    System.out.print("Enter media type: ");
			                    String mediaType = key.nextLine();
			                    Media newM = new Media(itemName, itemAuthor, pubYear, mediaType);
			                    library.addItem(newM);
			                    System.out.println("Media added successfully. The ID of the media is: " + newM.itemID);
			                    break;
			                default:
			                    System.out.println("Invalid item type. Please enter Book, Journal, or Media.");
			                    break;
			            } break;
			        }
	                case 2:{
	                	System.out.print("Enter the ID of the item you want to delete: ");
	                    String delete = key.next(); 

	                    //calls the deleteItem method from the library to remove an item from the array in the library
	                    library.deleteItem(delete);
	                    break;

	                }case 3: 
	                	System.out.print("\nEnter the ID of the item you want to update: ");
	                    String update = key.next(); 

	                    //check if the item exists in the library
	                    int itemIndex = library.findItemIndexByItemID(update);
	                    
	                    if (itemIndex != -1) {
	                    	//stores the item in "change" depending on the ID the user input
	                    	 Item change = library.getItembyIndex(itemIndex);

	                    	//prompt user for updated information based on the type of item
	                        if (change instanceof Book) {
	                            System.out.print("Enter the new name: ");
	                            String newName = key.next();

	                            System.out.print("Enter the new author: ");
	                            String newAuthor = key.next();

	                            System.out.print("Enter the new publication year: ");
	                            int newPublication = key.nextInt();

	                            System.out.print("Enter the new number of pages: ");
	                            int newNumberOfPages = key.nextInt();
	                            //uses this method to update the global attributes that all items have
	                            library.updateInformation(update, newName, newAuthor, newPublication);
	                            //uses this method to update the item-specific attribute
	                            library.updateBookInformation(update, newNumberOfPages);
	                        } else if (change instanceof Journal) {
	                        	 	System.out.print("Enter the new name: ");
		                            String newName = key.next();

		                            System.out.print("Enter the new author: ");
		                            String newAuthor = key.next();

		                            System.out.print("Enter the new publication year: ");
		                            int newPublication = key.nextInt();

		                            System.out.print("Enter the new volume number: ");
		                            int newVolnum = key.nextInt();
		                            library.updateInformation(update, newName, newAuthor, newPublication);
		                            library.updateJournalInformation(update, newVolnum);

	                        } else if (change instanceof Media) {
		                        	System.out.print("Enter the new name: ");
		                            String newName = key.next();
	
		                            System.out.print("Enter the new author: ");
		                            String newAuthor = key.next();
	
		                            System.out.print("Enter the new publication year: ");
		                            int newPublication = key.nextInt();
	
		                            System.out.print("Enter the new type: ");
		                            String newType = key.next();
		                            library.updateInformation(update, newName, newAuthor, newPublication);
		                            library.updateMediaInformation(update, newType);

		                        }
	                    	} else {
	                        System.out.println("Item not found in the library.");
	                    }
	                    break; 
	               
	                case 4:{
	                	System.out.println("Choose a category (type the number):");
	                    System.out.println("1. Books");
	                    System.out.println("2. Journals");
	                    System.out.println("3. Media");
	                    int option = key.nextInt();

	                    switch (option) {
	                        case 1:
	                        	//call this method to list all items of a specific type 
	                            library.listBook();
	                            break;
	                        case 2:
	                            library.listJournal();
	                            break;
	                        case 3:
	                            library.listMedia();
	                            break;
	                        default:
	                            System.out.println("Invalid category choice.");
	                            break;
	                    }
	                    break;
	                }case 5:
	                	//calls method that lists all items no matter the type
	                    library.listAll();
	                    break;
	                case 6:{
	                	//takes user input
	                	System.out.println("Enter client name:");
	                    String clientName = key.next();
	                    System.out.println("Enter client phone number:");
	                    String clientPhoneNumber = key.next();
	                    System.out.println("Enter client email:");
	                    String clientEmail = key.next();
	                    //creates object with the stored user inputs from earlier
	                    Client newClient = new Client(clientName, clientPhoneNumber, clientEmail);
	                    //adds the object to the array in the library
	                    library.addClient(newClient);
	                    System.out.println("Client added successfully. The client's ID is: " + newClient.clientID);
	                    break;
	                }  case 7: {
	                    //editing a client
	                	System.out.println("Enter the client ID to edit: ");
	                	String i = key.next();
	                	
	                	//finding the index of that specific client depending on the client ID provided by the user
	                	int index = library.findClientIndexByClientID(i);

	                    if (index != -1) {
	                        System.out.println("Enter new name:");
	                        String newName = key.next();
	                        System.out.println("Enter new phone number:");
	                        String newPhoneNumber = key.next();
	                        System.out.println("Enter new email:");
	                        String newEmail = key.next();
	                        //calls this method to edit an existing user
	                        library.editClient(i, newName, newPhoneNumber, newEmail);
	                    } else {
	                        System.out.println("Client not found.");
	                    }
	                    break;
	               
	                }  case 8: {
	                	System.out.println("Enter the client ID to edit: ");
	                	String todelete = key.next();	
	                	//calls this method to delete a client from the main client array in the library
	                	library.deleteClient(todelete);
	                	break;
	 
	                }  case 9: {
	                	System.out.println("Enter the client ID: ");
	                    String clientID = key.next();
	                    System.out.println("Enter the item ID: ");
	                    String itemID = key.next();
	                    //calls this method to lease an item to a specific client 
	                    library.leaseItem(clientID, itemID);
	                    break;
	                }  case 10:{
	                	
	                	System.out.println("Enter the item ID to return: ");
	                	String ID = key.next();
	                	//calls this method to return an item that a client used to have to their name
	                	library.returnItem(ID);
	                	break;
	                } case 11: {
	                	System.out.println("Enter the client ID: ");
	                	String inp = key.next();
	                	//calls this method that shows the leased item of the client
	                	library.showLeasedItems(inp);
	                	break;
	                } case 0: {
	                	//exits the program
	                	System.out.println("Exiting system.");
	                	 System.exit(0);
	                	 break;
	                } default: {
	                	//executes if the user's input is invalid
	                	System.out.println("Invalid choice. Please try again. ");
	                	break;
	                		}
			            }
			        }
				}
	
			
		
	}			
			        
		

