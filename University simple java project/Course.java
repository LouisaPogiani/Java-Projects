import java.util.ArrayList;

public class Course {
	private String title;
	private ArrayList<Student> students = new ArrayList<Student>();

	public Course(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public void addStudent(Student aStudent) {
		students.add(aStudent);
	}
	
	public void printDetails() {
		System.out.println("Course name: " +title);
		System.out.println("Has the following students");
		for(Student student: students)
		   System.out.println(student);
		   System.out.println("-------------");
	}
	

}
