class Solution {
    //Dynamic programming.
    //Use OPT[n] refers to the maximum value of subarraies we can get from first n elements (must include nums[n]).
    //OPT[n+1] = Max(OPT[n], 0) + nums[i]. 0 -- Cuz we can decide to abandon the previous value.
    public int maxSubArray(int[] nums) {
        int biggest = Integer.MIN_VALUE;
        //This value stands for the OPT[n-1]
        int previous= 0;
        
        for(int i = 0; i < nums.length; i++){
            previous = Math.max(previous, 0) + nums[i];
            biggest = Math.max(biggest, previous);
        }
        
        return biggest;
    }
}