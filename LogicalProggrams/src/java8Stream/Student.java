package java8Stream;

public class Student {

	int rollNum;
	String name;
	int marks;

	Student(int rollNum, String name, int marks) {
		this.rollNum = rollNum;
		this.marks = marks;
		this.name = name;

	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
