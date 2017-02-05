public class Solution {
    //The contruction process should follow the sequence in which larger h with smaller k precedes to
    //the smaller h with bigger k.
    //For example, if a pair is [p,i], then put it in the (i+1)th position of a new arrayList.
    //Remove them from the queue and do the previous process recursively.
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0){
            return people;
        }
        //sort the given queue by k in ascending order.
        mergeSort(people);
        ArrayList<int[]> arr = new ArrayList<int[]>();
        int visited = 0;
        while(visited != people.length){
            int highest = people[0][0];
            for(int i = 0; i < people.length; i++){
                if (people[i][0] > highest){
                    highest = people[i][0];
                }
            }
            for(int i = 0; i < people.length; i++){
                if(people[i][0] == highest){
                    int[] temp = {people[i][0],people[i][1]};
                    arr.add(people[i][1],temp);
                    people[i][0] = -1;
                    visited += 1;
                }
            }
        }
        for(int i = 0; i < arr.size(); i++){
            people[i][0] = arr.get(i)[0];
            people[i][1] = arr.get(i)[1];
        }
        return people;
    }
    
    public void mergeSort(int[][] nums){
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
				arr2[i-p][0]=nums[i][0];
			    arr2[i-p][1]=nums[i][1];
					
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