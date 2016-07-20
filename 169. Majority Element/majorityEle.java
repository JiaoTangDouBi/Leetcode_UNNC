public class Solution {
    public int majorityElement(int[] nums) {
        ArrayList<Integer> element = new ArrayList<Integer>();
    	ArrayList<Integer> frequency=new ArrayList<Integer>();
    	element.add(nums[0]);
    	frequency.add(1);
    	for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < element.size(); j++) {
				if (nums[i] == element.get(j)) {
					frequency.set(j, frequency.get(j)+1);
					break;
				}
				else if(j == element.size()-1){
					element.add(nums[i]);
					frequency.add(1);
				}
			}
		}
    	int max = 0;
    	int index = 0;
    	for (int i = 0; i < frequency.size(); i++) {
			if (frequency.get(i)>max) {
				max = frequency.get(i);
				index = i;
			}
		}
    	return element.get(index);
    }
}