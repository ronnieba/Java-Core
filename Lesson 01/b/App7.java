package b;

public class App7 {
	/* Function to get sum of digits */

	static int getSum(int n) {

		int sum = 0;

		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
		}

		return sum;
	}

	// Driver program
	public static void main(String[] args) {
		int n = (int) (Math.random() * 10000);

		System.out.println("The number is:" + n + "  The sum of hisdigits are:" + getSum(n));
	}
}