
public class FHSL_DFSBFS_L3_네트워크 {
	static boolean[] visited;
	static int[][] arr;
	public static void main(String[] args) {
		int n1 = 3;
		int[][] coms1 = {{1,1,0}, {1,1,0}, {0,0,1}};
		int sol1 = solution(n1, coms1);
		System.out.println("sol1 : " + sol1);
		
		int n2 = 3;
		int[][] coms2 = {{1,1,0}, {1,1,1}, {0,1,1}};
		int sol2 = solution(n2, coms2);
		System.out.println("sol2 : " + sol2);
		
		int n3 = 4;
		int[][] coms3 = {{1,0,0,1}, {0,1,1,1}, {0,1,1,0}, {1,1,0,1}};
		int sol3 = solution(n3, coms3);
		System.out.println("sol3 : " + sol3);
	}
	public static int solution(int n, int[][] computers) {
		visited = new boolean[computers.length];
		int answer = 0;
		arr = computers;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				answer++;
				dfs(i);
			}
		}
		
        return answer;
    }
	public static void dfs(int index) {
		if(visited[index]) return;
		
		visited[index] = true;
		for(int i = 0; i < arr[index].length; i++) {
			if(arr[index][i] == 1)
				dfs(i);
		}
	}
}
