import java.util.Arrays;

public class summer_intern_2020_3 {
	public static void main(String[] args) {
		
		// 정확성 통과, 효율성 통과 X
		
		String[] g1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] a1 = solution(g1);
		System.out.println(Arrays.toString(a1));
		
		String[] g2 = {"AA", "AB", "AC", "AA", "AC"};
		int[] a2 = solution(g2);
		System.out.println(Arrays.toString(a2));
		
		String[] g3 = {"XYZ", "XYZ", "XYZ"};
		int[] a3 = solution(g3);
		System.out.println(Arrays.toString(a3));
		
		String[] g4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		int[] a4 = solution(g4);
		System.out.println(Arrays.toString(a4));
		
		String[] g5 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA", "RUBY"};
		int[] a5 = solution(g5);
		System.out.println(Arrays.toString(a5));
	}
	
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		
		String s = "";
		for(int i = 0; i < gems.length; i++) {
			if(!s.contains(gems[i]))
				s += gems[i] + " ";
		}
		
		String[] g = s.split(" ");
		int count = g.length;
		String has = "";
		int firstIdx = 0, lastIdx = gems.length - 1;
		int length = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < gems.length - 1; i++) {
			firstIdx = i;
			has += gems[i] + " ";
			count--;
			for(int j = i; j < gems.length; j++) {
				
				if(!has.contains(gems[j])) {
					has += gems[j] + " ";
					count--;
				}
				if(count == 0) {
					lastIdx = j;
					length = lastIdx - firstIdx;
					if(min > length) {
						min = length;
						answer[0] = firstIdx + 1;
						answer[1] = lastIdx + 1;
					}
					break;
				}
			}
			count = g.length;
			has = "";
		}
		
        return answer;
    }
}
