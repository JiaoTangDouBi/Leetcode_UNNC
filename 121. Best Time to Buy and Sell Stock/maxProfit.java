class Solution {
    //Dynamic programming. Using OPT[i] refers to the max profit we can get from first i days.
    /*OPT[i] = OPT[i-1] do nothing in day i or buy ticket in day i.
     OPT[i] = price[i] - smallest_value_from_first_i-1_days.
     */
    public int maxProfit(int[] prices) {
        //one exception: no day
        if(prices.length == 0)  return 0;
        int[] OPT = new int[prices.length];
        int smallest = prices[0];
        for(int i = 1; i < prices.length; i++){
            OPT[i] = Math.max(OPT[i-1], prices[i]-smallest);
            smallest = Math.min(smallest, prices[i]);
        }
        return OPT[OPT.length-1];
    }
}
