
public class No14e_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] input1 = {"flower", "flow", "fligth"};
		String result1 = longestCommonPrefix(input1);
		System.out.println(result1);
		
		String[] input2 = {"dog", "racecar", "car"};
		String result2 = longestCommonPrefix(input2);
		System.out.println(result2);
		
		String[] input3 = {"a"};
		String result3 = longestCommonPrefix(input3);
		System.out.println(result3);
		
		String[] input4 = {"abab", "aba", ""};
		String result4 = longestCommonPrefix(input4);
		System.out.println(result4);
		
		String[] input5 = {"a", "a", "b"};
		String result5 = longestCommonPrefix(input5);
		System.out.println(result5);
		
		String[] input6 = {"c", "c"};
		String result6 = longestCommonPrefix(input6);
		System.out.println(result6);
		
		String[] input7 = {"a", "a", "a"};
		String result7 = longestCommonPrefix(input7);
		System.out.println(result7);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		// 17ms, 39.8MB
		// fail to optimize :-(
		String result = "";
        
        char[][] ch = new char[strs.length][];
        for(int i = 0; i < strs.length; i++)
        	ch[i] = strs[i].toCharArray();
        
        if(strs.length == 1) {
        	result = strs[0];
        } else {
        	int minLength = 0;
	        for(int i = 0; i < ch.length; i++) {
	        	if(i == 0)
	        		minLength = ch[i].length;
	        	else if(ch[i].length < minLength)
	        		minLength = ch[i].length;
	        }
	        
	        int flag = 0;
	        for(int i = 0; i < minLength; i++) {
	        	char c = ch[0][i];
	        	for(int j = 1; j < ch.length; j++) {
	        		if(c != ch[j][i]) {
	        			flag = 1;
	        			break;
	        		} else if (j == ch.length-1 && c == ch[j][i]) {
	        			result += c;
	        		}
	        	}
	        	if(flag == 1)
	        		break;
	        }
        }
        
        
      	return result;
		
    }	
}


// 1차 코드 17ms, 39.8MB 
