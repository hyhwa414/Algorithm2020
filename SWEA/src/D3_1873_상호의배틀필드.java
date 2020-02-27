import java.util.Scanner;

public class D3_1873_상호의배틀필드 {
	static int carX;
	static int carY;
	static char[][] map;
	static int H;
	static int W;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			carX = 0;
			carY = 0;
			for(int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
				for(int j = 0; j < W; j++) {
					if(map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
						carX = i;
						carY = j;
					}
				}
 			}
			
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder(sc.next());
			
			for(int i = 0; i < N; i++) {
				if(sb.charAt(0) == 'S') {
					shoot(map[carX][carY]);
				} else {
					move(sb.charAt(0));
				}
				sb.deleteCharAt(0);
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j <map[i].length; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
	}

	public static void move(char direction) {
		switch(direction) {
			case 'U':
				map[carX][carY] = '^';
				if(carX - 1 >= 0 && map[carX - 1][carY] == '.') {
					map[carX][carY] = '.';
					map[carX - 1][carY] = '^';
					carX = carX - 1;
				}
				break;
			case 'D':
				map[carX][carY] = 'v';
				if(carX + 1 < H && map[carX + 1][carY] == '.') {
					map[carX][carY] = '.';
					map[carX + 1][carY] = 'v';
					carX = carX + 1;
				}
				break;
			case 'L':
				map[carX][carY] = '<';
				if(carY - 1 >= 0 && map[carX][carY - 1] == '.') {
					map[carX][carY] = '.';
					map[carX][carY - 1] = '<';
					carY = carY - 1;
				}
				break;
			case 'R':
				map[carX][carY] = '>';
				if(carY + 1 < W && map[carX][carY + 1] == '.') {
					map[carX][carY] = '.';
					map[carX][carY + 1] = '>';
					carY = carY + 1;
				}
				break;
		}
	}
	
	public static void shoot(char direction) {
		int x = carX;
		int y = carY;
		
		int dist = 1;
		switch(direction) {
			case '^':
				while(x - dist >= 0 && map[x - dist][y] != '#') {
					if(map[x - dist][y] == '*') {
						map[x - dist][y] = '.';
						break;
					}
					dist++;
				}
				break;
			case 'v':
				while(x + dist < H && map[x + dist][y] != '#') {
					if(map[x + dist][y] == '*') {
						map[x + dist][y] = '.';
						break;
					}
					dist++;
				}
				break;
			case '<':
				while(y - dist >= 0 && map[x][y - dist] != '#') {
					if(map[x][y-dist] == '*') {
						map[x][y-dist] = '.';
						break;
					}
					dist++;
				}
				break;
			case '>':
				while(y + dist < W && map[x][y + dist] != '#') {
					if(map[x][y + dist] == '*') {
						map[x][y + dist] = '.';
						break;
					}
					dist++;
				}
				break;
		}
	}
}
