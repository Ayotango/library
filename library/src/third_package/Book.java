package third_package;

import java.util.Objects;


public class Book extends Item {
		//we want this attribute to be private; only accessible within the same class 
		private int numberOfPages;
		private static int bookCounter = 0; //this is a counter to update this item's IDs by one everytime this item is constructed
		
		
		//getters and setters
		public int getNumberOfPages() {
			return numberOfPages;
		}
		
		
		public void setNumberOfPages(int numberOfPages) {
			this.numberOfPages = numberOfPages;
		}
		
		public static int getBookCounter() {
			return bookCounter;
		}
		
		public static void setBookCounter(int bookCounter) {
			Book.bookCounter = bookCounter;
		}
		
		public String getBookID() {
			return itemID;
		}
		
		public void setBookID(String bookID) {
			this.itemID = bookID;
		}
		
		//constructors
		//constructor with parameters
		public Book(String name, String author, int yearOfPublication, int numberOfPages) {
			this.name = name;
			this.author = author;
			this.yearOfPublication = yearOfPublication;
			this.numberOfPages = numberOfPages;
			bookCounter++;
			itemID = "B" + bookCounter;
		}
		
		//default constructor
		public Book() {
			bookCounter++;
			itemID = "B" + bookCounter;
		}
		
		//copy constructor
		public Book(Book book) {
			this.name = book.name;
			this.author = book.author;
			this.yearOfPublication = book.yearOfPublication;
			this.numberOfPages = book.numberOfPages;
			bookCounter++;
			itemID = "B" + bookCounter;
		}
		
		//methods
		public String toString() { //overrides main method
			return "\nName of the book: " + this.name + "\nName of the author: " + this.author + "\nYear of publication: " + this.yearOfPublication + "\nNumber of pages: " + this.numberOfPages + "\n";
		}

		public boolean equals(Object obj) { //overrides main method
			if ((obj == null) || (getClass() != obj.getClass()))
				return false;
			Book book = (Book)obj;
			return Objects.equals(this.name, book.name) && 
					Objects.equals(this.author, book.author) &&
					this.yearOfPublication == book.yearOfPublication &&
					this.numberOfPages == book.numberOfPages;
		}

		public void changeNumberOfPages(int numberOfPages) {
			//updates the "number of pages" attribute
			this.numberOfPages = numberOfPages;
		}
		
		 public void updateInformation(String itemID, String newname, String newAuthor, int newPublication, int newnumberOfPages) {
			 //updates this information 
			 changeName(newname);
			 changeAuthor(newAuthor);
			 changeYearOfPublication(newPublication);
			 changeNumberOfPages(newnumberOfPages);
		 }
		 
		 
		
		
		
}
