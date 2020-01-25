
public class No13e_RomanToInteger {
	public static void main(String[] args) {
		String str = "MCDLXXVI";
		
		int answer = romanToInt(str);
		
		System.out.println(answer);
	}
	
	public static int romanToInt(String s) {
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	switch(s.charAt(i)) {
        		case 'I':
        			if((i != s.length()-1) && s.charAt(i+1) == 'V') {
        				result += 4;
        				i++;
        			}
        			else if ((i != s.length()-1) && s.charAt(i+1) == 'X') {
        				result += 9;
        				i++;
        			} else {
        				result += 1;
        			}
        			break;
        		case 'V':
        			result += 5;
        			break;
        		case 'X':
        			if((i != s.length()-1) && s.charAt(i+1) == 'L') {
        				result += 40;
        				i++;
        			} else if ((i != s.length()-1) && s.charAt(i+1) == 'C') {
        				result += 90;
        				i++;
        			} else {
        				result += 10;
        			}
        			break;
        		case 'L':
        			result += 50;
        			break;
        		case 'C':
        			if ((i != s.length()-1) && s.charAt(i+1) == 'D') {
        				result += 400;
        				i++;
        			} else if ((i != s.length()-1) && s.charAt(i+1) == 'M') {
        				result += 900;
        				i++;
        			} else {
        				result += 100;
        			}
        			break;
        		case 'D':
        			result += 500;
        			break;
        		case 'M':
        			result += 1000;
        			break;
        		default:
        			break;
        	}
        }
        
    	return result;
    }
}
