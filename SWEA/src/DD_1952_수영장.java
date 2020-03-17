import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DD_1952_수영장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int oneDayPrice = Integer.parseInt(st.nextToken());
			int oneMonthPrice = Integer.parseInt(st.nextToken());
			int threeMonthPrice = Integer.parseInt(st.nextToken());
			int oneYearPrice = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] plan = new int[13];
			for(int i = 1; i < 13; i++) {
				plan[i] = Integer.parseInt(st.nextToken()); 
			}
			
			int[] dp = new int[13];
			int[] minPrice = new int[13];
			for(int i = 1; i < 13; i++) {
				dp[i] = min(oneDayPrice * plan[i], oneMonthPrice);
			}
			
			for(int i = 1; i < 13; i++) {
				minPrice[i] = minPrice[i-1] + dp[i];
				if(i >= 3) {
					minPrice[i] = min(minPrice[i], minPrice[i-3] + threeMonthPrice);
				}
			}
			
			if(minPrice[12] > oneYearPrice)
				minPrice[12] = oneYearPrice;
			
			System.out.println("#" + tc + " " + minPrice[12]);
		}
	}

	public static int min(int x, int y) {
		return (x < y) ? x : y ;
	}
	
	
}
