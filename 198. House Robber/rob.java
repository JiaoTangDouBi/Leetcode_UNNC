public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        else if (nums.length == 1){
            return nums[0];
        }
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            money[i] = Math.max(money[i-2]+nums[i], money[i-1]);
            // System.out.println("money[" + i + "] = " + money[i]);
        }
        // printArr(money);
        return money[nums.length-1];
    }
    
    public void printArr(int[] nums){
		for (int i = 0; i < nums.length; i++) {
			System.out.print("'"+nums[i]+"',");
		}
	}
}