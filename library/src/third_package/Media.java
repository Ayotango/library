package third_package;

import java.util.Objects;

public class Media extends Item {
	//we want these attributes to be private; only accessible within the same class 
		private String mediaType;
		private static int mediaCounter = 0; //this is a counter to update this item's IDs by one everytime this item is constructed
		
		//getters and setters
		public String getVolumeNumber() {
			return mediaType;
		}
		
		public void setVolumeNumber(String mediaType) {
			this.mediaType = mediaType;
		}
		
		public static int getMediaCounter() {
			return mediaCounter;
		}
		
		public static void setMediaCounter(int mediaCounter) {
			Media.mediaCounter = mediaCounter;
		}
		
		public String getMediaID() {
			return itemID;
		}
		
		public void setMediaID(String mediaID) {
			this.itemID = mediaID;
		}
		
		//constructors
		//constructor with parameters
		public Media(String name, String author, int yearOfPublication, String mediaType) {
			this.name = name;
			this.author = author;
			this.yearOfPublication = yearOfPublication;
			this.mediaType = mediaType;
			mediaCounter++;
			itemID = "M" + mediaCounter;
		}
		
		//default constructor
		public Media() {
			mediaCounter++;
			itemID = "M" + mediaCounter;
			}
		
		//copy constructor
		public Media(Media media) {
			this.name = media.name;
			this.author = media.author;
			this.yearOfPublication = media.yearOfPublication;
			this.mediaType = media.mediaType;
			mediaCounter++;
			itemID = "M" + mediaCounter;
			}
		
		//methods
		public String toString() { //overrides main method
			return "\nName of the media: " + this.name + "\nName of the author: " + this.author + "\nYear of publication: " + this.yearOfPublication + "\nMedia type: " + this.mediaType + "\n";
		}

		public boolean equals(Object obj) { //overrides main method
			if ((obj == null) || (getClass() != obj.getClass()))
				return false;
			Media media = (Media)obj;
			return Objects.equals(this.name, media.name) && 
					Objects.equals(this.author, media.author) &&
					this.yearOfPublication == media.yearOfPublication &&
					this.mediaType == media.mediaType;
		}
		
		public void changeMediaType(String mediaType) {
			//updates this attribute
			this.mediaType = mediaType;
		}
		
		 public void updateInformation(String itemID, String newname, String newAuthor, int newPublication, String newMediaType) {
			 //updates these attributes
			 changeName(newname);
			 changeAuthor(newAuthor);
			 changeYearOfPublication(newPublication);
			 changeMediaType(newMediaType);
		 }
		
		

	}

