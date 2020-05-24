import java.util.HashMap;

public class L1_완주하지못한선수 {
	public static void main(String[] args) {
		String[] p1 = {"leo", "kiki", "eden"};
		String[] c1 = {"eden", "kiki"};
		String r1 = solution(p1, c1);
		System.out.println(r1);
		
		String[] p2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] c2 = {"josipa", "filipa", "marina", "nikola"};
		String r2 = solution(p2, c2);
		System.out.println(r2);
		
		String[] p3 = {"mislav", "stanko", "mislav", "ana"};
		String[] c3 = {"stanko", "ana", "mislav"};
		String r3 = solution(p3, c3);
		System.out.println(r3);
	}
	
	public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String s : participant)
        	hm.put(s, hm.getOrDefault(s, 0) + 1);
        for(String s : completion)
        	hm.put(s, hm.get(s) - 1);
		
		String answer = "";
		for(String key : hm.keySet()) {
			if(hm.get(key) != 0)
				answer = key;
		}
		
        return answer;
    }
}
