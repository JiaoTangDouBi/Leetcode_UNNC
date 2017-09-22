class Solution {
    //Solve this problem recursively.
    //For a given array, always retrive and remove the head element and find permutations of the remaining array.
    //insert the head element into every possible for each permutation
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return null;
        else{
            ArrayList<Integer> abc = new ArrayList<Integer>();
            for(int num : nums)
                abc.add(num);
            return backtrack(abc);
        }
        
    }
    
    public List<List<Integer>> backtrack(ArrayList<Integer> nums){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums.size() == 1){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums.get(0));
            output.add(temp);
            return output;
        }
        else{
            int tempVal = nums.get(0);
            nums.remove(0);
            List<List<Integer>> temp = backtrack(nums);
            for(List<Integer> l : temp){
                for(int i = 0; i <= l.size(); i++){
                    List<Integer> tempList = new ArrayList<Integer>(l);
                    tempList.add(i, tempVal);
                    output.add(tempList);
                }
            }
            HashSet set = new HashSet(output);
            output.clear();
            output.addAll(set);
            return output;
        }
    }
}