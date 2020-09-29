package cs3560_A1_VoteSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SimulationDriver {
	
	public static void main(String args[]) {
		
		System.out.println("=====iVOTESERVICE=====");
		System.out.println("NUMBER OF STUDENTS: " + STUDENT_COUNT + "\n");
		
		//Declare and initialize question
		Question question = new Question(QUESTION, ANSWER);
		VoteService voteService = new VoteService(question);
		
		//Adding another choice
//		question.addAnswer("Not!");
		
		voteService.displayQuestion();
		voteService.displayAnswers();		
		
		//Generates Student ID
		studentList = generateStudents(STUDENT_COUNT);
		
		Random rand = new Random();
		
		//Simulate student choosing answers
		for(int i=0 ; i<studentList.size() ; ++i) {
			voteService.addStudentAnswer(studentList.get(i), rand.nextInt(ANSWER.size()));
		}

		//Simulate some students changing answers, Currently up to 30% of random student change answer
		double answerChange = STUDENT_COUNT*PERCENT_CHANGE;
		for(int i=0 ; i<rand.nextInt((int)answerChange) ; ++i) {
			voteService.addStudentAnswer(studentList.get(rand.nextInt(studentList.size())), rand.nextInt(ANSWER.size()));
		}
			
		//Calculates and displays the result
		System.out.println("\n=====RESULT=====");
		voteService.displayResult();		
	}
	
	//Students generated
	public static ArrayList<Student> generateStudents(int num) {
		ArrayList<Student> s = new ArrayList<>();
		for(int i=0 ; i<num ; ++i) {
			s.add(new Student((i+1)+""));
		}
		return s;
	}	
	
	public static final int STUDENT_COUNT = 40;
	public static final double PERCENT_CHANGE = .3;
	
	//Question and Answers
	public static final String QUESTION = "What is the right answer?";
	public static final ArrayList<String> ANSWER = new ArrayList<String>(Arrays.asList("This", "Is", "The", "Answer"));
	
	//Students voting
	public static ArrayList<Student> studentList = new ArrayList<>();
	
}
