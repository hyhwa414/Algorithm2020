import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DD_2115_벌꿀채취 {
	static int[][] hz;
	static int[][] sa;
	static int N;
	static int M;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			hz = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					hz[i][j] = Integer.parseInt(st.nextToken());
			}
			getSumArr();
		}
	}

	public static void getSumArr() {
		sa = new int[N-M+1][N-M+1];
		
		for(int i = 0; i < sa.length; i++) {
			for(int j = 0; j < sa[i].length; j++) {
				sa[i][j] = hz[i][j] + hz[i][j+1];
				for(int k = 0; k < M; k++) {
					sa[i][j] += hz[i][j+k];
				}
			}
		}
	}
}
