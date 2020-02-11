import java.util.Arrays;
import java.util.Scanner;

public class NO2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		int[] x = new int[N];
		int[] y = new int[N];
		for(int i = 0; i < N; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			
			for(int j = x[i]; j < x[i] + 10; j++) {
				for(int k = y[i]; k < y[i] + 10; k++) {
					map[j][k]++;
				}
			}
		}
		
		Arrays.sort(x);
		int minX = x[0];
		int maxX = x[N-1] + 10;
		Arrays.sort(y);
		int minY = y[0];
		int maxY = y[N-1] + 10;
		
		int circum = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for(int i = minX; i < maxX; i++) {
			for(int j = minY; j < maxY; j ++) {
				if(map[i][j] != 0) {
					for(int k = 0; k < 4; k++) {
						int tempX = i + dx[k];
						int tempY = j + dy[k];
						
						if(isInside(tempX, tempY) && map[tempX][tempY] == 0) {
							circum++;
						} else if (!isInside(tempX, tempY))
							circum++;
					}
				}
			}
		}
		System.out.println(circum);
	}

	public static boolean isInside(int tempX, int tempY) {
		return tempX < 100 && tempX >= 0 && tempY < 100 && tempY >= 0;
	}
}
