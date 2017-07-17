public class Solution {
    //backtrack
    int count = 0;
    public int countArrangement(int N) {
        backtrack(1, N, new int[N+1]);
        return count;
    }
    
    public void backtrack(int s, int N, int[] used){
        //base-case
        if(s == N){
            for(int i = 1; i < used.length; i++){
                if(used[i] == 0){
                    if(s%i == 0 || i%s == 0)
                        count++;
                    break;
                }
            }
        }
        for(int i = 1; i < used.length; i++){
            if(used[i] == 0 && (s%i == 0 || i%s == 0)){
                used[i] = 1;
                backtrack(s+1,N,used);
                used[i] = 0;
            }
        }
        
    }
}