public class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        if (prices.length <= 1){
            return 0;
        }
        int min = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i]<min){
                min = prices[i];
            }
            if (max_profit < prices[i] - min){
                max_profit = prices[i] - min;
            }
        }
        return max_profit;
    }
}