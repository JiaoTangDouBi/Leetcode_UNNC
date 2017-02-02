public class Solution {
    // Since java represents every num with binary number, using a mask from right to left
    // assign the "AND" result of mask and one digit of given num to 31-digit of output.
    public int reverseBits(int n) {
        int b = 1;
        int sum = 0;
        for (int i = 0; i < 32; i++){
            if ((n & b) != 0){
                int k = 1<<(31-i);
                sum = sum ^ k;
            }
            b = b<<1;
        }
        return sum;
    }
}