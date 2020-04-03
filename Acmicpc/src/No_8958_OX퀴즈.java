import java.util.Scanner;

public class No_8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		int N = s.nextInt();
		s.nextLine();
		for(int i = 0; i < N; i++) {
			char[] ch = s.nextLine().toCharArray();
			int score = 0;
			int sum = 0;
			
			for(int j = 0; j < ch.length; j++) {
				if(score == 0 && ch[j] == 'O') { // first O
					score = 1; 
				} else if (score != 0 && ch[j] == 'O') {
					score ++;
				} else {
					score = 0;
				}
				sum += score;
			}
			System.out.println(sum);
		}
	}
}
