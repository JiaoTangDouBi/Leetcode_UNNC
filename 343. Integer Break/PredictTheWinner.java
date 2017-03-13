public class Solution {
    /*MinMax problem and solved by Dynamic programming.
    Brief explanation of MinMax: We can assume there is only one player: while the odd round is finding the max profit, the even round is finding the min profit.
    Based on this: the dynamic equation is:
    Odd round: OPT[i,j] = Max(opt[i+1,j]+nums[i], opt[i,j-1]+nums[j]) (select one num)
    Even round:OPT[i,j] = Min(opt[i+1,j], opt[i,j-1]) (cannot select any num)
    The base case is also need to be splited into two cases:
    The final round is player2: OPT[i,i] = 0;
    The final round is player1: OPT[i,i] = num[i] (only one choice)
    */
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int sum = 0;
        for(int num : nums)
            sum += num;
        if (nums.length%2 == 0){
            for(int i = 0; i < nums.length; i++){
                dp[i][i] = 0;
            }
        }
        else{
            for(int i = 0; i < nums.length; i++){
                dp[i][i] = nums[i];
            }
        }
        int count = nums.length;  //use a count to determine who is playing in current round
        for(int s = 1; s < nums.length; s++){
            count -= 1;
            for(int i = 0; i < nums.length-s; i++){
                int j = i+s;
                if (count % 2 == 0){        //player2's round
                    int firstChoice = 0, secondChoice = 0;
                    if (j-1 >= 0)
                        firstChoice = dp[i][j-1];
                    if (i+1 <= nums.length-1)
                        secondChoice= dp[i+1][j];
                    dp[i][j] = Math.min(firstChoice, secondChoice);
                }
                else{                       //player1's round
                    int firstChoice = nums[j], secondChoice = nums[i];
                    if (j-1 >= 0)
                        firstChoice += dp[i][j-1];
                    if (i+1 <= nums.length-1)
                        secondChoice += dp[i+1][j];
                    dp[i][j] = Math.max(firstChoice, secondChoice);
                }
            }
        }
        // System.out.println(dp[0][nums.length-1]);
        if ((double)(dp[0][nums.length-1]) >= (double)((double)sum/2))
            return true;
        else
            return false;
    }
}