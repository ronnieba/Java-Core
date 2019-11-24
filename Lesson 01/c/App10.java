package c;

import java.util.Arrays;

public class App10 {
	public static void main(String[] args) {
		int[] numbers = new int[10];
		// Generates 10 Random Numbers in the range 1 -20
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100);
		} // end for loop
		System.out.println("Numbers Generated: " + Arrays.toString(numbers));

		// Add 2 more elements
		// 1.create new array of correct size
		int[] temp = new int[numbers.length + 2];
		// 2. copy elements
		System.arraycopy(numbers, 0, temp, 0, numbers.length);
		numbers = temp;
		numbers[numbers.length - 2] = (int) (Math.random() * 100);
		numbers[numbers.length - 1] = (int) (Math.random() * 100);
		System.out.println("Numbers Generated: " + Arrays.toString(numbers));
	}
}