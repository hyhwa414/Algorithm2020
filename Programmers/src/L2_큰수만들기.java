
public class L2_큰수만들기 {
	public static void main(String[] args) {
		String n1 = "398610697353069285";
		int k = 6;
		System.out.println(solution(n1,k));
	}
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		
        int flag = 0;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < sb.length() - 1; j++) {
                if(sb.charAt(j) < sb.charAt(j + 1)){
                    flag = -1;
                    sb = sb.deleteCharAt(j);
                    break;
                }
            }
            if(flag == 0)
                return sb.substring(0, number.length() - k);
        }
        
        return sb.toString();
    }
}
