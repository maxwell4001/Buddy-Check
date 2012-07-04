package maxwell.buddycheck.activity;

import maxwell.buddycheck.BuddyCheckEvent;
import maxwell.buddycheck.EventDataProvider;
import maxwell.buddycheck.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class BuddyCheckActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        ListView lv =  (ListView)findViewById(R.id.listView1);
        ListAdapter la=new ArrayAdapter<BuddyCheckEvent>(this, R.layout.listitemview, EventDataProvider.getEventlist());
        lv.setAdapter(la);
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				System.out.println("How nice... arg0 = " + arg0 + " arg1 = " + arg1 + "  arg2 = " + arg2 + " arg3 = " + arg3);
				BuddyCheckEvent itemAtPosition = (BuddyCheckEvent)((ListView)arg0).getItemAtPosition(arg2);
				
			}
			
		});
        
    }
    
    
    public void newEventClick(View v)
    {
    	Intent intent=new Intent(BuddyCheckActivity.this, BuddyCheckCreateEventActivity.class );
    	startActivity(intent);
    }
    
}