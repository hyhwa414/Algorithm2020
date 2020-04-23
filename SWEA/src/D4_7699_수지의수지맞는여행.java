import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7699_수지의수지맞는여행 {
	static int R;
	static int C;
	static char[][] map;
	static String s;
	static boolean[][] visited;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			visited = new boolean[R][C];
			s = "";
			max = Integer.MIN_VALUE;
			for(int i = 0; i < R; i++) {
				String input = br.readLine();
				for(int j = 0; j < C; j++)
					map[i][j] = input.charAt(j);
			}
			
			travel(0,0);
			
			System.out.println("#" + tc + " " + max);
		}
	}

	public static void travel(int x, int y) {
		s += map[x][y];
		visited[x][y] = true;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int flag = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isRange(nx, ny) && !visited[nx][ny] && !s.contains(Character.toString(map[nx][ny]))) {
				flag = 1;
				travel(nx, ny);
				flag = 0;
			}
		}
		if(flag == 0) {
			if(max < s.length())
				max = s.length();
			s = s.substring(0, s.length() - 1);
			visited[x][y] = false;
			return;
		}
		
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
