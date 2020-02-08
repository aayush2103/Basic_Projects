package enumDemo;

enum Grade{
	A(5000),B(4000),C(3000),D(2000),E(0);
	private int val;
	Grade(int val){
		this.val=val;
	}
	public int getScholarshipAmount() {
		return this.val;
	}
}

public class Student {
	private int studentId;
	private String name;
	private Grade grade;
	private int scholarshipAmount;
	private int totalMarks;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public int getScholarshipAmount() {
		return scholarshipAmount;
	}
	public void setScholarshipAmount(int scholarshipAmount) {
		this.scholarshipAmount = scholarshipAmount;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public void calculateGrade() {
		if(this.totalMarks>=250)
			this.grade=Grade.A;
		else if(this.totalMarks>=200 && this.totalMarks<250)
			this.grade=Grade.B;
		else if(this.totalMarks>=175 && this.totalMarks<200)
			this.grade=Grade.C;
		else if(this.totalMarks>=150 && this.totalMarks<175)
			this.grade=Grade.D;
		else
			this.grade=Grade.E;
	}
	public void calculateScholarshipAmount() {
		this.scholarshipAmount=this.grade.getScholarshipAmount();
	}
}
