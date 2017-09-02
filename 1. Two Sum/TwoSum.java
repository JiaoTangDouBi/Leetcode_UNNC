public class Solution {
    //Use the map strcture in which each pair is consisted of 
    //1) the ind of a certain element in nums & (value);
    //2) the value of the num in this index (key).
    //During building the map, we also check whether there exists a solution,
    //that is, for an index i, find whether map contains key whose value equals to target substract nums[i]. if yes return.
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                output[0] = map.get(target-nums[i]);
                output[1] = i;
                return output;
            }
            int key = nums[i];
            //there is no duplication, so we don't need to check whether the key exists or not.
            map.put(key,i);
        }
        return output;
    }
}