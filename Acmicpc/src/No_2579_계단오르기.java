import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2579_계단오르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int[] score = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1];
		dp[1] = score[1];
		if(N >= 2) dp[2] = (dp[1] + score[2] > score[2]) ? dp[1] + score[2] : score[2];
		
		for(int i = 3; i <= N; i++)
			dp[i] = Math.max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i]);
		
		System.out.println(dp[N]);
	}
}
