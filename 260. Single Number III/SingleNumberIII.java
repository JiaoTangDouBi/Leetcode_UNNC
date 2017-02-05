public class Solution {
    /*Represent every element using its binary representation
    Using xor function to get the xor result r of two single nums (a^a = 0)
    Since those two nums are diff, there must exist one digit resulting in 1.
    find the right-most 1 (we say i) in the r and build a mask.
    Using this mask to seperate elements in nums into two groups: 
    one solely contains nums whose i-th digit is 0 and the other group is 1.
    */
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for(int n : nums){
            temp ^= n;
        }
        int mask = 1;
        while((temp % 2) == 0){
            temp>>=1;
            mask<<=1;
        }
        // System.out.println(mask);
        int[] output = {0,0};
        for(int n : nums){
            if ((n ^ mask) > n){
                // System.out.println("1: " + n);
                output[0] ^= n;
            }
            else{
                // System.out.println("2: " + n);
                output[1] ^= n;
            }
        }
        return output;
    }
}