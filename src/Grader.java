
import java.lang.reflect.Method;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

public class Grader {
	  
	public static void main(String[] args) throws Exception{
	    Grader a = new Grader();
	    	if (a.constru()==false)
	    		System.exit(0);
	    	if (a.method()==false)
	    		System.exit(0);
			a.grade();
	}

	
	public void grade()  {
Hello hello=new Hello();
		
	//TestCase1HelloWorld
	String holder="TestCase1HelloWorld"; 

	// Create a stream to hold the output
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	// IMPORTANT: Save the old System.out!
	PrintStream old = System.out;
	// Tell Java to use your special stream
	System.setOut(ps);
	// Print some output: goes to your special stream
	
	
	 String[] arguments = new String[] {"123"};
	hello.main(arguments);
	
	
	// Put things back
	System.out.flush();
	System.setOut(old);
	// Show what happened
	System.out.println(baos.toString());
	String str=baos.toString();
	str=str.replaceAll("\\s+","");

	if (str.equals("HelloWorld!"))
		writeCorrect(holder); 
	else
		writeIncorrect(holder);

}
	
	
public boolean constru() {
	try{  
	    Class <?> cls = Class.forName("Hello");
		 
	/*Constructor<?>[] constructors = cls.getConstructors();
	 for (int i=0; i<constructors.length; i++) {
		   System.out.println(constructors[i].toGenericString());
		    }
	*/
	  Constructor<?> cons1 = cls.getConstructor();
	    System.out.println("Constuctors correct");
	    return true;
	}
	catch (NoSuchMethodException e) {
		System.out.println("The constructor does not exist");
		return false;
	}
	catch (ClassNotFoundException e) {
		System.out.println("Class not found");
		return false;
	}
}

public boolean method() {
	try{  
		 Hello rec = new Hello();
	
		    System.out.println("Methods correct");
		    return true;
}
	/*catch(NoSuchMethodException e) {
		System.out.println("A method does not exist");
		return false;
	}*/
	catch (SecurityException e) {
		System.out.println("Security Error");
		return false;
	}
}
	
	public void writeCorrect(String a) {
		System.out.println(a+ " Correct");
	}
	
	public void writeIncorrect(String a) {
		System.out.println(a + " Incorrect");
	}
}


