class Solution {
    //First seek whether there exists at least one target value in array. O(logn)
    //Then check the both side sub-array besides this index.
    //For the left sub-array, we want to check the left-most index in which value is equal to target.
    //For the right sub-array, we want to check the right-most index in which value is equal to target.
    public int[] searchRange(int[] nums, int target) {
        int[] output = {-1,-1};
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }
            else if (nums[mid] == target){
                output[0] = helpLeft(left, mid, nums, target);
                output[1] = helpRight(mid, right, nums, target);
                return output;
            }
            else
                right = mid-1;
        }
        return output;
    }
    
    public int helpLeft(int left, int right, int[] nums, int target){
        int output = right;
        
        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }
            else if (nums[mid] == target){
                right = mid;
                output = mid;
            }
            else
                right = mid;
        }
        if(nums[left] == target)
            output = left;
        return output;
    }
    public int helpRight(int left, int right, int[] nums, int target){
        int output = left;
        
        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }
            else if (nums[mid] == target){
                left = mid+1;
                output = mid;
            }
            else
                right = mid;
        }
        if(nums[right] == target)
            output = right;
        return output;
    }
}