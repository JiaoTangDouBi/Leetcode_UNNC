public class Solution {
    public int minMoves2(int[] nums) {
        //the least moves among 3 points in the same axis is p(higest)-p(lowest)
        /*shortest
        --------------------p3---------------
                            |        
                            |d1        
                            ⬇ ️        
        -------------------p2----------------
                            ⬆ ️
                            |  d2                        
                            |        
        --------------------p1---------------
        */
        //our task is to find the value of medium and sum them up.
        if(nums.length == 0)
            return 0;
        mergeSort(nums);
        int point = 0;
        int move = 0;
        if (nums.length % 2 != 0){
            point = nums[(nums.length-1)/2];
            for(int num : nums)
                move += Math.abs(num-point);
        }
        else{
            point = (nums[(nums.length-2)/2]+nums[(nums.length)/2])/2;
            for(int num : nums)
                move += Math.abs(num-point);
            int move1 = 0;
            point = point + 1;
            for(int num : nums)
                move1 += Math.abs(num-point);
            move = Math.min(move,move1);
        }
        return move;
    }
    
    public int[] mergeSort(int[] nums){
		if(nums.length>1){
			//merge
			int p = nums.length/2;
			int[] arr1 = new int[p];
			int[] arr2 = new int[nums.length-p];
			for (int i = 0; i < p; i++) {
				arr1[i] = nums[i];
			}
			for (int i = p; i < nums.length; i++) {
				arr2[i-p]=nums[i];
			}
			int[] arr3 = mergeSort(arr1);
			int[] arr4 = mergeSort(arr2);
			//sort
			int m = 0,n=0;
			for (int i = 0; i < nums.length; i++) {
				if (m<arr3.length&&n<arr4.length&&arr3[m]<arr4[n]) {
					nums[i]=arr3[m];
					m++;
				}
				else if (m<arr3.length&&n<arr4.length&&arr3[m]>=arr4[n]) {
					nums[i]=arr4[n];
					n++;
				}
				else if (m>=arr3.length&&n<=arr4.length) {
					nums[i]=arr4[n];
					n++;
				}
				else if (n>=arr4.length&&m<=arr3.length){
					nums[i]=arr3[m];
					m++;
				}
			}
			return nums;
		}
		else {
			return nums;
		}
	}
}