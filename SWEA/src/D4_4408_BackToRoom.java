import java.util.Scanner;

public class D4_4408_BackToRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] dest = new int[N][2];
			int[] corr = new int[200];
			for(int i = 0; i < N; i++) {
				dest[i][0] = sc.nextInt();
				dest[i][1] = sc.nextInt();
			}
			
			int max = 0;
			for(int i = 0; i < N; i++) {
				int start = (dest[i][0] - 1) / 2;
				int end = (dest[i][1] - 1) / 2;
				
				if(start > end) {
					for(int j = end; j <= start; j++) {
						corr[j]++;
						if(max < corr[j])
							max = corr[j];
					}
				} else {
					for(int j = start; j <= end; j++) {
						corr[j]++;
						if(max < corr[j])
							max = corr[j];
					}					
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
