import java.util.Scanner;

public class D2_2007_패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < T; i++) {
			int patternLength = 0;
			StringBuilder input = new StringBuilder(sc.nextLine());
			
			StringBuilder pattern = new StringBuilder(input.substring(0, 1)); // 첫문자 대입
			input.delete(0, 1);
			
			int returnPoint = input.indexOf(pattern.toString());
			pattern.append(input.substring(0, returnPoint));
			input.delete(0, returnPoint);
			
			while(true) {
				// 문제에 오류가 있음 cocoa 같은 테스트케이스는 co를 패턴으로 인식하기 때문에 fail이 떠야함
				if(input.substring(0, pattern.length()).equals(pattern.toString())) {
					patternLength = pattern.length();
					break;
				} else {
					returnPoint = input.indexOf(pattern.toString());
					pattern.append(input.substring(0, returnPoint));
					input.delete(0, returnPoint);
				}
			}
			
			System.out.println("#"+(i+1)+" "+patternLength);
		}
	}
}
