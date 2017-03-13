public class Solution {
    /*check the 0,1 bit from left to right in binary representation.
    We use the hashSet to store different representation within first kth bits.
    For a given position k, our purpose is to find the max xor value for the first k-th bits.
    a^b=c => a^c = b
    */
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;
        for(int i = 31; i >=0; i--){
            int a = 1<<i;
            mask = mask | a;
            HashSet<Integer> h = new HashSet<Integer>();
            for(int num : nums){
                int ele = num&mask;
                h.add(ele);
            }
            
            int temp = max | a;
            for(int num : h){
                int prefix = num^temp;
                if(h.contains(prefix)){
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}