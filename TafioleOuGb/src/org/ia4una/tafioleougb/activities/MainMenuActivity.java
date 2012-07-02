package org.ia4una.tafioleougb.activities;

import org.ia4una.tafioleougb.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainMenuActivity extends Activity implements OnClickListener {
	private static final String TAG = "MainMenuActivity";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Set up click listeners for all the buttons
		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		View newButton = findViewById(R.id.new_button);
		newButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.about_button:
			Intent i = new Intent(this, AboutActivity.class);
			startActivity(i);
			break;
		case R.id.exit_button:
			finish();
			break;
		case R.id.new_button:
			startGame();
			break;
		case R.id.continue_button:
			continueGame();
			break;
		}
	}

	private void startGame() {
		Log.d(TAG,"Starting the game");
		//TODO
	}
	
	private void continueGame() {
		Log.d(TAG,"Continuing the game");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, PrefsActivity.class));
			return true;
			// More items go here (if any) ...
		}
		return false;
	}
}