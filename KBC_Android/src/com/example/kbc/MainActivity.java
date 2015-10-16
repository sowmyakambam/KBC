package com.example.kbc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	EditText p_name,p_age,p_phoneno;
	Button register;
	public static String serverURL="localhost:3306";
	String enteredName;
    @Override
    
    
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_name=(EditText)findViewById(R.id.name);
        p_age=(EditText)findViewById(R.id.age);
        p_phoneno=(EditText)findViewById(R.id.phoneno);
        
         register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	
                Intent myIntent = new Intent(view.getContext(),Welcome.class);
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
