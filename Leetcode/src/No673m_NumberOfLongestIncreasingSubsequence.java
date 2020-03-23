
public class No673m_NumberOfLongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] input1 = {1,3,5,4,7};
		int output1 = findNumberOfLIS(input1);
		System.out.println(output1);
		
		int[] input2 = {2,2,2,2,2};
		int output2 = findNumberOfLIS(input2);
		System.out.println(output2);
		
		int[] input3 = {1,2,4,3,5,4,7,2};
		int output3 = findNumberOfLIS(input3);
		System.out.println(output3);
		
		int[] input4 = {1,3,2};
		int output4 = findNumberOfLIS(input4);
		System.out.println(output4);
		
		int[] input5 = {1,1,1,2,2,2,3,3,3};
		int output5 = findNumberOfLIS(input5);
		System.out.println(output5);
	}
	
	public static int findNumberOfLIS(int[] nums) {
		if(nums.length == 0 || nums.length == 1)
			return nums.length;
		
		int[] dp = new int[nums.length];
		int[] c = new int[nums.length];
		int max = Integer.MIN_VALUE;
		
		dp[0] = 1;
		c[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			c[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && dp[j] >= dp[i]) {
					dp[i] = dp[j] + 1;
					c[i] = c[j];
				} else if(nums[j] < nums[i] && dp[j] + 1 == dp[i]){
					c[i] += c[j];
				}
			}
			
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		int count = 0;
		for(int i = 0; i < dp.length; i++) {
			if(dp[i] == max)
				count += c[i];
		}
		
		return count;
	}
}
