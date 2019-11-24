package c;

import java.util.Arrays;

public class App10 {
	public static void main(String[] args) {
		int[] numbers = new int[10];
		int sum = 0;
		// Generates 10 Random Numbers in the range 1 -20
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100);
			sum = sum + numbers[i];
		} // end for loop
		System.out.println("Numbers Generated: " + Arrays.toString(numbers));
		System.out.println("Sum of Numbers: " + sum);
		System.out.println("Average of Numbers: " + sum / numbers.length);
	}
}