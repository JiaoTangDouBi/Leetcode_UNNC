class Solution {
    //use a min-heap with size k.
    //After checking all the objs in the given array, we output the first element in the heap.
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : nums){
            heap.offer(i);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}