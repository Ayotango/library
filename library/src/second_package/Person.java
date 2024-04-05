package second_package;


public class Person {
	
	//we want these attributes to be protected; only accessible within the same package 
	protected String name;
	protected String phoneNumber;
	protected String emailAddress;
	
	public Person() {}
	
	//getters and setters
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return emailAddress;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	//constructors
	//constructor with parameters
	public Person(String name, String phoneNumber, String emailAddress) {
		this.name = name; 
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	//copy constructor 
	public Person(Person copy) {
		this.name = copy.name; 
		this.phoneNumber = copy.phoneNumber;
		this.emailAddress = copy.emailAddress;
	}
	

	//methods
	public String toString() { //overriddes toString method
		return ("Name: " + name + " Phone Number: " + phoneNumber + " Email Address: " + emailAddress );
	}
	
	
	
	
}
	
	