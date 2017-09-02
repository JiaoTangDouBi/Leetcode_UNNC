public class Solution {
    //We need to use the special range of a[i] value.
    /*For an index i, we flip a[a[i]-1] = -a[a[i]-1]. 
    So that if a[i] has duplicate, we could reach a[a[i]-1] another time and notice the value is negative.
    */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0){
                output.add(index+1);
            }
            else
                nums[index] = -nums[index];
        }
        return output;
    }
}