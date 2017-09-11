class Solution {
    //Use deque structure.
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return new int[0];
        }
        else{
            //using deque to store the index
            Deque<Integer> dq = new LinkedList<>();
            int[] output = new int[nums.length-k+1];
            int iter = 0;
            for(int i = 0; i <= nums.length-1; i++){
                while(!dq.isEmpty() && dq.peekFirst() < i-(k-1)){
                    dq.pollFirst();
                }
                while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                    dq.pollLast();
                }
                dq.add(i);
                if(i >= k-1){
                    output[iter] = nums[dq.getFirst()];
                    iter++;
                }
            }
            return output;
            
        }
    }
}