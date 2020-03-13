import java.util.Arrays;

public class FHSL_BruteForce_L2_카펫 {
	public static void main(String[] args) {
		int[] result1 = solution(10,2);
		System.out.println(Arrays.toString(result1));
		
		int[] result2 = solution(8,1);
		System.out.println(Arrays.toString(result2));
		
		int[] result3 = solution(24,24);
		System.out.println(Arrays.toString(result3));
	}
	
	public static int[] solution(int brown, int red) {
        int carpet = brown + red;
        int a = 0, b = 0;
        for(int i = 2; i <= carpet/2; i++) {
        	if(carpet % i == 0) {
        		a = carpet / i;
        		b = i;
        		
        		int brownCount = (a + b - 2) * 2;
        		if( brownCount == brown)
        			break;
        	}
        }
        
        int[] answer = {a, b};
        
        return answer;
    }
}
