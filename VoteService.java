package cs3560_A1_VoteSimulator;

import java.util.LinkedList;
import java.util.HashMap;

public class VoteService {
	
	private Question question;
	private HashMap<Student, Integer> studentAnswers = new HashMap<>();
	private LinkedList<Integer> answerCollection = new LinkedList<>(); 
	
	public VoteService() {
	}

	public VoteService(Question question) {
		this.question = question;
	}

	public String getQuestion() {
		return question.getQuestion();
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public void displayQuestion() {
		System.out.println(getQuestion());
	}
	
	public void displayAnswers() {
		int i = 0;
		for(char c = 'A' ; c <= 'Z' ; ++c) {
			System.out.println(c + ". " + question.getAnswers().get(i++));
			if(i==question.getAnswers().size()) break;
		}
	}
	
	//S is the student, i is their vote
	//0 = A, 1 = B, 2 = C ...
	public void addStudentAnswer(Student s, int i) {		
		//Check if student already voted, if so replace value
		if(!studentAnswers.containsKey(s)) {
			studentAnswers.put(s, i);
		} else {
			studentAnswers.replace(s, i);
		}
		
	}
	
	public void displayResult() {
		
		calculateResult();
		
		int i = 0;
		for(char c = 'A' ; c <= 'Z' ; ++c) {
			System.out.println(c + ": " + answerCollection.get(i++));
			if(i==question.getAnswers().size()) break;
		}
		
		answerCollection.clear();
		
	}
	
	private void calculateResult() {		
		for(int i=0 ; i<question.getAnswers().size() ; ++i) {
			answerCollection.add(0);
		}
		
		//Iterates through Map getting all the values from studentAnswers
		for(Integer i : studentAnswers.values()) {
			int val = answerCollection.get(i);
			answerCollection.set(i, ++val);
		}
	}
 	
}
