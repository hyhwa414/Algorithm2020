import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1808_지희의고장난계산기 {
	static int[] button;
	static int answer;
	static int X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			button = new int[10];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 10; i++)
				button[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			
			answer = Integer.MAX_VALUE;
			solve(X,0);
			
			if(answer == Integer.MAX_VALUE)
				answer = -1;
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	public static int solve(int x, int cnt) {
		if(isMake(x+"")) {
			if(cnt == 0)
				answer = len(x) + 1;
			return len(x) + 1;
		}
		int result = -1;
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x%i == 0 && isMake(i + "")) {
				int len1 = len(i) + 1;
				int len2 = solve(x / i, cnt + 1);
				
				if(len2 > -1) {
					result = len1 + len2;
					if(result < answer && x == X) {
						answer = result;
					}
				}
			}
		}
		return result;
	}
	public static int len(int x) {
		return (int)Math.log10(x) + 1;
	}
	public static boolean isMake(String x) {
		for(char c : x.toCharArray()) {
			if(button[c-'0'] == 0)
				return false;
		}
		return true;
	}

	
}
