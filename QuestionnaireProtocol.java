import java.net.*;
import java.io.*;

public class QuestionnaireProtocol {
	private static final int GREETING = 0;
	private static final int QUESTION = 1;
	//private static final int STEP = 2;
	private static final int ANSWER = 2;
	private static final int NEXT = 3;
	private static final int CLOSE = 4;

	private static final int N_QUESTION = 3;

	private int state = GREETING;
	private int curr_question = 0;
	private int answer[] = {0 , 0, 0};
	private int q1 = 0;
	private int q2 = 0;
	private int q3 = 0;
	private String Sq1 = "Wrong";
	private String Sq2 = "Wrong";
	private String Sq3 = "Wrong";
	private int sum =0 ;
	private int i = 3;
	private String Str[] = {"3","2","1"};

	private String[] questions = { "Q1: (A + B)*(A+B)\n1. A*A + B*B\n2. A*A +A*B + B*B\n3. A*A +2*A*B + B*B ","Q2: (A + B)*(A - B)\n1. A*A + 2*B*B\n2. A*A - B*B\n3. A*A -2*A*B + B*B ","Q3: sin(x)*sin(x) + cos(x)*cos(x)\n1. 1\n2. 2\n3. 3"};
	

    public String processInput(String theInput) {
        String theOutput = "";
	//public int theAnswer = 0;

        if (state == GREETING) {
            theOutput = "Welcome To The Questionnaire :)";
            state = QUESTION;
        }  else if (state == QUESTION) {
                theOutput = questions[curr_question];
		state = ANSWER;
                                     
	 }else if (state == ANSWER) {
		if(theInput.equals(Str[curr_question])){ //then q3 = true
		answer[curr_question] = 1;
		state = NEXT;
		}else
                state = NEXT;
	} else if (state == NEXT) {
		q1 = answer[0];
		q2 = answer[1];
		q3 = answer[2];
		if(q1 == 1)
			Sq1 = "Right";
		if(q2 == 1)
			Sq2 = "Right";
		if(q3 == 1)
			Sq3 = "Right";
			
                if (curr_question == (N_QUESTION - 1)){
			sum = q1 + q2+ q3;
                    theOutput = "Q1) 3\nQ2) 2\nQ3) 1\nScore:"+sum+"/3\nQ1:"+Sq1+"\nQ2:"+Sq2+"\nQ3:"+Sq3;
                	state = CLOSE;
		}else{
                    curr_question++;
                state = QUESTION;
             	} 
	}else if (state == CLOSE) {
		theOutput = "BYE";
	}
        return theOutput;
    }
}

