package maxwell.buddycheck.activity;

public class BuddyCheckContact {
	private String phoneNumber;
	private String name;
	
	public BuddyCheckContact (String name, String number)
	{
		this.name=name;
		this.phoneNumber = number;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
