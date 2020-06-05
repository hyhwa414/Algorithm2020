
public class No53e_MaximumSubarray {
	public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        int start = 0;
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i - 1] + nums[i] > nums[i]){
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
                start = i;
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
