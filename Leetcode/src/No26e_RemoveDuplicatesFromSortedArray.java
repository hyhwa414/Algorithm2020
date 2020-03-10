import java.util.StringTokenizer;

public class No26e_RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] input1 = {1,1,2};
		int result1 = removeDuplicates(input1);
		for(int i = 0; i < result1; i++)
			System.out.print(input1[i] + " ");
		System.out.println();
		
		int[] input2 = {0,0,1,1,1,2,2,3,3,4};
		int result2 = removeDuplicates(input2);
		for(int i = 0; i < result2; i++)
			System.out.print(input2[i] + " ");
		System.out.println();
		
		int[] input3 = {-1,0,0,0,0,3,3};
		int result3 = removeDuplicates(input3);
		for(int i = 0; i < result3; i++)
			System.out.print(input3[i] + " ");
		System.out.println();
		
		int[] input4 = {-3,-1,0,0,0,3,3};
		int result4 = removeDuplicates(input4);
		for(int i = 0; i < result4; i++)
			System.out.print(input4[i] + " ");
		System.out.println();
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0)
			return 0;
		
        String s = Integer.toString(nums[0]);
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] != nums[i-1])
        		s = s + " " + nums[i];
        }
       
        int index = 0;
        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()) {
        	nums[index++] = Integer.parseInt(st.nextToken());
        }
        
        return index;
    }
}
