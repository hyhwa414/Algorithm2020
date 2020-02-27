import java.util.Scanner;

public class D4_1258_행렬찾기 {
	static int n;
	static int[][] map;
	static int matrixCount;
	static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			}
			
			matrixCount = 0;
			matrix = new int[n*n][2];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] != 0)
						findMatrix(i, j);
				}
			}
			
			sortMatrix();
			
			System.out.print("#" + tc + " " + matrixCount + " ");
			for(int i = 0; i < matrixCount; i++) {
				System.out.print(matrix[i][0] + " " + matrix[i][1] + " ");
			}
			System.out.println();
		}
	}

	public static void sortMatrix() {
		int temp = 0;
		for(int i = 0; i < matrixCount - 1; i++) {
			int minSize = matrix[i][0] * matrix[i][1];
			int minIndex = i;
			for(int j = i + 1; j < matrixCount; j++) {
				if(minSize > matrix[j][0] * matrix[j][1]) {
					minSize = matrix[j][0] * matrix[j][1];
					minIndex = j;
				} else if(minSize == matrix[j][0] * matrix[j][1]) {
					if(matrix[minIndex][0] > matrix[j][0]) {
						minIndex = j;
					}
				}
			}
			
			temp = matrix[minIndex][0];
			matrix[minIndex][0] = matrix[i][0];
			matrix[i][0] = temp;
			
			temp = matrix[minIndex][1];
			matrix[minIndex][1] = matrix[i][1];
			matrix[i][1] = temp;
		}
	}

	public static void findMatrix(int i, int j) {
		int yCount = 0;
		int xCount = 0;
		
		while(j + yCount < n && map[i][j + yCount] != 0) {
			yCount++;
		}
		while(i + xCount < n && map[i + xCount][j] != 0) {
			xCount++;
		}
		
		for(int x = i; x < i + xCount; x++) {
			for(int y = j; y < j + yCount; y++)
				map[x][y] = 0;
		}
		
		matrix[matrixCount][0] = xCount;
		matrix[matrixCount++][1] = yCount;
	}
}
