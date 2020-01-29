import java.util.Scanner;

public class NO2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] paper = new int[100][100];
		
		int N = sc.nextInt();
		int minX = 0, minY = 0;
		int maxX = 0, maxY = 0;
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(i == 0) {
				minX = x;
				minY = y;
				maxX = x + 10;
				maxY = y + 10;
			} else {
				if(minX > x)
					minX = x;
				if(minY > y)
					minY = y;
				if(maxX < x + 10)
					maxX = x + 10;
				if(maxY < y + 10)
					maxY = y + 10;
			}
			
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++)
					paper[j][k]++;
			}
		} // 색종이 입력받아서 색종이가 칠해진 부분 체크하기
		
		int result = 0;
		for(int i = minX; i < maxX; i++) {
			for(int j = minY; j < maxY; j++) {
				if(paper[i][j] != 0)
					result ++;
			}
		}
		
		System.out.println(result);
	}
}
