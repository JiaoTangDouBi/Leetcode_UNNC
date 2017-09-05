class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : nums){
            arr.add(num);
        }
        return subsetsHelp(arr);
    }
    
    public List<List<Integer>> subsetsHelp(ArrayList<Integer> arr){
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(arr.size() == 0){
            List<Integer> tempList = new ArrayList<Integer>();
            output.add(tempList);
            return output;
        }
        int temp = arr.get(0);
        arr.remove(0);
        List<List<Integer>> tempList = subsetsHelp(arr);
        for(List<Integer> tempTempList : tempList){
            List<Integer> help = new ArrayList<>();
            
            help.add(temp);
            for(int i : tempTempList)   help.add(i);
            
            output.add(help);
            output.add(tempTempList);
            
        }
        
        
        output.add(arr);
        HashSet set = new HashSet(output);
        output.clear();
        output.addAll(set);
        return output;

    }
}