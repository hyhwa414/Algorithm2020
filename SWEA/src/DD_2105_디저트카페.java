import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DD_2105_디저트카페 {
	static int N;
	static int[][] map;
	static boolean[][] v;
	static boolean[] dessert;
	static int startX;
	static int startY;
	static int max;
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {-1, 1, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			v = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			startX = -1; startY = -1;
			max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if((i == 0 && j == 0)
							|| (i == 0 && j == N - 1)
							|| (i == N - 1 && j == 0)
							|| (i == N - 1 && j == N - 1))
						continue;
					v = new boolean[N][N];
					dessert = new boolean[101];
					startX = i; startY = j;
					dfs(i, j, 0, 0);
				}
			}
			
			if(max == Integer.MIN_VALUE) max = -1;
			System.out.println("#" + tc + " " + max);
		}
	}

	public static void dfs(int x, int y, int d, int k) {
		if(k >= 4 && x == startX && y == startY) {
//			System.out.println(route);
			max = Math.max(max, k);
		}
		else {
			if(dessert[map[x][y]])
				return;
			
			dessert[map[x][y]] = true;
			if(k != 0) v[x][y] = true;
			for(int i = d; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(isRange(nextX, nextY) && !v[nextX][nextY]) dfs(nextX, nextY, i, k + 1);				
			}
			dessert[map[x][y]] = false;
			v[x][y] = false;
		}
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}
