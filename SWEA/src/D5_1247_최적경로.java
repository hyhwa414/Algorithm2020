import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247_최적경로 {
	static Location[] xy;
	static int[] csIndex;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			xy = new Location[N+2];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < xy.length; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				xy[i] = new Location(x, y);
			}
			
			csIndex = new int[N];
			for(int i = 0; i < N; i++) {
				csIndex[i] = i+2;
			} // 2, 3, 4, 5, 6
			min = Integer.MAX_VALUE;
			perm(N, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void perm(int r, int k) {
		if(r == k) {
			int d = dist();
			if(d < min) {
				min = d;
			}
		} else {
			for(int i = k; i < csIndex.length; i++) {
				int temp = csIndex[k];
				csIndex[k] = csIndex[i];
				csIndex[i] = temp;
				
				perm(r, k + 1);
				
				temp = csIndex[k];
				csIndex[k] = csIndex[i];
				csIndex[i] = temp;
			}
		}
	}

	public static int dist() {
		int d = 0;
		
		int fromX = xy[0].x;
		int fromY = xy[0].y; // 회사 출발
		int toX = 0;
		int toY = 0;
		for(int i = 0; i < csIndex.length; i++) {
			toX = xy[csIndex[i]].x;
			toY = xy[csIndex[i]].y;
			
			d += (Math.abs(fromX - toX) + Math.abs(fromY - toY));
			
			fromX = xy[csIndex[i]].x;
			fromY = xy[csIndex[i]].y;
		}
		toX = xy[1].x;
		toY = xy[1].y;
		
		d += (Math.abs(fromX - toX) + Math.abs(fromY - toY));
		
		return d;
	}

	public static class Location {
		int x;
		int y;
		
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

