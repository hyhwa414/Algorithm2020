import java.util.Arrays;

public class L2_숫자야구 {
	public static void main(String[] args) {
		int[][] input1 = {{123,1,1}, {356,1,0}, {327,2,0}, {489,0,1}};
		int result1 = solution(input1);
		System.out.println("result1 : " + result1);
	}
	
	public static int solution(int[][] baseball) {
		int answer = 0;
		
		for(int i = 123; i <= 987; i++) {
			String s = Integer.toString(i);
			
			if(isOverlapped(s) || hasZero(s)) continue;
	
			String flag = "";
			for(int j = 0; j < baseball.length; j++) {
				String num = Integer.toString(baseball[j][0]);
				int strike = 0;
				int ball = 0;
				
				if(num.charAt(0) == s.charAt(0)) {
					strike++;
				} else if(num.charAt(0) == s.charAt(1) || num.charAt(0) == s.charAt(2)) {
					ball++;
				}
				
				if(num.charAt(1) == s.charAt(1)) {
					strike++;
				} else if(num.charAt(1) == s.charAt(0) || num.charAt(1) == s.charAt(2)) {
					ball++;
				}
				
				if(num.charAt(2) == s.charAt(2)) {
					strike++;
				} else if(num.charAt(2) == s.charAt(0) || num.charAt(2) == s.charAt(1)) {
					ball++;
				}
				
				if(strike == baseball[j][1] && ball == baseball[j][2])
					flag += "T";
				else 
					flag += "F";
			}
			if(!flag.contains("F"))
				answer++;
		}
		
		return answer;
	}

	public static boolean hasZero(String s) {
		if(s.charAt(0) == '0' || s.charAt(1) == '0' ||
				s.charAt(2) == '0')
			return true;
		return false;
	}

	public static boolean isOverlapped(String s) {
		if((s.charAt(0) == s.charAt(1)) || 
				(s.charAt(0) == s.charAt(2)) ||
				(s.charAt(1) == s.charAt(2)))
			return true;
		return false;
	}
}
