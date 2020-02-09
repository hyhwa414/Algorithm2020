import java.util.Scanner;

public class NO6603 {
	static int[] stack = new int[15];
	static int top = -1;
	static int[] num;
	static int input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextInt();
		while(input > 0) {
			num = new int[input];
			for(int i = 0; i < input; i++)
				num[i] = sc.nextInt();
			
			for(int i = 0; i <= input - 6; i++) {
				selectNum(i);
			}
			
			System.out.println();
			input = sc.nextInt(); // 그 다음 k 입력 받기
		}
	}

	public static void selectNum(int index) {
		stack[++top] = num[index];
		if(top == 5) {
			print();
			top--;
		} else {
			int flag = 0;
			for(int i = 1; i < input; i++) {
				if(index + i >= input)
					break;
				selectNum(index + i);
			}
			top--;
		}
	}

	public static void print() {
		for(int i = 0; i < 6; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}
