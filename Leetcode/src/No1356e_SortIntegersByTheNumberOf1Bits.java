import java.util.Arrays;

public class No1356e_SortIntegersByTheNumberOf1Bits {
	public static void main(String[] args) {
		int[] arr1 = {0,1,2,3,4,5,6,7,8};
		int[] a1 = sortByBits(arr1);
		System.out.println(Arrays.toString(a1));
		
		int[] arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
		int[] a2 = sortByBits(arr2);
		System.out.println(Arrays.toString(a2));
		
		int[] arr3 = {10000, 10000};
		int[] a3 = sortByBits(arr3);
		System.out.println(Arrays.toString(a3));
		
		int[] arr4 = {10, 100, 1000, 10000};
		int[] a4 = sortByBits(arr4);
		System.out.println(Arrays.toString(a4));
	}
	
	public static int[] sortByBits(int[] arr) {
		int[] answer = new int[arr.length];
		
		Arrays.sort(arr);
		String maxBi = Integer.toBinaryString(arr[arr.length - 1]);
		String[] numberOf1Bits = new String[maxBi.length() + 1];
		
		for(int i = 0; i < arr.length; i++) {
			String bi = Integer.toBinaryString(arr[i]);
			int count = 0;
			for(int j = 0; j < bi.length(); j++) {
				if(bi.charAt(j) == '1') count++;
			}
			numberOf1Bits[count] += Integer.toString(arr[i]) + " ";
		}
		int index = 0;
		for(int i = 0; i < numberOf1Bits.length; i++) {
			if(numberOf1Bits[i] ==  null) continue;
			
			String[] s = numberOf1Bits[i].substring(4).split(" ");
			for(int j = 0; j < s.length; j++)
				answer[index++] = Integer.parseInt(s[j]);
		}
		return answer;
	}
}
