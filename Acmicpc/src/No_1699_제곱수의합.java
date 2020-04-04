import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1699_제곱수의합 {
	static int[] dp;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		dp = new int[N + 1];
		
		rootSum(N);
		
		System.out.println(min);
	}

	public static void rootSum(int k) {
		if(k == 0) {
			if(dp[k] < min)
				min = dp[k];
		} else {
			if(dp[k] >= min)
				return;
			else {
				int root = (int)Math.sqrt(k);
				for(int i = root; i >=1; i--) {
					int num = k - i * i;
					if(dp[num] != 0 && dp[num] < dp[k] + 1)
						return;
					dp[num] = dp[k] + 1;
					rootSum(num);
				}
			}
		}
	}
}
