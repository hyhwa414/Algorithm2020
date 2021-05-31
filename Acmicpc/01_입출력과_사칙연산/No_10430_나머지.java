import java.util.Scanner;

public class No_10430_나머지 {
	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		
		int A = S.nextInt();
		int B = S.nextInt();
		int C = S.nextInt();
		
		/*첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.*/
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);
	}
}
