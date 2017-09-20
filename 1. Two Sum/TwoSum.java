public class Solution {
    //Use the map strcture in which each pair is consisted of 
    //1) the ind of a certain element in nums & (value);
    //2) the value of the num in this index (key).
    //During building the map, we also check whether there exists a solution,
    //that is, for an index i, find whether map contains key whose value equals to target substract nums[i]. if yes return.
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int remainder = target - num;
            if(map.containsKey(remainder)){
                output[0] = map.get(remainder);
                output[1] = counter;
            }
            else{
                map.put(num,counter);
            }
            counter++;
        }
        return output;
    }
}