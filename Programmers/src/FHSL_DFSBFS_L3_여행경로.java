import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class FHSL_DFSBFS_L3_여행경로 {
	static boolean[] visited;
	static List<String> list;
	static String route;

	public static void main(String[] args) {
		String[][] t1 = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[] r1 = solution(t1);
		System.out.println(Arrays.toString(r1));
	}

	public static String[] solution(String[][] tickets) {
		list = new ArrayList<String>();
		for (int i = 0; i < tickets.length; i++) {
			visited = new boolean[tickets.length];
			String start = tickets[i][0];
			String end = tickets[i][1];
			route = "";

			if (start.equals("ICN")) {
				route += start + ",";
				visited[i] = true;
				dfs(tickets, end, 1);
			}
		}
		
		Collections.sort(list);
		String[] answer = list.get(0).split(",");

		return answer;
	}

	public static void dfs(String[][] tickets, String end, int count) {
		route += end + ",";

		if (count == tickets.length) {
			list.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			String s = tickets[i][0];
			String e = tickets[i][1];
			if (s.equals(end) && !visited[i]) {
				visited[i] = true;
				dfs(tickets, e, count + 1);
				visited[i] = false;
				route = route.substring(0, route.length() - 4);
			}
		}
	}
}
