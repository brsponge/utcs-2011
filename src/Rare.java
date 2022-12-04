import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Rare {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("rare.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int name = scanner.nextInt();
			scanner.nextLine();
			String ascii = scanner.nextLine();
			char[] table = new char[128];
			for (int j = 0; j < ascii.length(); j++) {
				table[ascii.charAt(j)]++;
			}
			String rares = "";
			for (int j = 0; j < table.length; j++) {
				if (table[j] != 0 && table[j] / (double) ascii.length() < 0.04)
					rares += (char) j;
			}
			System.out.printf("data set %d, %d:%s\n", name, rares.length(), rares);
		}
	}
}
