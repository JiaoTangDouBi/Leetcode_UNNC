class Solution {
    //One normal way is to check whether the number (< n) is prime or not one by one.
    /*Another efficient way is to use those integers' relationships.
      For a given number, we find all numbers (<n) has a factor of this and mark them.
      So that for any number i, if there is no mark on it, it would not have any factor among 2 ~ i-1, which means this is prime.
      We only need to do it from 2 to sqrt root of n since the bigger factor has a corresponding factor smaller than it.
    */
    public int countPrimes(int n) {
        int[] mark = new int[n];
        Arrays.fill(mark, 1);
        for(int i = 2; i <= (int)(Math.sqrt(n)); i++){
            int k = 2;
            while(i * k < n){
                mark[i*k] = 0;
                k++;
            }
        }
        int sum = 0;
        for(int i = 2; i < mark.length; i++){
            if(mark[i] == 1)
                sum++;
        }   
        return sum;
    }
}