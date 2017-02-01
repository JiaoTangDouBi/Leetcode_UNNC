public class Solution {
    /*
    use bit operation: if a number n appears twice, n xor n is 0.
    */
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor ^=num;
        }
        return xor;
    }
}