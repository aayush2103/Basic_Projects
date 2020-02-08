package comparableAndComparator;

public class Student implements Comparable<Student>{
	
	public int studentId;
	public String name;
	
	public Student(int id, String name) {
		this.studentId=id;
		this.name=name;
	}
	
	@Override
	public String toString() {
		return this.studentId+":"+this.name;
	}
	
	@Override
	public int compareTo(Student st) {
		return this.name.compareTo(st.name);
	}
}
