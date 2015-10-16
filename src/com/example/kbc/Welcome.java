package com.example.kbc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


	public class Welcome extends ActionBarActivity {
		ImageView img;
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.welcome);
	        img = (ImageView) findViewById(R.id.imageview);
	        img.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View view) {
	            	
	                Intent myIntent = new Intent(view.getContext(),QuestionActivity.class);
	               startActivityForResult(myIntent, 0);
	                //startActivity(myIntent);
	                //finish();
	            }
	 
	        });
	      
	    }
	    

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


