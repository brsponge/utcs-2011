import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QBRating {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("qbrating.dat"));
		int N = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < N; i++) {
			String name = scanner.nextLine();
			int att = scanner.nextInt();
			int yds = 0;
			int td = 0;
			int comp = 0;
			int interceptions = 0;
			scanner.nextLine();
			for (int j = 0; j < att; j++) {
				String s = scanner.nextLine();
				if (s.contains("INC")) {
				} else if (s.contains("INT")) {
					interceptions++;
				} else if (s.contains("TD")) {
					yds += Integer.parseInt(s.substring(0, s.indexOf(" ")));
					td++;
					comp++;
				} else {
					yds += Integer.parseInt(s);
					comp++;
				}
			}
			long value = Math.round((8.4 * yds + 330 * td + 100 * comp - 200 * interceptions) / att);
			System.out.printf("%s %s\n", name, value == 0 ? "NO RATING" : value);
		}
	}
}
