import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Soccer {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("soccer.dat"));
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			HashMap<String, Team> map = new HashMap<>();
			for (int j = 0; j < 6; j++) {
				String aName = scanner.next();
				int aGoal = scanner.nextInt();
				String bName = scanner.next();
				int bGoal = scanner.nextInt();
				if (!map.containsKey(aName))
					map.put(aName, new Team(aName));
				if (!map.containsKey(bName))
					map.put(bName, new Team(bName));
				Team a = map.get(aName);
				Team b = map.get(bName);
				a.opposingTeams.put(bName, a.index++);
				b.opposingTeams.put(aName, b.index++);
				a.games[a.opposingTeams.get(bName)][0] = aGoal;
				a.games[a.opposingTeams.get(bName)][1] = bGoal;
				b.games[b.opposingTeams.get(aName)][1] = aGoal;
				b.games[b.opposingTeams.get(aName)][0] = bGoal;
			}
			ArrayList<Team> teams = new ArrayList<>(map.values());
			Collections.sort(teams, Team.COMPARATOR);
			if (Team.COMPARATOR.compare(teams.get(3), teams.get(2)) == 0)
				System.out.printf("data set %d: %s\n", i + 1, "UNRESOLVED");
			else
				System.out.printf("data set %d: %s\n", i + 1, teams.get(3).name);
		}
	}

	private static class Team {
		HashMap<String, Integer> opposingTeams = new HashMap<>();
		int index = 0;
		int[][] games = new int[3][2];
		String name;

		public Team(String name) {
			this.name = name;
		}

		static final Comparator<Team> COMPARATOR = (a, b) -> {
			int aPoints = 0;
			for (int i = 0; i < 3; i++) {
				if (a.games[i][0] > a.games[i][1])
					aPoints += 3;
				else if (a.games[i][0] == a.games[i][1])
					aPoints++;
			}
			int bPoints = 0;
			for (int i = 0; i < 3; i++) {
				if (b.games[i][0] > b.games[i][1])
					bPoints += 3;
				else if (b.games[i][0] == b.games[i][1])
					bPoints++;
			}
			int compare = Integer.compare(aPoints, bPoints);
			if (compare != 0)
				return compare;
			int aGoalDiff = 0;
			int bGoalDiff = 0;
			for (int i = 0; i < 3; i++) {
				aGoalDiff += Math.max(0, a.games[i][0] - a.games[i][1]);
				bGoalDiff += Math.max(0, b.games[i][0] - b.games[i][1]);
			}
			compare = Integer.compare(aGoalDiff, bGoalDiff);
			if (compare != 0)
				return compare;
			int aTotalGoals = 0;
			int bTotalGoals = 0;
			for (int i = 0; i < 3; i++) {
				aTotalGoals += a.games[i][0];
				bTotalGoals += b.games[i][0];
			}
			compare = Integer.compare(aTotalGoals, bTotalGoals);
			if (compare != 0)
				return compare;
			int aMatch = a.games[a.opposingTeams.get(b.name)][0];
			int bMatch = a.games[a.opposingTeams.get(b.name)][1];
			return Integer.compare(aMatch, bMatch);
		};
	}
}
