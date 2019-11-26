package c.persons;

//Create a MyClass class
public class TestConstractor {
	int x; // Create a class attribute

// Create a class constructor for the TestConstractor class
	public TestConstractor() {
		x = 5; // Set the initial value for the class attribute x
	}

	public static void main(String[] args) {
		TestConstractor myObj = new TestConstractor(); // Create an object of class TestConstractor (This will call the
														// constructor)
		System.out.println(myObj.x); // Print the value of x
	}
}

//Outputs 5