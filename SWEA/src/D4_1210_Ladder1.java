import java.util.Scanner;

public class D4_1210_Ladder1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			int[][] ladder = new int[100][100];
			int row = 0, col = 99;
			
			s.next();
			s.next();
			for(int j = 0; j < 100; j++) {
				String[] input = s.nextLine().split(" ");
				for(int k = 0; k < 100; k++) {
					if(input[k].equals("1")) {
						ladder[j][k] = 1;
					} else if (input[k].equals("2")) {
						ladder[j][k] = 2;
						row = k;
					} else {
						ladder[j][k] = 0;
					}
				}
			}
			
			while(col > 0) {
				ladder[col][row] = 0;
				if(row-1 >= 0 && ladder[col][row-1] == 1) { // left check
					row--;
				} else if (row+1 <= 99 && ladder[col][row+1] == 1) { // right check
					row++;
				} else { // go up
					col--;
				}
			}
			
			System.out.println("#"+(i+1)+" "+row);
			
		}
	}
}
