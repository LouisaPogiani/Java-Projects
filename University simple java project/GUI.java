import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	
	//γραφικη διασυνδεση τυπου φορμας
	//1ο βημα
	  private JPanel panel;
	//2o βημα 
	  private JTextField nameField, idField;
	  private JButton createStudentButton;
	  //2o ΤΜΗΜΑ ΚΩΔΙΚΑ - ΣΥΝΔΕΣΗ ΤΟΥ COURSE
	  private JTextField courseField;
	  private JButton printCourseDetailsButton;
	  //
	  private ArrayList<Course> courses = new ArrayList<Course>();
	  private ArrayList<Student> students;
	  private int studentCounter = 0;
	  
	//oι πανω ιδιοτητες δηλωνονται εδω γιατι ειναι ιδιοτητες βαζω private αν θελω για να τις ξεχωρισω
	  //δεν μπαινουν μεσα στον κατασκευαστη γοατι λαμβανονται ως τοπικες μεταβλητες και δεν θα μπορω να 
	    // τις χρησιμοποιω εξω απο αυτον 
	  
	public GUI() {
		//2o ΤΜΗΜΑ ΚΩΔΙΚΑ - ΣΥΝΔΕΣΗ ΤΟΥ COURSE
		courses.add(new Course("Java"));
		courses.add(new Course("JavaScript"));
		courses.add(new Course("Python"));
		courses.add(new Course("C++"));
		
		panel = new JPanel();
		nameField = new JTextField("enter the name");
		idField = new JTextField("enter the id");
		createStudentButton = new JButton ("create Student");
		//2o ΤΜΗΜΑ ΚΩΔΙΚΑ - ΣΥΝΔΕΣΗ ΤΟΥ COURSE
		courseField = new JTextField("enter a course: ");
		printCourseDetailsButton = new JButton("Print course details: ");
		
		//3ο βημα 
		panel.add(nameField);
		panel.add(idField);
		panel.add(createStudentButton);
		panel.add(courseField);
		panel.add(printCourseDetailsButton);
		
		//4o βημα
		this.setContentPane(panel);
		
		 //step3 -- κατασκευη αντικειμενου ακροατη
		ButtonListener listener = new ButtonListener();
		//step 4 -- συνδεση ακροατη με πηγη συμβαντων
		createStudentButton.addActionListener(listener);
		
		//γενικες λειτουργιες κατασκευαστη
		this.setSize(400,400);
		this.setVisible(true);
		this.setTitle("Student Form");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	
	//step1 -- δημιουργια κλασης ακροατη
	
	 class ButtonListener implements ActionListener{
		//step2--συγγραφη εκτελουμενου κωδικα
		public void doSmth() {
			
		}
         
		@Override	
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String id = idField.getText();
			
			Student s = new Student(name,id);
			
			System.out.println("Student has been successfully created");
		   
			//θελω να προσθεσω τον νεο φοιτητη στο επιλεγμενο μαθημα
			
			String courseName = courseField.getText();
			Course selectedCourse = null;
			for(Course course: courses) {
				if(courseName.equals(course.getTitle()))
					selectedCourse = course;
					}
           if(e.getSource().equals(printCourseDetailsButton)) {
				
				String studentName = nameField.getText();
				String studentAM = "it" + studentCounter;
				Student newStudent = new Student(studentName, studentAM);
				studentCounter++;
				students.add(newStudent);
				
				selectedCourse.addStudent(newStudent);
				
			}
			
		}
		
		
		
		
	}
	
}
