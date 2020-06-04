
public class L2_124나라의숫자 {
	public String solution(int n) {
        String answer = "";
        
        int r = 0;
        while(n >= 3){
            r = n % 3;
            n = n / 3;
            if(r == 0) {
                r = 4;
                n = n - 1;
            }
            answer = Integer.toString(r) + answer;
        }
        if(n != 0)
            answer = Integer.toString(n) + answer;
        
        return answer;
    }
}
