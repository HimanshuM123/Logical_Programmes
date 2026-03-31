package java8Stream;

import java8.StudentDataBase;
import java8.Student;

public class StreamMapReduceExample {

	private static int noOfNotebooks() {
		
	int noOfNoteBooks=	StudentDataBase.getAllStudents().stream()
			.filter((student -> student.getGradeLevel()>=3))
			.filter(student -> student.getGender().equals("female"))
		.map(Student::getNoteBooks)
		//.reduce(0,(a,b)->a+b);
		.reduce(0, Integer::sum);
	
	return noOfNoteBooks;
	}
	
	public static void main(String[] args) {
			System.out.println("Number of notebooks "+noOfNotebooks() );
	}

}
