import java.util.Scanner;

public class NO4344 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int C = s.nextInt();
		for(int i = 0; i < C; i++) {
			int num = s.nextInt();
			int[] score = new int[num];
			int sum = 0;
			for(int j = 0; j < num; j++) {
				score[j] = s.nextInt();
				sum += score[j];
			}
			
			int avg = sum / num;
			int count = 0;
			for(int j = 0; j < num ; j++) {
				if(score[j] > avg)
					count++;
			}
			
			double percentage = (double)count / (double)num * 100;
			System.out.printf("%.3f", percentage);
			System.out.print("%\n");
		}
	}
}
