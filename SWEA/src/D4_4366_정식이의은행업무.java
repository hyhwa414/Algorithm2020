import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_4366_정식이의은행업무 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			String bi = st.nextToken();
			st = new StringTokenizer(br.readLine(), " ");
			String te = st.nextToken();
			
			String tmp = "";
			int[] nums = new int[bi.length()];
			for(int i = 0; i < bi.length(); i++) {
				if(bi.charAt(i) == '1') {
					tmp = bi.substring(0, i) + "0" + bi.substring(i + 1, bi.length());
				} else {
					tmp = bi.substring(0, i) + "1" + bi.substring(i + 1, bi.length());
				}
				nums[i] = binaryToDec(tmp);
			}
			
			String tmp1 = "";
			String tmp2 = "";
			int result = -1;
			for(int i = 0; i < te.length(); i++) {
				switch(te.charAt(i)) {
					case '0':
						tmp1 = te.substring(0, i) + "1" + te.substring(i + 1, te.length());
						tmp2 = te.substring(0, i) + "2" + te.substring(i + 1, te.length());
						break;
					case '1':
						tmp1 = te.substring(0, i) + "0" + te.substring(i + 1, te.length());
						tmp2 = te.substring(0, i) + "2" + te.substring(i + 1, te.length());
						
						break;
					case '2':
						tmp1 = te.substring(0, i) + "1" + te.substring(i + 1, te.length());
						tmp2 = te.substring(0, i) + "0" + te.substring(i + 1, te.length());
						break;
				}
				
				for(int j = 0; j < nums.length; j++) {
					if(tenaryToDec(tmp1) == nums[j] || tenaryToDec(tmp2) == nums[j]) {
						result = nums[j];
						break;
					}
				}
				
				if(result != -1)
					break;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

	public static int tenaryToDec(String te) {
		int mul = 1;
		int dec = 0;
		
		for(int i = te.length() - 1; i >= 0; i--) {
			dec += (te.charAt(i) - '0') * mul;
			mul *= 3;
		}
		
		return dec;
	}

	public static int binaryToDec(String bi) {
		int mul = 1;
		int dec = 0;
		
		for(int i = bi.length() - 1; i >= 0; i--) {
			dec += (bi.charAt(i) - '0') * mul;
			mul *= 2;
		}
		
		return dec;
	}
}
