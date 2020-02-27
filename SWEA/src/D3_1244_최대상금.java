import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class D3_1244_최대상금 {
    static int[] arr;
    static int count;
    static int max;
    static int cnt = 0;
    static int maxNum;
    static int flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
         
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            char[] temp = st.nextToken().toCharArray();
            count = Integer.parseInt(st.nextToken());
             
            arr = new int[temp.length];
            for(int i = 0; i < temp.length; i++)
                arr[i] = temp[i] - 48;
             
            int[] tmpArr = arr.clone();
            maxNum = getMax(tmpArr);
             
            max = Integer.MIN_VALUE;
            flag = 0;
            perm(arr.length,0);
            System.out.println("#" + tc + " " + max);
        }
         
    }
     
    public static int getMax(int[] arr2) {
        Arrays.sort(arr2);
        int num = 0;
        int dec = 1;
        for(int i = 0; i < arr2.length; i++) {
            num += arr2[i] * dec;
            dec *= 10;
            if(i == 0 && arr2[i] == 0)
                num *= 10;
        }
        return num;
    }
     
    public static void perm(int r, int k) {
        if(k > count || flag == 1) {
            return;
        } else {
            for(int i = k; i < arr.length; i++) { 
                swap(k, i);
                if(i != k)
                    cnt++;
                 
                if (cnt < count && makeNum() == maxNum) {
                    if(!hasPair() && (count - cnt)%2 != 0) {
                        swap(arr.length - 1, arr.length - 2);
                    }
                    max = makeNum();
                    flag = 1;
                } else if(cnt == count) {
                    if(makeNum() > max)
                        max = makeNum();
                }
                 
                perm(r, k + 1);
                 
                swap(k, i);
                if(i != k)
                    cnt--;
            }
        }
    }
     
    public static int makeNum() {
        int num = 0;
        int dec = 1;
        for(int j = arr.length - 1; j >= 0; j--) {
            num += arr[j] * dec;
            dec *= 10;
            if(j == 0 && arr[j] == 0)
                num *= 10;
        }
         
        return num;
    }
 
    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    public static boolean hasPair() {
        for(int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(a == arr[j])
                    return true;
            }
        }
        return false;
    }
}
