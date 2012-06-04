package maxwell.buddycheck;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BuddyCheckEvent {

	private Calendar originalAlarmDate;
	private Calendar nextAlarmDate;
	private String phoneNumber;
	private String buddyMessage;
	
	public BuddyCheckEvent(Calendar originalDate, Calendar nextAlarmDate, String phoneNumber, String message)
	{
		this.originalAlarmDate = originalDate;
		this.nextAlarmDate = nextAlarmDate;
		this.phoneNumber = phoneNumber;
		this.buddyMessage = message;
	}
	
	@Override
	public String toString()
	{
		SimpleDateFormat dateformatter = new SimpleDateFormat
				   ("MM/dd/yyyy 'at' hh:mm:ss");
		return "TO: " + phoneNumber + "\n" + dateformatter.format(nextAlarmDate.getTime()) + "\n" + buddyMessage;
	}
	
	
	public Calendar  getOriginalAlarmDate() {
		return originalAlarmDate;
	}
	public void setOriginalAlarmDate(Calendar originalAlarmDate) {
		this.originalAlarmDate = originalAlarmDate;
	}
	public Calendar getNextAlarmDate() {
		return nextAlarmDate;
	}
	public void setNextAlarmDate(Calendar nextAlaramDate) {
		this.nextAlarmDate = nextAlaramDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBuddyMessage() {
		return buddyMessage;
	}
	public void setBuddyMessage(String buddyMessage) {
		this.buddyMessage = buddyMessage;
	}
	
	
	
}
