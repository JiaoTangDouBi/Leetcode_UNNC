public class Solution {
    //binary search. Firstly, get the mid value of 1 to n. If the number of elements whose value is less than or equal to mid is bigger than mid i.e. (No(ele<=mid)> mid), the duplication would be smaller than or equal to mid, otherwise bigger than mid.
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while(left != right){
            int mid =( left+right)/2;
            int[] help = new int[2];
            for(int num : nums){
                if(num <= mid){
                    help[0]++;
                }
                else{
                    help[1]++;
                }
            }
            if(help[0] > mid){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}