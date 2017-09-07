class Solution {
    //Iterate the array twice
    //the first time goes from left to right and save the accelerate product from 0 to i to result[i].
    //The second time goest from right to left and save the accelerate product from nums.length-1 to i to result[i].
    //Multiply the output achieved from first and second times and the result is our goal.
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        int product = 1;
        for(int i = 1; i < nums.length; i++){
            product *= nums[i-1];
            output[i] *= product;
        }
        
        product = 1;
        for(int j = nums.length-2; j>=0; j--){
            product *= nums[j+1];
            output[j] *= product;
        }
        
        return output;
    }
}