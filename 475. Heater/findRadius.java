public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        //apply greedy algorithm, every heater is in charge of a set of houses. Assign a 
        //house to a heater if the distance between is smaller than any other heaters.
        mergeSort(houses);
        mergeSort(heaters);
        if(heaters.length == 1){
            return Math.max(Math.abs(heaters[0]-houses[0]), Math.abs(heaters[0]-houses[houses.length-1]));
        }
        else{
            int ind = 0;
            int firstHeater = heaters[ind];
            ind++;
            int secondHeater= heaters[ind];
            int radius = 0;
            for(int i = 0; i < houses.length; i++){
                int firstDis = Math.abs(firstHeater-houses[i]);
                int secondDis = Math.abs(secondHeater-houses[i]);
                if(secondDis>firstDis){
                    radius = Math.max(radius, firstDis);
                }
                else{
                    ind++;
                    if(ind < heaters.length){
                        i--;
                        firstHeater=secondHeater;
                        secondHeater=heaters[ind];
                    }
                    else{
                        radius = Math.max(radius, secondDis);
                        return Math.max(radius, Math.abs(secondHeater-houses[houses.length-1]));
                    }
                }
            }
        return radius;
        }
    }
    
    public void mergeSort(int[] nums){
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
			mergeSort(arr1);
			mergeSort(arr2);
			//sort
			int m = 0,n=0;
			for (int i = 0; i < nums.length; i++) {
				if (m<arr1.length&&n<arr2.length&&arr1[m]<arr2[n]) {
					nums[i]=arr1[m];
					m++;
				}
				else if (m<arr1.length&&n<arr2.length&&arr1[m]>=arr2[n]) {
					nums[i]=arr2[n];
					n++;
				}
				else if (m>=arr1.length&&n<=arr2.length) {
					nums[i]=arr2[n];
					n++;
				}
				else if (n>=arr2.length&&m<=arr1.length){
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