class Solution {
    //pow(x,n) == multiple x itself n times.
    //To speed up, we can use this equation: pow(x,a)*pow(x,a) = pow(x,2a)
    //The Time Complexity will decrease from O(n) to O(logn)
    public double myPow(double x, int n) {
        //base case for recursion.
        if(n == 0)  return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        double temp = myPow(x, n/2);
        temp *= temp;
        if(n % 2 == 0){
            //noting to do
        }
        else{
            if(n<0)
                temp *= 1/x;
            else
                temp *= x;
        }
        return temp;
    }
}