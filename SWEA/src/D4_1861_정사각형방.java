import java.util.Scanner;

public class D4_1861_정사각형방 {
	static boolean[][] visited;
	static int N;
	static int[][] room;
	static int maxCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			room = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					room[i][j] = sc.nextInt();
			}
			
			visited = new boolean[N][N];
			
			int count = 0;
			int maxCount = 0;
			int num = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						count = check(i, j, 1);
						visited[i][j] = true;
					}
					if(maxCount < count) {
						maxCount = count;
						num = room[i][j];
					} else if (maxCount == count && room[i][j] < num)
						num = room[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + num + " " + maxCount);
		}
	}

	public static int check(int x, int y, int count) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int i = 0; i < 4; i++) {
			int tempX = x + dx[i];
			int tempY = y + dy[i];
			
			if(tempX >= 0 && tempX < N && tempY >= 0 && tempY < N && room[tempX][tempY] == room[x][y] + 1) {
				visited[tempX][tempY] = true;
				count = check(tempX, tempY, count + 1);
			}
		}
		
		return count;
	}
}
