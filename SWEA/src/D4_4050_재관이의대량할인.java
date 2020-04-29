import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D4_4050_재관이의대량할인 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			Integer[] C = new Integer[N];
			for(int i = 0; i < N; i++)
				C[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(C, Collections.reverseOrder());			
			int count = 0;
			for(int i = 0; i < N; i++) {
				if(i % 3 != 2)
					count += C[i];
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
}
