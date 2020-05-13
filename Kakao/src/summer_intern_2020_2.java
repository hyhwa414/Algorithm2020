
public class summer_intern_2020_2 {
	static char[] op;
	static String s;
	static String tmp;
	static long max;
	public static void main(String[] args) {
		String e1 = "100-200*300-500+20";
		long r1 = solution(e1);
		System.out.println(r1);
		
		String e2 = "50*6-3*2";
		long r2 = solution(e2);
		System.out.println(r2);
	}
	
	public static long solution(String expression) {
        s = "";
        op = new char[3];
        int idx = 0;
        boolean[] opType = new boolean[3];
        for(int i = 0; i < expression.length(); i++) {
        	switch(expression.charAt(i)) {
	        	case '+':
	        		if(!opType[0]) {
	        			op[idx++] = expression.charAt(i);
	        			opType[0] = true;
	        		}
	        		s += " " + expression.charAt(i) + " "; 
	        		break;
	        	case '-':
	        		if(!opType[1]) {
	        			op[idx++] = expression.charAt(i);
	        			opType[1] = true;
	        		} 
	        		s += " " + expression.charAt(i) + " "; 
	        		break;
	        	case '*':
	        		if(!opType[2]) {
	        			op[idx++] = expression.charAt(i);
	        			opType[2] = true;
	        		} 
	        		s += " " + expression.charAt(i) + " "; 
	        		break;	
	        	default :
	        		s += expression.charAt(i);
	        		break;
        	}
        }
		
        tmp = s;
        max = Long.MIN_VALUE;
		perm(3, 0);
        
        return max;
    }

	public static void perm(int r, int k) {
		if(r == k) {
			s = tmp;
			String[] str = s.split(" ");
			for(int i = 0; i < op.length; i++) {
				for(int j = 0; j < str.length; j++) {
					if(str[j].length() == 1 && str[j].charAt(0) == op[i]) {
						long n1 = Long.parseLong(str[j - 1]);
						long n2 = Long.parseLong(str[j + 1]);
						long n = 0;
						switch(op[i]) {
							case '-':
								n = n1 - n2;
								break;
							case '+':
								n = n1 + n2;
								break;
							case '*':
								n = n1 * n2;
								break;	
						}
						str[j - 1] = "/";
						str[j] = Long.toString(n);
						str[j + 1] = "/";

						s = "";
						for(int a = 0; a < str.length; a++) {
							if(str[a].charAt(0) == '/') continue;
							s += str[a] + " ";
						}
						str = s.split(" ");
						j = 0;
					}
				}
			}
			
			long value = Math.abs(Long.parseLong(str[0]));
			max = Math.max(value, max);
		} else {
			for(int i = k; i < op.length; i++) {
				char temp = op[k];
				op[k] = op[i];
				op[i] = temp;
				
				perm(r, k + 1);
				
				temp = op[k];
				op[k] = op[i];
				op[i] = temp;
			}
		}
	}
}
