import java.util.Scanner;

public class No1169_Dice1 {
	
	static int count;
	static int[] arr = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		count = N;
		int op = sc.nextInt();
		
		switch(op) {
			case 1: dice1(0); break;
			case 2: dice2(0, 1); break;
			case 3: dice3(0); break;	
		}
	}
	
	public static void dice1(int index) {
		if(index > count)
			return;
		
		for(int i = 1; i <= 6; ++i) {
			arr[index] = i;
			if(index == count - 1) {
				for(int j = 0; j < count; ++j) {
					System.out.print(arr[j]+" ");
				}
				System.out.println();
			}
			dice1(index + 1);
		}
	}
	
	public static void dice2(int index, int start) {
		if(index > count)
			return;
		
		for(int i = start; i <= 6; ++i) {
			arr[index] = i;
			if(index == count - 1) {
				for(int j = 0; j < count; ++j) {
					System.out.print(arr[j]+" ");
				}
				System.out.println();
			}
			dice2(index + 1, i);
		}
	}
	
	public static void dice3(int index) {
		if(index > count)
			return;
		
		for(int i = 1; i <= 6; ++i) {
			arr[index] = i;
			
			if(findNum(index, i)) continue;
			
			if(index == count - 1) {
				for(int j = 0; j < count; ++j) {
					System.out.print(arr[j]+" ");
				}
				System.out.println();
			}
			dice3(index + 1);
		}
	}
	
	public static boolean findNum(int end, int num) {
		for(int i = 0; i < end; ++i) {
			if(arr[i] == num)
				return true;
		}
		return false;
	}
}
