public class Solution {
    //At first, sort the time list.
    //In terms of the sorted array, we only need to compare them with their adjacent item.
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()*2];
        for(int i = 0; i < timePoints.size(); i++){
            String[] temp = timePoints.get(i).split(":");
            time[i*2] = Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            time[i*2+1] = time[i*2]+24*60;
        }
        mergeSort(time);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < time.length-1; i++){
            if(min > time[i+1]-time[i])
                min=time[i+1]-time[i];
        }
        return min;
    }
    
    public void mergeSort(int[] nums) {
		if(nums.length>1){
			//merge
			int p = nums.length/2;
			int[] arr1 = new int[p];
			int[] arr2 = new int[nums.length-p];
			for (int i = 0; i < p; i++) {
				arr1[i] = nums[i];
				arr1[i] = nums[i];
			}
			for (int i = p; i < nums.length; i++) {
				arr2[i-p]=nums[i];
				arr2[i-p]=nums[i];
				
			}
			mergeSort(arr1);
			mergeSort(arr2);
			//sort
			int m = 0,n=0;
			for (int i = 0; i < nums.length; i++) {
				if (m<arr1.length&&n<arr2.length&&arr1[m]<arr2[n]) {
					nums[i]=arr1[m];
					nums[i]=arr1[m];
					m++;
				}
				else if (m<arr1.length&&n<arr2.length&&arr1[m]>=arr2[n]) {
					nums[i]=arr2[n];
					nums[i]=arr2[n];
					n++;
				}
				else if (m>=arr1.length&&n<=arr2.length) {
					nums[i]=arr2[n];
					nums[i]=arr2[n];
					n++;
				}
				else if (n>=arr2.length&&m<=arr1.length){
					nums[i]=arr1[m];
					nums[i]=arr1[m];
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
