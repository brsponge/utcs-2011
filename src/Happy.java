import java.util.HashSet;
import java.util.Set;

public class Happy {
	public static void main(String[] args) {
		int happy = 1;
		int number = 1;
		while (happy <= 2000) {
			Set<Integer> cycles = new HashSet<Integer>();
			int temp = number;
			while (!cycles.contains(temp)) {
				cycles.add(temp);
				int pro = 0;
				while (temp > 0) {
					int digit = temp % 10;
					temp /= 10;
					pro += digit * digit;
				}
				temp = pro;
			}
			if (temp == 1) {
				if (happy == 10 || happy == 100 || happy == 500 || happy == 1000 || happy == 2000) {
					System.out.println(number);
				}
				happy++;
			}
			number++;
		}
	}
}
