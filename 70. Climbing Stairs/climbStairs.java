import java.math.BigInteger;

public class Solution {
    public int climbStairs(int n) {
        int numberOf2 = n / 2;
        int sum = 0;
        for (int i = 0; i <= numberOf2; i++){
            int j = n - i*2;
            int total = i + j;
            if (j == 0){
                sum += 1;
            }
            else{
                sum += combination(total, j);
            }
        }
        return sum;
    }
    
    public int combination(int total, int num){
        BigInteger Denominator = BigInteger.valueOf(1);
        for (int i = total; i>total-num; i--){
            Denominator = Denominator.multiply(BigInteger.valueOf(i));
        }
        BigInteger numerator =BigInteger.valueOf(1);
        for (int i = num; i>1; i--){
            numerator = numerator.multiply(BigInteger.valueOf(i));
        }
        return (Denominator.divide(numerator)).intValue();
    }
}