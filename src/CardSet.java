import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardSet {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("cardset.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			String a = scanner.next();
			String b = scanner.next();
			String c = scanner.next();

			if (!(a.charAt(0) == b.charAt(0) && a.charAt(0) == c.charAt(0)
					|| a.charAt(0) != b.charAt(0) && a.charAt(0) != c.charAt(0) && b.charAt(0) != c.charAt(0))) {
				System.out.println("NOT");
				continue;
			}
			int x = a.lastIndexOf(a.charAt(0));
			int y = b.lastIndexOf(b.charAt(0));
			int z = c.lastIndexOf(c.charAt(0));
			if (!(x == y && x == z || x != y && x != z && y != z)) {
				System.out.println("NOT");
				continue;
			}
			a = a.substring(x + 1);
			b = b.substring(y + 1);
			c = c.substring(z + 1);
			if (!(a.charAt(0) == b.charAt(0) && a.charAt(0) == c.charAt(0)
					|| a.charAt(0) != b.charAt(0) && a.charAt(0) != c.charAt(0) && b.charAt(0) != c.charAt(0))) {
				System.out.println("NOT");
				continue;
			}
			a = a.substring(1);
			b = b.substring(1);
			c = c.substring(1);
			if (!(a.charAt(0) == b.charAt(0) && a.charAt(0) == c.charAt(0)
					|| a.charAt(0) != b.charAt(0) && a.charAt(0) != c.charAt(0) && b.charAt(0) != c.charAt(0))) {
				System.out.println("NOT");
				continue;
			}
			System.out.println("SET");
		}
	}
}
