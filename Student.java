package cs3560_A1_VoteSimulator;

public class Student {
	
	private String studentID;
	
	public Student() {
		this.studentID = "";
	}
	
	public Student(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

}
