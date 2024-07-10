package concepts;

//Java Program to illustrate Externalizable

//Importing input output classes
import java.io.*;
//Importing utility classes
import java.util.*;

//Main Class
//Class implementing externalizable class
public class ExternalizableDemo implements Externalizable {

	// Member variables of this class
	String name;
	int age;
	int jobId;

	// Constructors of this class

	// Constructor 1
	// No-argument constructor
	public ExternalizableDemo()
	{

		// Display message
		System.out.println(
			"Public no-argument constructor");
	}

	// Constructor 2
	// Default constructor
	public ExternalizableDemo(String name, int age,
							int jobId)
	{

		// This keyword refers to current object itself
		this.name = name;
		this.age = age;
		this.jobId = jobId;
	}

	// Implementing write external method
	public void writeExternal(ObjectOutput out)
		throws IOException
	{
		// Writing name and age to file
		out.writeObject(name);
		out.writeInt(age);
	}

	// Implementing readExternal method
	public void readExternal(ObjectInput in)
		throws IOException, ClassNotFoundException
	{
		// Reading name from file
		name = (String)in.readObject();

		// Reading age from file
		age = in.readInt();
	}

	// Main method
	public static void main(String[] args) throws Exception
	{

		// Creating an object of type ExternalizableDemo
		ExternalizableDemo t1 = new ExternalizableDemo("Ram", 35, 23675);

		// Serialization of object
		FileOutputStream fos = new FileOutputStream("abc.ser");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(t1);

		// Deserialization
		FileInputStream fis = new FileInputStream("abc.ser");

		ObjectInputStream ois = new ObjectInputStream(fis);

		ExternalizableDemo t2 = (ExternalizableDemo)ois.readObject();

		// Display message
		System.out.println("Name :"
						+ " " + t2.name + " "
						+ "Age :"
						+ " " + t2.age);
	}
}
