import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Population {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("population.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int M = scanner.nextInt();
			int totalMax = Integer.MIN_VALUE;
			int localMax = 0;
			for (int j = 0; j < M; j++) {
				localMax += scanner.nextInt();
				if (localMax > totalMax)
					totalMax = localMax;
				if (localMax < 0)
					localMax = 0;
			}
			System.out.println(totalMax);
		}
	}
}
