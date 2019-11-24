package b;

public class App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = (int) (Math.random() * 3) + 1; // integer 1-3
		System.out.println(r + " this is r");
		switch (r) {
		case 1:
			System.out.println(r + " this is One");
			break;
		case 2:
			System.out.println(r + " this is Two");
			break;
		case 3:
			System.out.println(r + " this is Two");
			break;
		default:
			System.out.println(r + " this is Something else");
		}
	}

}
