public class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        //initialize all numbers ranged from 2 to n-1 to prime number.
        for(int i = 2; i < n; i++){
            isPrime[i] = 1;
        }
        
        //check whether a number is a prime num or not.
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(isPrime[i]==1 && isPrime(i)){
                //if i is prime, then all the numbers which can be prefectly divided by i is not.
                //we dont need to care about non-prime number, since they r multiple of some primes.
                //start from i*i since previous was counted before.
                for(int j = i*i; j < n; j += i){
                    isPrime[j] = 0;
                }
            }
        }
        
        int sum = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]==1){
                sum+=1;
            }
        }
        return sum;
    }
    
    //check whether a given number n is prime num or not.
    public boolean isPrime(int n){
        for (int i = 2; i <= (int)Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
            i++;
        }
        return true;
    }
}