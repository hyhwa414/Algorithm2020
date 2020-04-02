import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5607_Professional조합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long p = 1234567891;
			long[] factorial = new long[N + 1];
			factorial[0] = 1;
			factorial[1] = 1;
			for(int i = 2; i <= N; i++)
				factorial[i] = (factorial[i - 1] * i) % p;
			long denominator = (factorial[R] * factorial[N - R]) % p;
			
			long index = p - 2;
			long fermatNum = 1;
			while(index > 0) {
				if(index % 2 == 1) {
					fermatNum *= denominator;
					fermatNum %= p;
				}
				denominator = (denominator * denominator) % p;
				index /= 2;
			}
			long result = ((factorial[N] % p) * (fermatNum % p)) % p;
			System.out.println("#" + tc + " " + result);
		}
	}
}
