class Solution {
    //use a hashmap to store <Value, Index> pair.
    //Iterate the whole array and it the map contains a key whose value is target-nums[i], return the index pair.
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        int left = 0, right = numbers.length-1;
        while(left - right < 0){
            int total = numbers[left]+numbers[right];
            if(total == target){
                output[0] = left+1;
                output[1] = right+1;
                return output;
            }
            else if(total < target){
                left++;;
            }
            else{
                right--;
            }
        }
        return output;
    }
}