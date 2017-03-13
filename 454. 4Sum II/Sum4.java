public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map1 = new HashMap();
        HashMap<Integer,Integer> map2 = new HashMap();
        //Build a hashmap containing the products of A elements and B elements. O(n^2)
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int temp = A[i]+B[j];
                if (map1.containsKey(temp)){
                    map1.put(temp, map1.get(temp)+1);
                }
                else{
                    map1.put(temp,1);
                }
            }
        }
        //Build a hashmap containing the products of D elements and C elements. O(n^2)
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int temp = -C[i]-D[j];
                if (map2.containsKey(temp)){
                    map2.put(temp, map2.get(temp)+1);
                }
                else{
                    map2.put(temp,1);
                }
            }
        }
        int output = 0;
        for(int key : map2.keySet()){
            if(map1.containsKey(key)){
                output += map1.get(key)*map2.get(key);
            }
        }
        return output;
    }
}