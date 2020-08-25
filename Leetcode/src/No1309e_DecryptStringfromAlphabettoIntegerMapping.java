
public class No1309e_DecryptStringfromAlphabettoIntegerMapping {
	public static void main(String[] args) {
		String s1 = "13926#417#3920#1";
		System.out.println(freqAlphabets(s1));
	}
	public static String freqAlphabets(String s) {
        String output = "";
        
        String tmp = "";
        int num = -1;
        char c;
        for(int i = s.length() - 1; i>=0; i--) {
        	c = 'a';
        	switch(s.charAt(i)) {
	        	case '#':
	        		tmp = s.substring(i - 2, i + 1);
	        		num = Integer.parseInt(tmp.substring(0,2));
	        		c += (char) (num - 1);
	        		output = c + output;
	        		i = i - 2;
	        		break;
	        	default:
	        		tmp = Character.toString(s.charAt(i));
	        		num = Integer.parseInt(tmp);
	        		c += (char) (num - 1);
	        		output = c + output;
	        		break;
        	}
        }
        
        return output;
    }
}
