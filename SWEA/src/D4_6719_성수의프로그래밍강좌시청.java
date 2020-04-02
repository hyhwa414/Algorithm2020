import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_6719_성수의프로그래밍강좌시청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			float[] M = new float[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
				M[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < M.length; i++) {
				float min = M[i];
				int minIndex = i;
				for(int j = i; j < M.length; j++) {
					if(min > M[j]) {
						min = M[j];
						minIndex = j;
					}
				}
				
				float temp = M[i];
				M[i] = M[minIndex];
				M[minIndex] = temp;
			}
			
			float score = 0;
			float multi = 2;
			for(int i = 1; i <= K; i++) {
				score += (float)(M[N - i] / multi);
				multi = multi * 2;
			}
			
			System.out.printf("#%d %f", tc, score);
		}
	}
}
