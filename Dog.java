//If someone uses our Dog class they can only access the owner and breed information
//The only field they will be able to change is setting a new owner

public class Dog {

	private String owner;
	private int age;
	private String breed;
	
	public Dog(String owner, int age, String breed){
		this.owner = owner;
		this.age = age;
		this.breed = breed;
	}
	
	public String getOwner(){
		return owner;
	}

	public String getBreed(){
		return breed;
	}
	
	public void setOwner(String newOwner){
		owner = newOwner;
	}
}
