import java.util.Scanner;

public class No_2588_곱셈 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int A = s.nextInt();
		int B = s.nextInt();
		
		int[] mul = new int[3];
		for(int i = 0; i < 3; i++) {
			mul[i] = B % 10;
			B = B / 10;
		}
		
		int sum = 0;
		int num = 0;
		for(int i = 0; i < 3; i++) {
			num = A * mul[i];
			System.out.println(num);
			sum += (num * Math.pow(10, i));
		}
		
		System.out.println(sum);
	}
}
