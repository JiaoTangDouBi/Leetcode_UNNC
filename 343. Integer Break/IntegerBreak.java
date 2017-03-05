public class Solution {
    /*We call the product of best partition as bp.
    Use dynamic programming to get the bp from 1 to n.
    For a given number n, we have at most n/2 possible partitions (the first sub-integer is from 1 to n/2) to partite it into two integers n, m and the larget for number n is Max(Max(n*m),Max(bp(n)*bp(m))).
    CAREFUL: bp[1]=0.
    */
    int[] dp;
    public int integerBreak(int n) {
        //3 special cases.
        if(n == 1)  return 0;
        else if (n == 2) return 1;
        else if (n == 3) return 2;
        dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[1] = 1; //product of best partition for 1 is 1.
        dp[2] = 2;
        dp[3] = 3;
        getBp(n);
        return dp[n];
    }
    
    public int getBp(int n){
        if(dp[n] != 0){
            return dp[n];
        }
        else{
            int best = 0;
            if(n%2 == 0){
                best = n*n/4;
            }
            else{
                best = (int)(n/2) * ((int)(n/2)+1);
            }
            for(int i = 1; i <= (int)(n/2); i++){
                best = Math.max(best, getBp(i)*getBp(n-i));
            }
            dp[n] = best;
            return best;
        }
    }
}