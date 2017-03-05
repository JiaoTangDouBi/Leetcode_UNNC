public class Solution {
    //use a 2-d array to store the binary representations of elements in nums and the size of this array is (nums.length x 32)
    //In terms of a certain digit of n binary representations,
    //the hamming distance for this digit is number of 1s * number of 0s in corresponding digit.
    //Add distances of 32 digits up and we calculate the final result
    public int totalHammingDistance(int[] nums) {
        int[][] binary = new int[nums.length][32];
        for(int i = 0; i < nums.length; i++){
            int mask = 1;
            for(int j = 31; j >= 0; j--){
                if((mask & nums[i]) != 0){
                    binary[i][j] = 1;
                }
                else{
                    binary[i][j] = 0;
                }
                mask <<= 1;
            }
        }
        int distance = 0;
        
        for(int i = 0; i < 32; i ++){
            int nums1=0, nums0 = 0;
            for(int j = 0; j < nums.length; j++){
                if(binary[j][i] == 1)   nums1+=1;
                else nums0+=1;
            }
            distance += nums1*nums0;
        }
        return distance;
    }
}