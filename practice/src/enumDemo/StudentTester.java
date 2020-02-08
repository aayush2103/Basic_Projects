package enumDemo;

public class StudentTester {
	public static void main(String[] args) {
		Student s=new Student();
		s.setStudentId(1000);
		s.setTotalMarks(280);
		s.setName("Alvin");
		
		s.calculateGrade();
		s.calculateScholarshipAmount();
		
		System.out.println("Student Details");
		System.out.println("Student Id: "+s.getStudentId());
		System.out.println("Student Name: "+s.getName());
		System.out.println("Student Grade: "+s.getGrade());
		System.out.println("Scholarship Amount: "+s.getScholarshipAmount());
	}
}
