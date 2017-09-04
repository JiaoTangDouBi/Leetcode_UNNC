class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int temp = nums[left]+nums[right];
                if(temp == -nums[i]){
                    List<Integer> tempArrayList = new ArrayList<Integer>();
                    tempArrayList.add(nums[i]);
                    tempArrayList.add(nums[left] );
                    tempArrayList.add(nums[right]);
                    output.add(tempArrayList);
                    left++;
                    right--;
                }
                else if(temp < -nums[i]){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        HashSet set = new HashSet(output);
        output.clear();
        output.addAll(set);
        return output;
    }
}