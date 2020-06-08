import java.util.Arrays;

public class L2_카카오프렌즈컬러링북 {
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int M;
	static int N;
	static int size;
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
		System.out.println(Arrays.toString(solution(m,n,picture)));
		
	}
	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		M = m;
		N = n;
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && picture[i][j] != 0) {
					visited[i][j] = true;
					size = 1;
					dfs(i, j, picture[i][j], picture);
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static void dfs(int x, int y, int color, int[][] picture) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isRange(nx, ny) && !visited[nx][ny] && (picture[nx][ny] == color)) {
				visited[nx][ny] = true;
				size++;
				dfs(nx, ny, picture[nx][ny], picture);
			}
		}
	}

	public static boolean isRange(int x, int y) {
		return (x >= 0 && x < M && y >= 0 && y < N);
	}
}
