package b;

public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = (int) (Math.random() * 11); // integer 0-10
		long y = x; // implicit casting
		int z = (int) y; // explicit casting

		if (x > 5) {
			System.out.println(x + " is Bigger then 5");
		} else {
			System.out.println(x + " is Smaller then 5");
		}
		System.out.println(y + " this is y");
		System.out.println(z + " this is z");

	}

}
