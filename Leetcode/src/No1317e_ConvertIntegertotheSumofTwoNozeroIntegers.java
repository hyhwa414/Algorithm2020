
public class No1317e_ConvertIntegertotheSumofTwoNozeroIntegers {
	public int[] getNoZeroIntegers(int n) {
        int[] answer = new int[2];
        for(int i = 1; i <= n / 2; i++){
            if(Integer.toString(i).contains("0"))
                continue;
            int j = n - i;
            if(!Integer.toString(j).contains("0")){
                answer[0] = i;
                answer[1] = j;
                break;
            }
        }
        
        return answer;
    }
}
