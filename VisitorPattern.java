
public class VisitorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Intilaisation information
		Person isha = new Person();
		isha.name = "Isha Vishwakarma";
		Address ishasAddress = new Address();
		ishasAddress.name = "Ashok Vihar, Rampur" ; 
		isha.setAddress(ishasAddress);
		
		//Isha's friend
		Friend monisha = new Friend();
		monisha.name = "monisha";
		//Isha's friend : monisha's friend
		FriendOfFriend sneha = new FriendOfFriend();
		sneha.name = "sneha";
		//what information they have about isha
		isha.allow(monisha);
		isha.allow(sneha);
		
		
	    
		
	}

}
//Contract for Vistor -1
interface friendVisitor
{
	 public void hasKnowlegeAbout(Person p);
	 public void hasKnowlegeAbout(Address a);
}
//Contract for Visitor-2
interface friendOfFriendVisitor
{
	 public void hasKnowlegeAbout(Person p);
	
}
//Actual Visitor -1
 class Friend implements friendVisitor
{
	 public String name ;

	@Override
	public void hasKnowlegeAbout(Person p) {
		// TODO Auto-generated method stub
		System.out.println(name + " knows name : " + p.name);
	}

	@Override
	public void hasKnowlegeAbout(Address a) {
		// TODO Auto-generated method stub
		System.out.println(name+ " know's adress also : " + a.name);
	}
	
}
 class FriendOfFriend implements friendOfFriendVisitor
 {
	 String name ;
	 public void hasKnowlegeAbout(Person p) {
			// TODO Auto-generated method stub
		 System.out.println(name + " knows name : " + p.name);
		}
 }
 //Details allowed to Vistor -1 
 interface allowFriend
 {
	public void allow(Friend friend);
 }
 //Details allowed to Visitor - 2
 interface allowFriendOfFriend
 {
	
	 public void allow(FriendOfFriend frienfoffriend);
 }
 class Person implements allowFriend,allowFriendOfFriend
 {
	 public String name; 
	 public String phoneNumber;
	 private Address address;
	 public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
	@Override
	public void allow(FriendOfFriend frienfoffriend) {
		// TODO Auto-generated method stub
		 frienfoffriend.hasKnowlegeAbout(this);
	}
	
	public void allow(Friend friend) {
		// TODO Auto-generated method stub
		 friend.hasKnowlegeAbout(address);
		 friend.hasKnowlegeAbout(this);
		 
	}
	 
	 
 }
 class Address 
 {
	 //by address name we mean name of the city here
	 public String name ; 
	 public String fullAddress ;
	
	
 }
 