
public class L2_프린터 {
	public static void main(String[] args) {
		int[] p1 = {2,1,3,2};
		int l1 = 2; 
		int r1 = solution(p1, l1);
		System.out.println(r1);
		
		int[] p2 = {1,1,9,1,1,1};
		int l2 = 0;
		int r2 = solution(p2, l2);
		System.out.println(r2);
	}
	public static int solution(int[] priorities, int location) {
        char c = 'A';
        char[] ch = new char[priorities.length];
        char[] q = new char[500];
        int front = -1;
        int rear = -1;
        for(int i = 0; i < ch.length; i++){
            ch[i] = c++;
            q[++rear] = ch[i];
        }
        
        front++;
        int preRear = -1;
        String s = "";
        while(front <= rear){
            preRear = rear;
            for(int i = front; i < rear; i++){
                if(priorities[q[i] - 'A'] > priorities[q[front] - 'A']){
                    q[++rear] = q[front];
                    break;
                }
            }
            if(preRear == rear){
                s += q[front];
            }
            front++;
        }
        
        int answer = s.indexOf(ch[location]) + 1;
        return answer;
    }
}
