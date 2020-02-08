package hackerRank;

//java-priority-queue.pdf

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class priorityQ {

	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Priorities{
	public List<Student> getStudents(List<String> events){
		PriorityQueue<Student> pq=new PriorityQueue(events.size(), 
			Comparator.comparing(Student::getCgpa).reversed()
						.thenComparing(Student::getName)
						.thenComparing(Student::getId));
		
		for(String event : events) {
			if(event.contains("ENTER")) {
				String[] values=event.split(" ");
				Student stu=new Student(Integer.parseInt(values[3]), values[1], Double.parseDouble(values[2]));
				pq.add(stu);
			}
			else if(event.contains("SERVED"))
				pq.poll();
		}
		List<Student> list=new ArrayList<Student>();
		Iterator it=pq.iterator();
		
		while(it.hasNext())
			list.add(pq.poll());
		
		return list;
	}
}

class Student{
	
	private int id;
	private String name;
	private double cgpa;
	
	public Student(int id, String name, double cgpa) {
		this.id=id;
		this.name=name;
		this.cgpa=cgpa;
	}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public double getCgpa() {
		return this.cgpa;
	}
}