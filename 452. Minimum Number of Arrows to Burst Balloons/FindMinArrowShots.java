public class Solution {
    /*sort the balloon items by their Xend in ascending order.
    Iterating the sorted array and find the item with left-most end point. All we need to do is shooting an arrow in this point,
    and such that any balloon go across this point will be brusted as well. Continue doing this until every item in this array is brusted.
    */
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        mergeSort(points);
        int arrow = 0;
        for(int i = 0; i < points.length; i++){
            arrow+= 1;
            int hold = points[i][1];
            while (i < points.length && points[i][0] <= hold) i++;
            i--;
        }
        return arrow;
    }
    
    public static void mergeSort(int[][] nums){
		if(nums.length>1){
			//merge
			int p = nums.length/2;
			int[][] arr1 = new int[p][2];
			int[][] arr2 = new int[nums.length-p][2];
			for (int i = 0; i < p; i++) {
				arr1[i][0] = nums[i][0];
				arr1[i][1] = nums[i][1];
			}
			for (int i = p; i < nums.length; i++) {
				arr2[i-p][0]=nums[i][0] ;
				arr2[i-p][1]=nums[i][1] ;
				
			}
			mergeSort(arr1);
			mergeSort(arr2);
			//sort
			int m = 0,n=0;
			for (int i = 0; i < nums.length; i++) {
				if (m<arr1.length&&n<arr2.length&&arr1[m][1]<arr2[n][1]) {
					nums[i][0]=arr1[m][0];
					nums[i][1]=arr1[m][1];
					m++;
				}
				else if (m<arr1.length&&n<arr2.length&&arr1[m][1]>=arr2[n][1]) {
					nums[i][0]=arr2[n][0];
					nums[i][1]=arr2[n][1];
					n++;
				}
				else if (m>=arr1.length&&n<=arr2.length) {
					nums[i][0]=arr2[n][0];
					nums[i][1]=arr2[n][1];
					n++;
				}
				else if (n>=arr2.length&&m<=arr1.length){
					nums[i][0]=arr1[m][0];
					nums[i][1]=arr1[m][1];
					m++;
				}
			}
			return;
		}
		else {
			return;
		}
	}
}