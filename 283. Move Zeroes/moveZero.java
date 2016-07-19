public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
			int j = i-1;
			int hold = nums[i];
			while (j>=0&&nums[j]==0) {
				nums[j]=hold;
				nums[j+1]=0;
				j--;
			}
		}
    }
}