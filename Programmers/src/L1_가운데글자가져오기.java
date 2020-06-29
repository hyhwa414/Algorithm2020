
public class L1_가운데글자가져오기 {
	public String solution(String s) {
        String answer = "";
        
        int index = 0;
        if(s.length() % 2 == 0){ // 짝수라면
            index = s.length() / 2;
            answer = s.substring(index - 1, index + 1);
        } else { // 홀수라면
            index = s.length() / 2;
            answer = s.substring(index, index + 1);
        }
        return answer;
    }
}
