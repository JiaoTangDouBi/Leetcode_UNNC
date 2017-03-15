public class Solution {
    /*brute force search: Use dp[k][n] store all the eligible lists whose size is k and sum is n.
    for all possible nums: dp[k][n] = dp[k-1][n-value(num)]
    Because there is no duplication in every list, the number use in dp[k-1][n] must bigger than value given in dp[k][n]
    */
    List<List<Integer>>[][] dp;
    public List<List<Integer>> combinationSum3(int k, int n) {
        return help(k,n,1);
    }
    
    public List<List<Integer>> help(int k, int n, int start){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(k == 1){
            if(start <= n && n < 10){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(n);
                output.add(temp);
            }
            return output;
        }
        else{
            for(int i = start; i < 9; i++){
                int nextStart = i + 1;
                int nextN = n - i;
                List<List<Integer>> temp = help(k-1, nextN, nextStart);
                for(List<Integer> item: temp){
                    item.add(0,i);
                    output.add(item);
                }
            }
            return output;
        }
    }
}