import java.util.Arrays;

public class FHSL_BruteForce_L2_숫자야구 {
	public static void main(String[] args) {
		int[][] input1 = {{123,1,1}, {356,1,0}, {327,2,0}, {489,0,1}};
		int result1 = solution(input1);
		System.out.println("result1 : " + result1);
	}
	
	// 세 자리 수, 스트라이크의 수, 볼의 수
	// 숫자는 맞지만, 위치가 틀렸을때는 볼
	// 숫자와 위치가 모두 맞을때는 스트라이크
	public static int solution(int[][] baseball) {
		int answer = 0; // 가능한 답의 개수
		
		for(int i = 111; i <= 999; i++) {
			String s = Integer.toString(i);
			
			// strike 확인
			int strikeCount = 0;
			for(int j = 0; j < baseball.length; j++) {
				String num = Integer.toString(baseball[j][0]);
			}
			// ball 확인
		}
		
		return answer;
	}
}
