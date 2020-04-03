import java.util.Scanner;

public class No_1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int newInt = (N%10)*10 + (N/10 + N%10)%10;
		int count = 1;
		while(N != newInt) {
			newInt = (newInt%10)*10 + (newInt/10 + newInt%10)%10;
			System.out.println(newInt);
			count++;
		}
		
		System.out.println(count);
	}
}
