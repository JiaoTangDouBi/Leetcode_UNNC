public class Solution {
    /*In this problem, I use an array to store the input array and an arraylist for shuffle.
    For example, if the input length of nums is n, we would copy each of items and build an array as well as an arraylist
    In reset step: we simply output the pre-defined array.
    In shuffle step: we use Math.rand() function to generate a random number ([0,arraylist.size())) and extract it from arrayList (O(n)) [1] and put into a new array.
    After this step, the length of the arraylist is n-1. Repate the above step and put the extracted value following previous one in the new defined array until arraylist is empty.
    */
    ArrayList<Integer> al = new ArrayList<Integer>();
    int[] array;
    public Solution(int[] nums) {
        array = new int[nums.length];
        for(int i = 0; i < array.length; i++){
            array[i] = nums[i];
            al.add(nums[i]);
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = new int[array.length];
        int ind = 0;    //keep track of the index in temp.
        while(al.size()>0){
            int size = al.size();
            int random = (int)(Math.random()*size);
            temp[ind] = al.get(random);
            al.remove(random);
            ind++;
        }
        
        for(int num : array)
            al.add(num);
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */