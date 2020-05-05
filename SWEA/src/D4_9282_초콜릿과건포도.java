import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_9282_초콜릿과건포도 {
	static int n;
	static int m;
	static int[][] map;
	static int[][][][] dp;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			dp = new int[n + 1][m + 1][n + 1][m + 1];
			for(int[][][] d1 : dp) {
				for(int[][] d2 : d1) {
					for(int[] d3 : d2)
						Arrays.fill(d3, Integer.MAX_VALUE);;
				}
			}
			map = new int[n][m];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = dfs(0, 0, n, m);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	public static int dfs(int y, int x, int h, int w) {
		if(w == 1 && h == 1) {
			return 0;
		}
		if(dp[y][x][h][w] != Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		} 
		
		int sum = 0;
		for(int i = y; i < y + h; i++) {
			for(int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
		
		// 가로로 나누어서 비용의 최소비용을 구한다
		for(int i = 1 ; i < h; i++) {
			// 위쪽 비용 
			dp[y][x][i][w] = dfs(y, x, i, w);
			// 아래쪽 비용
			dp[y + i][x][h - i][w] = dfs(y + i, x, h - i, w);
			
			int sum3 = sum + dp[y][x][i][w] + dp[y + i][x][h - i][w];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		
		// 세로로 나누어서 비용의 최소비용을 구한다
		for(int i = 1; i < w; i++) {
			// 왼쪽 비용
			dp[y][x][h][i] = dfs(y, x, h, i);
			// 오른쪽 비용
			dp[y][x + i][h][w - i] = dfs(y, x + i, h, w - i);
			
			int sum3 = sum + dp[y][x][h][i] + dp[y][x + i][h][w - i];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		return dp[y][x][h][w];
	}
}
