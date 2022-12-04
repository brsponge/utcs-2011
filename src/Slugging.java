import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Slugging {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("slugging.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int o = 0, s = 0, d = 0, t = 0, h = 0, w = 0;
			String scores = scanner.next();
			for (int j = 0; j < scores.length(); j++) {
				if (scores.charAt(j) == 'O')
					o++;
				else if (scores.charAt(j) == 'S') {
					s++;
				} else if (scores.charAt(j) == 'D') {
					d++;
				} else if (scores.charAt(j) == 'T') {
					t++;
				} else if (scores.charAt(j) == 'H') {
					h++;
				} else if (scores.charAt(j) == 'W') {
					w++;
				}
			}
			if (w == scores.length())
				System.out.println("NONE");
			else {
				double value = (s + 2 * d + 3 * t + 4 * h) / (double) (s + d + t + h + o);
				System.out.printf("%.3f\n", value);
			}
		}
	}
}
