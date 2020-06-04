import java.util.LinkedList;
import java.util.Queue;

public class L2_다리를지나는트럭 {
	public static void main(String[] args) {
		int l1 = 2;
		int w1 = 10;
		int[] t1 = {7,4,5,6};
		System.out.println(solution(l1,w1,t1));
		
		int l2 = 100;
		int w2 = 100;
		int[] t2 = {10};
		System.out.println(solution(l2, w2, t2));
		
		int l3 = 100;
		int w3 = 100;
		int[] t3 = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(l3, w3, t3));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0;
        Queue<Integer> bridge = new LinkedList<Integer>();
        
        for(int i = 0; i < truck_weights.length; i++){
            if(bridge.size() == bridge_length) {
            	w -= bridge.poll();
            }
            if(w + truck_weights[i] <= weight){
                bridge.offer(truck_weights[i]);
                w += truck_weights[i];
            } else {
                bridge.offer(0);
                i--;
            }
            answer++;
        }
        
        answer += bridge_length;
        return answer;
    }
}

