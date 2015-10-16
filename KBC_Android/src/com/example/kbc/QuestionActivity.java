package com.example.kbc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends Activity {
    TextView questText, optionA,optionB,optionC,optionD,amountWon;
    String amnt;
    String chosenAnswer;
   final int duration=10;
    KaunBanegaCrorepati objKBC=new KaunBanegaCrorepati();

    //initialize the amount string
    static String[] amount = {"Rs.0", "Rs. 1,000","Rs.2,000","Rs.3,000","Rs.5,000","Rs.10,000","Rs.20,000","Rs.40,000","Rs.80,000","Rs.1,60,000","Rs.3,20,000","Rs.6,40,000","Rs.12,50,000","Rs.25,00,000","Rs.50,00,000","Rs.100,00,000"};
    //initialize answers
    String[] correctAnswer = {"A","B","A","B","D","D","A","C","B","C","D","A","C","B","C"};
    Question qx;
    String[] ques =new String[15];
    int turn = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.questions);
        amountWon = (TextView) findViewById(R.id.amountWonText);
        questText = (TextView) findViewById(R.id.questionTextView);
        optionA = (TextView) findViewById(R.id.optionATextView);
        optionB = (TextView) findViewById(R.id.optionBTextView);
        optionC = (TextView) findViewById(R.id.optionCTextView);
        optionD = (TextView) findViewById(R.id.optionDTextView);

        for(int i1=0;i1<15;i1++){//initializing questions
            ques[i1]="Question number " + (i1+1) + " comes here.";
        }
        for(int i=0 ; i<15;i++){ //creates and adds the question objects to the question class
            qx= new Question(ques[i],i,correctAnswer[i],"optionA of "+(i+1),"optionB of "+(i+1),"optionC of "+(i+1),"optionD of "+(i+1));
            objKBC.addQuestion(qx);
        }

        questText.setText(ques[0]);
        optionA.setText(objKBC.questionArrayList.get(0).optionA);
        optionB.setText(objKBC.questionArrayList.get(0).optionB);
        optionC.setText(objKBC.questionArrayList.get(0).optionC);
        optionD.setText(objKBC.questionArrayList.get(0).optionD);
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
//============================START QUIZ METHOD ====================================================
    public  void startQuiz(int index){


        switch (index) {
            case R.id.optionATextView:// doStuff
                chosenAnswer = "A";
                System.out.println("In case 1");
                break;
            case R.id.optionBTextView: // doStuff
                chosenAnswer = "B";
                System.out.println("In case 2");
                break;
            case R.id.optionCTextView: // doStuff
                chosenAnswer = "C";
                System.out.println("In case 3");
                break;
            case R.id.optionDTextView: // doStuff
                chosenAnswer = "D";
                System.out.println("In case 4");
                break;
        }

        System.out.println("Chosen is  "+chosenAnswer);
        System.out.println("CA is  "+ correctAnswer[turn]);

        if(turn<15) { //checks if the end of game has been reached

            if (chosenAnswer.equals(correctAnswer[turn])) { // Enters if the chosen answer is correct to the corresponding question
                if(turn<14)
                	{System.out.println("in If case   ");
                Context context = getApplicationContext();
                Toast.makeText(context, "CORRECT ANSWER !!",duration).show();
               
                turn++;
                initializeLayout(turn);
                updateAmount(turn);
                	}
                else if(turn==14)
                {
                	 Context context = getApplicationContext();
                     Toast.makeText(context, "CORRECT ANSWER !!", duration ).show();
                     initializeLayout(turn);
                    amnt="Rs. 1,00,00,000";
                    Intent myIntent = new Intent(context,LastActivity.class);
                    myIntent.putExtra("Amount",amnt);
                    startActivityForResult(myIntent, 0);
                }

            } else {  //Enters if the chosen answer is wrong
                Context context = getApplicationContext();
                Toast.makeText(context, "WRONG ANSWER !!",duration).show();
                System.out.println("WRONG ANSWER !!");
//                amnt=updateAmount(turn--);
                amnt = amountAfterLosing(turn);
                Intent myIntent = new Intent(context,LastActivity.class);
                myIntent.putExtra("Amount",amnt);
                startActivityForResult(myIntent, 0);

            }
        }
        else {  //Enters when the user has reached the end of the game (answered all the questions correctly
            System.out.println("Done");
           
        }

    }

    public String updateAmount(int turn){  //this method updates the amount won on the layout screen

        amountWon.setText("You won: " + amount[turn]);
       amnt=""+amount[turn];
       System.out.println("amountttt iss:  "+amnt);
   
       return amnt;

    }

    public void myClickHandler(View target) {        // this method waits for the input/click from the user
        System.out.println("in m  id is "+target.getId());

        startQuiz(target.getId());

    }

    public void initializeLayout(int level){    //inititalizes the layout with the corresponding question and options
        questText.setText(ques[level]);
        optionA.setText(objKBC.questionArrayList.get(level).optionA);
        optionB.setText(objKBC.questionArrayList.get(level).optionB);
        optionC.setText(objKBC.questionArrayList.get(level).optionC);
        optionD.setText(objKBC.questionArrayList.get(level).optionD);
    }
    public String amountAfterLosing(int level){
        if(level<5)
            return amount[0];
        else if(level>=5 && level <10)
            return amount[5];
        else 
            return amount[10];

    }
}

