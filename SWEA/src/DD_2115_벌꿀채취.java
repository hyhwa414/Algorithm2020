import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class DD_2115_벌꿀채취 {
    static int N, M, C;
    static int[][] map;
    static int[] maxmap;
    static int result = 0;
    static int[] num;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for(int t= 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
 
            map = new int[N][N];
            maxmap = new int[N*(N-M+1)];
            result = Integer.MIN_VALUE;
            for(int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            makeMax();
 
            findMax(2, 0, new int[2], 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
     
    private static void findMax(int n, int cur, int[] tmp, int idx) {
        if(n == cur) {
            if((tmp[0]/(N-M+1)) == (tmp[1]/(N-M+1)) && tmp[0]+M-1 >= tmp[1]) {
                return;
            }
             
            int tmpres = maxmap[tmp[0]] + maxmap[tmp[1]];
            if(result < tmpres) {
                result = tmpres;
            }
            return;
        }else {
            for(int i = idx; i < N*(N-M+1); i++) {
                tmp[cur] = i;
                findMax(n, cur+1, tmp, i+1);
            }
        }
    }
     
    private static void makeMax() {
        for(int r = 0; r < N; r++) {//row
            for(int i = 0; i < N-M+1; i++) {//row내의 위치
                int max = Integer.MIN_VALUE;
                for(int j = 1; j < (1<<M); j++) {
                    int tmpc = 0;
                    int tmp = 0;
                    for(int k = 0; k < M ; k++) {
                        if((j & (1 << k)) > 0) {
                            tmp += map[r][i+k]* map[r][i+k];
                            tmpc += map[r][i+k];
                        }
                    }
                    if(tmpc <= C){
                        if(max < tmp) {
                            max = tmp;
                        }
                    }
                }
                maxmap[r*(N-M+1) + i] = max;
            }
        }   
    }
}