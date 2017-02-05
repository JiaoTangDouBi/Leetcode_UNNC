public class Solution {
    //Check the integer from 0 to num interatively
    //In terms of a given integer, we can use a mask to check the value in each digit of its binary representation
    public int[] countBits(int num) {
        int[] ones = new int[num+1];
        int move = 0;
        int ups = 2-1;
        for (int i = 0; i <= num; i++){
            if (i > ups){
                move++;
                ups = i*2-1;
            }
            int com = 1;
            int one = 0;
            int j = 0;
            do{
                if ((com & i) != 0)
                    one++;
                    com<<=1;
                    j++;
            }while(j<=move);
            ones[i] = one;
        }
        return ones;
    }
}