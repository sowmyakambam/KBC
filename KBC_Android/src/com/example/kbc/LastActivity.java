package com.example.kbc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LastActivity extends ActionBarActivity{
	Button playAgain;
	QuestionActivity qa=new QuestionActivity();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.last);
		playAgain = (Button) findViewById(R.id.playagain);
		playAgain.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				Intent myIntent = new Intent(view.getContext(),MainActivity.class);
				startActivityForResult(myIntent, 0);
				//startActivity(myIntent);
				//finish();
			}

		});

		String amnt1=getIntent().getStringExtra("Amount");

		TextView amount = (TextView) findViewById(R.id.wonAmount);
		if(amnt1.equals("Rs.0"))
		{
			String str="Sorry! You won: \n"+amnt1;
			amount.setText(str);
			amount.setTextSize(60);
		}
		else
		{
			String str="Congratulations!! You won: \n"+amnt1;
			amount.setText(str);
			amount.setTextSize(60);
		}

	}
	//    public void display(View view) {
	//  		// TODO Auto-generated method stub
	//    	TextView amount = (TextView) findViewById(R.id.wonAmount);
	//  		amount.setText("COngratulations: " +amnt1);
	//
	//  	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
