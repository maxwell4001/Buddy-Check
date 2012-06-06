package maxwell.buddycheck;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventDataProvider {
	
	
	static public BuddyCheckEvent[] getEventlist() {
		Calendar now=Calendar.getInstance();
    	Calendar later=Calendar.getInstance();
    	later.add(Calendar.HOUR, 6);
    	later.add(Calendar.MINUTE, 15);
    	Calendar tenDays = Calendar.getInstance();
    	tenDays.add(Calendar.DATE, 10);
    	ArrayList<BuddyCheckEvent> list=new ArrayList<BuddyCheckEvent>();
    	
    	list.add(new BuddyCheckEvent(now, now, "512-583-1100", "Please call 911 and help me."));
    	list.add(new BuddyCheckEvent(later, later, "512-583-1102", "I should be studying.  Send me home! (6 hours, 15 minutes later"));
    	//list.add(new BuddyCheckEvent(tenDays, tenDays, "512-583-1103", "15 days in the future.  Send me home!"));
    	//list.add(new BuddyCheckEvent(tenDays, tenDays, "512-583-1104", "15 days in the future.  Send me home!"));
    	return list.toArray(new BuddyCheckEvent[0]);
    	
	}

}
