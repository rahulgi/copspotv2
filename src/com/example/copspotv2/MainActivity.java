package com.example.copspotv2;

import java.net.MalformedURLException;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponseCallback;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private MobileServiceClient mClient;
	private MobileServiceTable<CopLocation> mCopsTable;
	private Button tagButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			// Create the Mobile Service Client instance, using the provided
			// Mobile Service URL and key
			mClient = new MobileServiceClient(
					"https://copspotv2.azure-mobile.net/",
					"prLpqYYlUKQhWGlnOBTjHACmJxMFxL97",
					this); //.withFilter(new ProgressFilter());

			// Get the Mobile Service Table instance to use
			mCopsTable = mClient.getTable(CopLocation.class);
			
			// Get the tag button
			tagButton = (Button) findViewById(R.id.tag_button);
			tagButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					addLocation(v);
				}
			});

			// mTextNewToDo = (EditText) findViewById(R.id.textNewToDo);

			// Create an adapter to bind the items with the view
			// mAdapter = new ToDoItemAdapter(this, R.layout.row_list_to_do);
			// ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
			// listViewToDo.setAdapter(mAdapter);
		
			// Load the items from the Mobile Service
			// refreshItemsFromTable();

		} catch (MalformedURLException e) {
			createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
		}
	}
	
	/**
	 * Add a new item
	 * 
	 * @param view
	 *            The view that originated the call
	 */
	public void addLocation(View view) {
		if (mClient == null) {
			return;
		}

		// Create a new item
		CopLocation loc = new CopLocation();
		loc.setLocation("Test Lcoation");

		//loc.setText(mTextNewToDo.getText().toString());
		//item.setComplete(false);
		
		// Insert the new item
		mCopsTable.insert(loc, new TableOperationCallback<CopLocation>() {

			public void onCompleted(CopLocation entity, Exception exception, ServiceFilterResponse response) {
				
				if (exception == null) {
					/*if (!entity.isComplete()) {
						// mAdapter.add(entity);
					}*/
				} else {
					createAndShowDialog(exception, "Error");
				}

			}
		});
	}
	
	/**
	 * Creates a dialog and shows it
	 * 
	 * @param exception
	 *            The exception to show in the dialog
	 * @param title
	 *            The dialog title
	 */
	private void createAndShowDialog(Exception exception, String title) {
		Throwable ex = exception;
		if(exception.getCause() != null){
			ex = exception.getCause();
		}
		createAndShowDialog(ex.getMessage(), title);
	}
	
	/**
	 * Creates a dialog and shows it
	 * 
	 * @param message
	 *            The dialog message
	 * @param title
	 *            The dialog title
	 */
	private void createAndShowDialog(String message, String title) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setMessage(message);
		builder.setTitle(title);
		builder.create().show();
	}
}
