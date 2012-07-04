package maxwell.buddycheck.activity;

import maxwell.buddycheck.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BuddyCheckCreateEventActivity extends Activity {

	public static final int PICK_CONTACT = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.newbuddycheckevent);

	}
	
	private String getPhoneNumber(Cursor c) {
		String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
		String phoneNumber = "";

		int hasPhone = c.getInt(c.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER));

		if (hasPhone == 1) {
			
			// grab just the mobile phone numbers.
			// select all phone numbers that belong to this contact_id... with type = TYPE_MOBILE.
			
			Cursor phones = getContentResolver().query(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
					null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "
							+ contactId + " and " +  ContactsContract.CommonDataKinds.Phone.TYPE + " = "  + ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE, null, null);
			while (phones.moveToNext()) {
				System.out.println("phones = " + phones);
				
				Log.i("MWB", ContactsContract.CommonDataKinds.Phone.TYPE);
				Log.i("MWB", ""+phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
				Log.i("MWB", phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE)));
				
				phoneNumber = phones
						.getString(phones
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				break;
			}
			phones.close();
		}

		return phoneNumber;
	}
	
	private String getName(Cursor c) {
		String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
		return name;
	}
	

	public void onPickContactClick(View v) {
		Intent intent = new Intent(Intent.ACTION_PICK, 
				android.provider.ContactsContract.Contacts.CONTENT_URI);
		
		startActivityForResult(intent, PICK_CONTACT);
	}

	private BuddyCheckContact getBuddyContact(Uri contactData) {
		
		Cursor c = managedQuery(contactData, null, null, null, null);
		String phoneNumber="";
		if (c.moveToFirst()) {

			phoneNumber = getPhoneNumber(c);
		}

	
		BuddyCheckContact contact=new BuddyCheckContact(getName(c), phoneNumber);
		
		return contact;
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode != Activity.RESULT_OK) {
			return;
		}

		switch (requestCode) {
		case (PICK_CONTACT):
			BuddyCheckContact buddy= getBuddyContact(data.getData());

			TextView nameBox = (TextView) findViewById(R.id.contactNameTextBox);
			TextView phoneBox = (TextView) findViewById(R.id.contactPhoneNumberTextBox);
			phoneBox.setText(buddy.getPhoneNumber());
			nameBox.setText(buddy.getName());
		}

	}

}
