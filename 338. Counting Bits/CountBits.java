public class Solution {
    /*One trick is: ones[num] = ones[num>>1] + (num & 1)
     The no. of 1's in a given number's binary representation is equal to the half of it plus its right-most 1 or 0.
     */
    public int[] countBits(int num) {
        int[] output = new int[num+1];
        for(int i = 0; i <= num; i++){
            output[i] = output[i>>1] + (i & 1);
        }
        return output;
    }
}
