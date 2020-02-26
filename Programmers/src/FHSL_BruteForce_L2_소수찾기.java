import java.util.StringTokenizer;

public class FHSL_BruteForce_L2_소수찾기 {
	public static char[] arr;
	public static char[] trr;
	public static StringBuilder sb;
	public static int answer;
	
	public static void main(String[] args) {
		String input1 = "17";
		int result1 = solution(input1);
		System.out.println("***" + result1);
		
		String input2 = "011";
		int result2 = solution(input2);
		System.out.println("***" + result2);
	}
	
	public static int solution(String numbers) {
        answer = 0;
        arr = new char[numbers.length()];
        trr = new char[numbers.length()];
        sb = new StringBuilder("");
        
        for(int i = 0; i < numbers.length(); i++)
        	arr[i] = numbers.charAt(i);
        
        for(int i = 1; i <= numbers.length(); i++)
        	perm(i, 0);
        
        
        return answer;
    }

	public static void perm(int r, int k) {
		if(r == k) {
			int num = Integer.parseInt(new String(arr), 0, r, 10);
			if(isPrime(num)) {
				if(!isOverlapped(num)) {
					System.out.println(num);
					answer++;
				}
			}
		} else {
			for(int i = 0; i < arr.length; i++) {				
				char temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				
				perm(r, k + 1);
				
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
		
	}

	public static boolean isOverlapped(int num) {
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		while(st.hasMoreTokens()) {
			if(Integer.parseInt(st.nextToken()) == num) {
				return true;
			}
		}
		sb.append(Integer.toString(num) + " ");
		return false;
	}

	public static boolean isPrime(int num) {
		if(num == 1 || num == 0)
			return false;
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
