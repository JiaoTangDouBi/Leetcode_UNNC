public class Solution {
    /*Dynamic programming.
    OPT[k,t] -- the max number of different combinations for first k elements to achieve result t.
    OPT[k,t] = OPT[k-1, t-vk] + OPT[k-1, t+vk] (vk is the value of k-th element)
    OPT[0,t] = 0;
    OPT[0,-v0] = 1;
    OPT[0, v0] = 1;
    */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(S<-sum || S>sum) return 0;
        int[][] dp = new int[nums.length][sum*2+1];
        dp[0][nums[0]+sum] += 1;
        dp[0][-nums[0]+sum] += 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < sum*2+1; j++){
                if ((j-nums[i]) <0 && (j + nums[i]) >sum*2)
                    dp[i][j] = 0;
                else if ((j - nums[i]) < 0)
                    dp[i][j] = dp[i-1][j+nums[i]];
                else if ((j + nums[i]) > sum*2)
                    dp[i][j] = dp[i-1][j-nums[i]];
                else
                    dp[i][j] = dp[i-1][j+nums[i]]+dp[i-1][j-nums[i]];
            }
        }
        return dp[nums.length-1][sum+S];
    }
}