package concepts;

//Java code for serialization and deserialization 
//of a Java object
import java.io.*;

//class Pojo implements java.io.Serializable
class Pojo
{
	public int a;
	public String b;

	// Default constructor
	public Pojo(int a, String b)
	{
		this.a = a;
		this.b = b;
	}

}

class SerializationEx
{
	public static void main(String[] args)
	{ 
		Pojo object = new Pojo(1, "geeksforgeeks");
		String filename = "file.ser";
		
		// Serialization 
		try
		{ 
			//Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// Method for serialization of object
			out.writeObject(object);
			
			out.close();
			file.close();
			
			System.out.println("Object has been serialized");

		}
		
		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}


		Pojo object1 = null;

		// Deserialization
		try
		{ 
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			// Method for deserialization of object
			object1 = (Pojo)in.readObject();
			
			in.close();
			file.close();
			
			System.out.println("Object has been deserialized ");
			System.out.println("a = " + object1.a);
			System.out.println("b = " + object1.b);
		}
		
		
		
		catch(Exception ex)
		{
			System.out.println("ClassNotFoundException is caught"+ex);
		}
		
		
		
		

	}
}
//IOException is caughtjava.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: concepts.Pojo
//If not implemented