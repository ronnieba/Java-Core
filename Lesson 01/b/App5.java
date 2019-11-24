package b;

public class App5 {
	public static void main(String[] args) {
		int[] numbers = new int[10];
		// Generates 10 Random Numbers in the range 1 -20
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
			System.out.println("Numbers 0 to 9: " + numbers[i] + " Numbers 9 to 0: " + (9 - numbers[i]));
		} // end for loop
	}
}