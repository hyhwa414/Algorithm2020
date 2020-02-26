import java.util.Arrays;

public class FHSL_BruteForce_L1_MockTest {
	public static void main(String[] args) {
		int[] answers1 = {1, 2, 3, 4, 5};
		int[] answer1 = solution(answers1);
		System.out.println(Arrays.toString(answer1));
		
		int[] answers2 = {1, 3, 2, 4, 2};
		int[] answer2 = solution(answers2);
		System.out.println(Arrays.toString(answer2));
		
		int[] answers3 = {3, 1, 1, 2, 5, 4, 1, 4, 3};
		int[] answer3 = solution(answers3);
		System.out.println(Arrays.toString(answer3));
	}
	
	public static int[] solution(int[] answers) {
        int[] count = new int[3];

        int[][] st = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        for(int i = 0; i < 3; i++)
        	count[i] = check(answers, st[i]);
        
        StringBuilder sb = new StringBuilder();
        int max = count[0];
        for(int i = 0; i < 3; i++) {
        	if(max < count[i]) {
        		max = count[i];
        		sb.delete(0, sb.length());
        		sb.append(i+1);
        	} else if(max == count[i]) {
        		sb.append(i+1);
        	} 
        }
        
        int[] answer = new int[sb.length()];
        for(int i = 0; i < sb.length(); i++)
        	answer[i] = sb.charAt(i) - 48;
        
        return answer;
    }

	public static int check(int[] answers, int[] st) {
		int count = 0;
		
		for(int i = 0; i< answers.length; i++) {
			if(answers[i] == st[i%st.length])
				count++;
		}
		
		return count;
	}
}
