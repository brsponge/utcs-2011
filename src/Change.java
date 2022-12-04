import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Change {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("change.dat"));
		int N = scanner.nextInt();
		double[] money = new double[] { .01, .05, .1, .25, .5, 1, 1, 2, 5, 10, 20, 50, 100 };
		for (int i = 0; i < N; i++) {
			double amount = 0;
			for (int j = 0; j < money.length; j++) {
				amount += money[j] * scanner.nextInt();
			}
			System.out.println((int) amount);
		}
	}
}
