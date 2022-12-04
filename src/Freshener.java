import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Freshener {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("freshener.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			char[][] map = new char[r][];
			for (int j = 0; j < r; j++) {
				String temp = scanner.next();
				map[j] = temp.toCharArray();
			}
			int[][] fresheners = new int[r][c];
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (map[j][k] > 47 && map[j][k] < 58) {
						boolean[][] visited = new boolean[r][c];
						int amount = map[j][k] - 48;
						Queue<Integer> bfs = new ArrayDeque<>();
						bfs.offer(j);
						bfs.offer(k);
						bfs.offer(amount);
						while (!bfs.isEmpty()) {
							int row = bfs.poll();
							int col = bfs.poll();
							int left = bfs.poll();
							if (left == -1)
								continue;
							if (row < 0 || col < 0 || row >= r || col >= c)
								continue;
							if (visited[row][col])
								continue;
							if (map[row][col] == '-' || map[row][col] == '|')
								continue;
							visited[row][col] = true;
							fresheners[row][col]++;
							bfs.add(row + 1);
							bfs.add(col);
							bfs.add(left - 1);
							bfs.add(row - 1);
							bfs.add(col);
							bfs.add(left - 1);
							bfs.add(row);
							bfs.add(col + 1);
							bfs.add(left - 1);
							bfs.add(row);
							bfs.add(col - 1);
							bfs.add(left - 1);
						}
					}
				}
			}
			int empty = 0, full = 0;
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (fresheners[j][k] == 0 && !(map[j][k] == '-' || map[j][k] == '|'))
						empty++;
					if (fresheners[j][k] > 1)
						full++;
				}
			}
			System.out.println(full + " " + empty);
		}
	}
}
