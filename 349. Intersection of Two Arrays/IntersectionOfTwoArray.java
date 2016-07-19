public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        nums1 = mergeSort(nums1);
        nums2 = mergeSort(nums2);
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
			for (int j = 0; j < nums1.length; j++) {
				if (nums2[i]<nums1[j]) {
					break;
				}
				else if (nums1[j]==nums2[i]) {
					intersection.add(nums1[j]);
					break;
				}
			}
		}
		HashSet h = new HashSet(intersection);
        intersection.clear();
        intersection.addAll(h);
        int[] inter = new int[intersection.size()];
        for (int i = 0; i < inter.length; i++) {
			inter[i] = intersection.get(i);
		}
        return inter;
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