public class Solution {
    public void rotate(int[] nums, int k) {
        //first way
        /*
        Build a new array whose ith element is same as i+k in nums, and so on so forth.
        if i+k >= nums.length, ith element in new array refers to i+k-nums.length-th element
        */
        // int[] help = new int[nums.length];
        // while(k>=nums.length){
        //     k -= nums.length;
        // }
        // for (int i = nums.length-k; i < nums.length; i++){
        //     help[i-(nums.length-k)] = nums[i];
        // }
        // for (int i = 0; i < nums.length-k; i++){
        //     help[i+k] = nums[i];
        // }
        // for (int i = 0; i < nums.length; i++){
        //     nums[i] = help[i];
        // }
        //second way
        /*
        Firstly, Reserve the string so that the first k elements r the same as desired output instead of sequence.
        And the left elements r also the same as desired one.
        Reserve (0~k-1) and (k~length-1) respectively.
        */
        while(k >= nums.length){
            k -= nums.length;       
        }
        if(k == 0){
            return;
        }
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k-1);
        reserve(nums,k,nums.length-1);
    }
    public void reserve(int[] nums, int s, int e){
        for(int i = s; i <= (e+s)/2; i++){
            int temp = nums[i];
            nums[i] = nums[e+s-i];
            nums[e+s-i] = temp;
        }
    }
}