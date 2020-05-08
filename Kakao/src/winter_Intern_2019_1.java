
public class winter_Intern_2019_1 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		int answer = solution(board, moves);
		System.out.println(answer);
	}
	
	public static int solution(int[][] board, int[] moves) {
		int[] stack = new int[moves.length];
		int top = -1;
		int answer = 0;
		
		for(int i = 0; i < moves.length; i++) {
			int num = moves[i] - 1;
			
			for(int y = 0; y < board.length; y++) {
				if(board[y][num] != 0) {
					stack[++top] = board[y][num];
					board[y][num] = 0;
					
					if(top >= 1 && stack[top] == stack[top - 1]) {
						top -= 2;
						answer += 2;
					}
					break;
				} 
			}
		}
		
        return answer;
    }
}
