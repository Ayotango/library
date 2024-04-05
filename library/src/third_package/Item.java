package third_package;

import second_package.Client;

public abstract class Item {
		//package-private since we want these attributes to be available only within the same package
		String name;
		String author;
		int yearOfPublication;
		public String itemID;
		private Client leasedByClient;

		
		//getters and setters 
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getAuthor() {
			return author;
		}
		
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public int getYearOfPublication() {
			return yearOfPublication;
		}
		
		public void setYearOfPublication(int yearOfPublication) {
			this.yearOfPublication = yearOfPublication;
		}
		
		public String getItemID() {
			return itemID;
		}
		
		public void setItemID(String itemID) {
			this.itemID = itemID;
		}
		
		public Client getClient() {
			return leasedByClient;
		}

		public void setLeasedByClient(Client client) {
			this.leasedByClient = client;
			
		}
		public Client getLeasedByClient() {
			return leasedByClient;
		}
		
		
		//methods
		public void changeName(String name) {
			//changes name
			this.name = name;
		}
		
		public void changeAuthor(String author) {
			//changes author
			this.author = author;
		}
		
		public void changeYearOfPublication(int yearOfPublication) {
			//changes year of publication 
			this.yearOfPublication = yearOfPublication;
		}
		
		 public void updateInformation(String newname, String newAuthor, int newPublication) {	
			 //updates information 
			 changeName(newname);
			 changeAuthor(newAuthor);
			 changeYearOfPublication(newPublication);
		 }
		 

	}


