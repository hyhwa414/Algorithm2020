
public class L2_쇠막대기 {
	public static void main(String[] args) {
		String a1 = "()(((()())(())()))(())";
		int r1 = solution(a1);
		System.out.println(r1);
	}
	
	public static int solution(String arrangement) {
		int answer = 0;
		int[] stack = new int[500];
		int top = -1;
		
		for(int i = 0; i < arrangement.length(); i++) {
			if(arrangement.charAt(i) == '(') {
				stack[++top] = i;
			} else if(arrangement.charAt(i) == ')') {
				if(stack[top] + 1 == i) {
					top--;
					answer += top + 1;
				} else {
					top--;
					answer += 1;
				}
			}
		}
		
		return answer;
	}
}
