import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class No3m_LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s1 = "abcabcbb";
		int r1 = lengthOfLongestSubstring(s1);
		System.out.println(r1);
		
		String s2 = "bbbbb";
		int r2 = lengthOfLongestSubstring(s2);
		System.out.println(r2);
		
		String s3 = "pwwkew";
		int r3 = lengthOfLongestSubstring(s3);
		System.out.println(r3);
		
		String s4 = "abba";
		int r4 = lengthOfLongestSubstring(s4);
		System.out.println(r4);
		
		String s5 = "wobgrovw";
		int r5 = lengthOfLongestSubstring(s5);
		System.out.println(r5);
	}
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) return 0;
		
		int left = 0;
		int right = 0;
		int length = 0;
		int max = Integer.MIN_VALUE;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
        	if(map.containsKey(s.charAt(i))) { // 중복된 문자
        		left = map.get(s.charAt(i)) + 1;
        		refreshMap(map, left);
        		map.put(s.charAt(i), i);
        		right = i;
        	} else { // 중복되지 않은 문자
         		map.put(s.charAt(i), i);
         		right = i;
        	}
        	
        	length = right - left + 1;
        	max = Math.max(length, max);
        }
        
        return max;
    }
	public static void refreshMap(Map<Character, Integer> map, int left) {
		Set s = map.keySet();
		Iterator it = s.iterator();
		while(it.hasNext()) {
			Character key = (Character)it.next();
			if(map.get(key) < left) {
				map.remove(key);
				s = map.keySet();
				it = s.iterator();
			}
		}
	}
}
