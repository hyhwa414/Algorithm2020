import java.util.Scanner;

public class No_9095_123더하기 {
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i = 0; i < tc; i++) {
			int num = sc.nextInt();
			count = 0;
			divide(num);
			System.out.println(count);
		}
	}

	public static void divide(int num) {
		if(num == 0) {
			count++;
			return;
		}
		for(int i = 1; i <= num; i++) {
			if(i > 3)
				break;
			divide(num - i);
		}
//		if(num >= 3) {
//			divide(num - 3);
//			divide(num - 2);
//			divide(num - 1);
//		} else if (num >= 2) {
//			divide(num - 2);
//			divide(num - 1);
//		} else if (num >= 1) {
//			divide(num - 1);
//		} else if (num == 0){
//			count++;
//			return;
//		}
	}
}
