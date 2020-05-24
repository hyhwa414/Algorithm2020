
public class L2_타겟넘버 {	
	public static void main(String[] args) {
		int[] num = {1, 1, 1, 1, 1};
		int target = 3;
		int output = solution(num, target);
		System.out.println(output);
	}

	public static int solution(int[] numbers, int target) {		
		int count = 0;

		for(int n = 0; n < 2; n++) {
			int[] stack = new int[100];
			boolean[][] visited = new boolean[numbers.length][2];
			int top = -1;
			stack[++top] = (n == 0) ? numbers[top] : -numbers[top];
			visited[top][n] = true;
			while(top > -1) {
				int w = -1;
				for(int i = 0; i < 2; i++) {
					if(!visited[top + 1][i]) {
						stack[++top] = (i == 0) ? numbers[top] : -numbers[top];
						visited[top][i] = true;
						w = top;
						break;
					}
				}
				if(w == -1) {
					for(int i = 0; i < 2; i++)
						visited[top + 1][i] = false;
					top--;
				} else if(top == numbers.length - 1) {
					int num = 0;
					for(int j = 0; j <= top; j++)
						num += stack[j];
					if(num == target)
						count++;
					
					top--;
				}
			}
		}
		
		int answer = count;
		return answer;
	}

}
