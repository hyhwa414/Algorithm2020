import java.util.Arrays;

public class L2_K번째수 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int t = 0; t < commands.length; t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            
            int[] tmp = new int[j - i + 1];
            for(int index = 0; index < tmp.length; index++)
                tmp[index] = array[i + index - 1];
            
            Arrays.sort(tmp);
            answer[t] = tmp[k - 1];
        }
        return answer;
    }
}
