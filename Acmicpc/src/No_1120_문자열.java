import java.util.Scanner;

public class No_1120_문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int diff = s2.length() - s1.length();
		String newS1;
		int minCount = Integer.MAX_VALUE;
		for(int i = 0; i <= diff; i++) {
			int count = 0;
			newS1 = s2.substring(0, i) + s1 + s2.substring(s2.length() - (diff - i), s2.length());
			
			for(int j = 0; j < s2.length(); j++) {
				if(newS1.charAt(j) != s2.charAt(j))
					count++;
			}
			if(count < minCount)
				minCount = count;
		}
		
		System.out.println(minCount);
	}
}
