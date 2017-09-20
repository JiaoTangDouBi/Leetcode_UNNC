class Solution {
    //Binary Search.
    /*
    First find the smallest number's index
    Then use binary search with corresponding shift (index we found before)
    */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        if (nums.length == 0)   return result;
        //find the index smallest number
        while(right > left){
            int mid = (right+left)-1;
            //if smallest value is in right half array
            if(nums[mid]>nums[right]) left = mid+1;
            //else smallest value is in left half array
            else
                right = mid;
        }
        int rot = left;
        left = 0;
        right = nums.length-1;
        while(left < right){
            int mid = (right + left)/2;
            int realMid = (mid+rot)%nums.length;
            if(nums[realMid] > target)
                right = mid;
            else if (nums[realMid] < target)
                left = mid+1;
            else
                return realMid;
        }
        if(nums[((right+left)/2+rot)%nums.length] == target)
            return ((right+left)/2+rot)%nums.length;
        return result;
    }
}