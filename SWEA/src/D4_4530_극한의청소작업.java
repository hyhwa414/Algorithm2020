import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_4530_극한의청소작업 {
	static long count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			count = 0;
			counting(A);
			long countA = count;
			
			count = 0;
			counting(B);
			long countB = count;
			
			long dist = (A < 0 && B > 0) ? B - A - 1 : B - A;
			long result = dist - count;
			if(A < 0 && B > 0) {
				dist = B - A - 1;
				result = dist - (countA + countB);
			} else {
				result = dist - (long)Math.abs(countA - countB);
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	public static void counting(long stage) {
		if(stage < 0)
			stage = stage * -1;

		String s = Long.toString(stage);
		int n = s.length() - 1;
		if(n == 0) {
			if(stage >= 4)
				count++;
			return;
		}
		
		long index = Long.parseLong(Character.toString(s.charAt(0)));
		if(index < 4) {
			count += ((long)Math.pow(10, n) - (long)Math.pow(9, n)) * index;
		} else if (index > 4){
			count += ((long)Math.pow(10, n) - (long)Math.pow(9, n)) * 4;
			count += ((long)Math.pow(10, n));
			count += ((long)Math.pow(10, n) - (long)Math.pow(9, n)) * (index - 5);
		}
		
		long num = (long)Math.pow(10, n) * index;
		counting(stage - num);
	}
}
