public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        /*Add nums.length to nums[i] in nums if we have seen vaule of i before.
        In detail, for every element e in nums, 
        if e<= nums.length then check whether nums[nums[e]] is bigger than nums.length or not
            If yes, it means we have seen it before and we add it to output list.
            If no, it means this is the first time we see it and we add nums[nums[e]] by nums.length.
        if e> nums.length, then check whether nums[nums[e-nums.length]] is bigger than nums.lengh or not
        */
        int[] help = new int[nums.length];
        List<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i]-1;
            if(nums[i] > nums.length){
                temp -= nums.length;
            }
            //check whether nums[temp] is visited or not;
            if(nums[temp] > nums.length){
                output.add(temp+1);
            }
            else{
                nums[temp] += nums.length;
            }
        }
        return output;
    }
}