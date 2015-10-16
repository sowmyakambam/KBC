package com.example.kbc;

import java.util.*;
import java.lang.*;
import java.io.*;
/*

	Object Oriented Programming Final Exam Aug 16, 2014

	Kaun Banega Crorepati is a popular reality show on television.
	The host asks questions and the participant answers them to win prize money.
	It has 15 levels with the following price money at each level.

	Level 1: Rs. 1,000
	Level 2: Rs. 2,000
	Level 3: Rs. 3,000
	Level 4: Rs. 5,000
	Level 5: Rs. 10,000

	Level 6: Rs. 20,000
	Level 7: Rs. 40,000
	Level 8: Rs. 80,000
	Level 9: Rs. 1,60,000
	Level 10: Rs. 3,20,000

	Level 11: Rs. 6,40,000
	Level 12: Rs. 12,50,000
	Level 13: Rs. 25,00,000
	Level 14: Rs. 50,00,000
	Level 15: Rs. 100,00,000

	A player is out if he answers the question incorrectly.
	If a player is out after level 5 he/she gets Rs. 10,000 and after level 10 Rs. 3,20,000.

	If a player decides to quit then he/she gets the amount won at the previous level.
	For example, the participant quits at level 7 without giving a correct or wrong answer
	then the prize money for level 6 which is Rs. 20,000 is awarded.

	The test for you is to write a Java program using the OOP principles to simulate this game.
	Your answer to this programming test will be Autograded.
	So, you have to write your program by STRICTLY following the specifications given below.

	A Java interface named Quiz with 6 methods is provided. Don't change this interface.
	Write a Java class KaunBanegaCrorepati that implements the given Quiz interface.
	The autograder creates an object of KaunBanegaCrorepati to test your program.

	KaunBanegaCrorepati must implement the following:
		1. Create questions that should be shown to the participant.
			* Implement and use quiz interface method addQuestion

		2. Keyboard input for participant name, age and phone.
			* Implement and use quiz interface method registerParticipant

		3. Display questions in the order of level 1 to 15
			* Implement and use quiz interface method getNextQuestion

		4. For each question the participant enters one of the 4 options A, B, C or D

		5. Participant may also enters "quit" if he/she chooses to exit with current prize money

		6. If the participant dosen't quit then, lock the answer
			* Implement and use quiz interface method lockAnswer

		7. If answer is right then go to 2, otherwise quit with the prize money

		8. If the participant completes all 15 questions then he wins 1 crore

		9. Test your program to check if all the methods are working as specified by writing a main method.

	Implement the following classes as specified.

	Participant class with name, age, phone, currentLevel and prizeMoney as private instance variables.
	Provide the following methods in the Participant class.
		public String getName() - returns the name of the participant
		public int getAge() - returns the age of the participant
		public String getPhone() - returns the phone of the participant

	Question class with question, level and correctAnswer as protected instance variables.
	Provide the following methods in the Question class.
		public String getQuestion() - returns the question text
		public int getLevel() - returns the question level which is from 1 to 15
		public String getCorrectAnswer() - returns the correct answer to this question

	VERY IMPORTANT: None of the Quiz interface methods should have console input or output.
	Otherwise the autograder fails there is no way to evaluate your submission.

	All the best!
*/
//=====================================================================================
//=====================================================================================

interface Quiz{

    // addQuestion adds the question given in the parameter and adds it to the questions array
    void addQuestion(Question q);

    // The quiz begins with the registration of the participant
    // Participant name, age in years, phone number and friend's phone number are the parameters
    // an instance of the participant should be created and returned
    Participant registerParticipant(String name, int age, String phone);

    // getCurrentLevel returns the current level the participant is playing
    // It should return a value between 1 - 15 inclusive
    int getCurrentLevel();

    // getNextQuestion returns the next question for the participant to answer
    // The question object has the question text along with options A B C and D
    Question getNextQuestion();

    // lockAnswer accepts the question object and the participants answer
    // Checks if the answer is correct and returns true.
    // If the answer is incorrect it returns false.
    // It also updates the participant's
    boolean lockAnswer(Question q, String answer);

    // getPrizeMoney returns the current prize money the participant is awarded
    // For example, if he/she answered level 6 then Rs. 20,000 is the prize money.
    int getPrizeMoney();

}
//=====================================================================================
 class KaunBanegaCrorepati implements Quiz{
    static ArrayList<Question> questionArrayList = new ArrayList<Question>();
    static String[] amount = {"Rs.0", "Rs. 1,000","Rs.2,000","Rs.3,000","Rs.5,000","Rs.10,000","Rs.20,000","Rs.40,000","Rs.80,000","Rs.1,60,000","Rs.3,20,000","Rs.6,40,000","Rs.12,50,000","Rs.25,00,000","Rs.50,00,000","Rs.100,00,000"};
    static 	Participant participant;
    public void addQuestion(Question q){

        questionArrayList.add(q);
    }

    public Participant registerParticipant(String name, int age,String phone){
        Participant p= new Participant(name,age,phone);
        return p;
    }
    public int getCurrentLevel(){
        return participant.getCurrentLevelPart();
    }

    public Question getNextQuestion(){
        return questionArrayList.get(participant.getCurrentLevelPart());
    }
    public boolean lockAnswer(Question q, String answer){


        if(q.correctAnswer.equals(answer)){
            participant.incrementCurrentLevel();
            System.out.println("Correct answer. You won "  + amount[participant.getCurrentLevelPart()]);

            return true;
        }
//        else if(answer.equals("quit")){
//            System.out.println("You quit the game!! You leave with, " + amount[participant.getCurrentLevelPart()] );
//
//            return false;
//        }

        else
//            System.out.println("Wrong answer. You lost the game!! You leave with, " + amountAfterLosing(participant.getCurrentLevelPart()));
        return false;

    }


    public int getPrizeMoney(){
        return participant.getPrizeMoneyPart();
    }

    public String amountAfterLosing(int level){
        if(level<5)
            return amount[0];
        if(level>=5 && level <10)
            return amount[5];
        else
            return amount[14];

    }
    //=====================================================================================
    //MAIN METHOD
//=====================================================================================
//    public static void main(String[] args){
//        int age=0;
//        String phone="", name="",answer="";
//        boolean qFlag=true;
//        KaunBanegaCrorepati objKBC=new KaunBanegaCrorepati();
//        String[] ques =new String[15];
//
//        for(int i=0;i<3;i++){//initializing questions
//            ques[i]="Question number " + (i+1) + " comes here.";
//        }
//
//
//
//        //initialize answers
//        String[] correctAnswer = {"A","B","A","B","D","D","A","C","B","C","D","A","C","B","C","D"};
//
//        for(int i=0 ; i<3;i++){
//       //     Question qx= new Question(ques[i],i,correctAnswer[i]);
//            objKBC.addQuestion(qx);
//        }
//
//
//
////        Scanner in = new Scanner(System.in);
////
////        boolean flag = true;
////        System.out.println("Welcome to Kaun Banega Crorepati!! ");
////        while(flag){
////            try{
////                System.out.println("Please enter your name.");
////                name=in.nextLine();
////                System.out.println("Enter you phone number.");
////                phone=in.nextLine();
////                System.out.println("Enter age.");
////                age= in.nextInt();
////
////                flag=false;
////            }
////
////            catch(Exception e1){
////                System.out.println("Invalid input. Try again.");
////            }
//////        }
//
//        participant =objKBC.registerParticipant(name,age,phone);
//        System.out.println("You have been registered. Let's start the game.");
//
//
//        while(qFlag){
////            try{
//                Question q;
//                q=objKBC.getNextQuestion();
//                System.out.println("\n\n\n\n"+q.getQuestion() + ".  For level " + (q.getLevel()+1) + ",  for the amount " +amount[participant.getCurrentLevelPart()+1]);
//                System.out.println("Enter options A,B,C or D. If you want to quit, enter 'quit' .");
////                answer=in.nextLine();
////              if(!(answer.equals("A")||answer.equals("B")||answer.equals("C")||answer.equals("D")||answer.equals("quit"))){
////                    throw new Exception();
////                }
//
//
//
//                qFlag=objKBC.lockAnswer(q,answer);
////                qFlag=false;
//
////            }
//
////            catch(Exception e){
////                System.out.println("Invalid input. Please try again.");
////            }
//
//
//        }
//
//
//    }




}
//=====================================================================================
class Question {
    protected String question;
    protected int level;
    protected String correctAnswer;
    protected String optionA,optionB,optionC,optionD;

    public Question(){
        question="No question";
        level=0;
        correctAnswer="none";
    }
    public Question(String question,int level,String correctAnswer,String A, String B, String C, String D){
        this.question=question;
        this.level=level;
        this.correctAnswer=correctAnswer;
        this.optionA = A;
        this.optionB = B;
        this.optionC = C;
        this.optionD = D;

    }
    public String getQuestion(){
        return this.question;
    }
    public int getLevel(){
        return this.level;
    }
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }

}

//=====================================================================================
class Participant{
    private String name,phone;
    private int age,currentLevel,prizeMoney;

    Participant(String name, int age , String phone){
        this.name=name;
        this.age=age;
        this.phone=phone;
        currentLevel=0;
        prizeMoney=0;
    }
    Participant(){
        name="No name";
        age=0;
        phone="0";
        currentLevel=0;
        prizeMoney=0;
    }
    public String getName(){// - returns the name of the participant
        return this.name;
    }
    public int getAge(){// - returns the age of the participant
        return this.age;
    }

    public String getPhone(){// - returns the phone of the participant
        return this.phone;
    }
    public int getCurrentLevelPart(){
        return this.currentLevel;
    }
    public int getPrizeMoneyPart(){
        return this.prizeMoney;
    }
    public int incrementCurrentLevel(){
        this.currentLevel=this.currentLevel+1;
        return this.currentLevel;

    }

}
