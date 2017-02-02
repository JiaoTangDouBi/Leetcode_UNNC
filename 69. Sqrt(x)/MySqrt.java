public class Solution {
    //Newton method
    public int mySqrt(int x) {
        double ans = x, ansPre = x;
        do{
            ansPre = ans;
            ans = (ansPre + x/ansPre)/2;
        }while(Math.abs(ans-ansPre) > 0.001);
        return (int)ans;
    }
}