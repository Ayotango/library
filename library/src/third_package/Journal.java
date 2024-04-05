package third_package;

import java.util.Objects;

public class Journal extends Item {
		//we want these attributes to be private; only accessible within the same class 
		private int volumeNumber;
		private static int journalCounter = 0; //this is a counter to update this item's IDs by one everytime this item is constructed
		
		//getters and setters
		public int getVolumeNumber() {
			return volumeNumber;
		}
		
		public void setVolumeNumber(int volumeNumber) {
			this.volumeNumber = volumeNumber;
		}
		
		public static int getJournalCounter() {
			return journalCounter;
		}
		
		public static void setJournalCounter(int journalCounter) {
			Journal.journalCounter = journalCounter;
		}
		
		public String getJournalID() {
			return itemID;
		}
		
		public void setJournalID(String journalID) {
			this.itemID = journalID;
		}
		
		//constructors
		//constructor with parameters 
		public Journal(String name, String author, int yearOfPublication, int volumeNumber) {
			this.name = name;
			this.author = author;
			this.yearOfPublication = yearOfPublication;
			this.volumeNumber = volumeNumber;
			journalCounter++;
			itemID = "J" + journalCounter;
		}
		
		//default constructor
		public Journal() {
			journalCounter++;
			itemID = "J" + journalCounter;
			}
		
		//copy constructor
		public Journal(Journal journal) {
			this.name = journal.name;
			this.author = journal.author;
			this.yearOfPublication = journal.yearOfPublication;
			this.volumeNumber = journal.volumeNumber;
			journalCounter++;
			itemID = "J" + journalCounter;
			}

		//methods
		@Override
		public String toString() { //overrides main method
			return "\nName of the journal: " + this.name + "\nName of the author: " + this.author + "\nYear of publication: " + this.yearOfPublication + "\nVolume number: " + this.volumeNumber + "\n";
		}

		public boolean equals(Object obj) { //overrides main method
			if ((obj == null) || (getClass() != obj.getClass()))
				return false;
			Journal journal = (Journal)obj;
			return Objects.equals(this.name, journal.name) && 
					Objects.equals(this.author, journal.author) &&
					this.yearOfPublication == journal.yearOfPublication &&
					this.volumeNumber == journal.volumeNumber;
		}
		
		public void changeVolumeNumber(int volumeNumber) {
			//updates the attribute
			this.volumeNumber = volumeNumber;
		}
		
		 public void updateInformation(String itemID, String newname, String newAuthor, int newPublication, int newVolNumber) {
			 //updates these attributes
			 changeName(newname);
			 changeAuthor(newAuthor);
			 changeYearOfPublication(newPublication);
			 changeVolumeNumber(newVolNumber);
		 }
		
		
	}


