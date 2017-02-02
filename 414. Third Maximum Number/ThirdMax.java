public class Solution {
    public int thirdMax(int[] nums) {
        //check number one by one
        int first = nums[0], second = nums[0], third = nums[0];
        for(int i : nums){
            if (i != first && i != second && i != third){
                if (third == first){
                    if (i > first)
                        first = i;
                    else{
                        second = i;
                        third = i;
                    }
                }
                else if (third == second){
                    if (i > first){
                        int temp = first;
                        first = i;
                        second = temp;
                    }
                    else{
                        if (i > second){
                            second = i;
                        }
                        else{
                            third = i;
                        }
                    }
                }
                else {
                    if (i > first){
                        int temp = first;
                        first = i;
                        third = second;
                        second = temp;
                    }
                    else if (i > second){
                        third = second;
                        second = i;
                    }
                    else if (i > third)
                        third = i;
                }
            }
        }
        if (third == first || third == second || first == second)
            return first;
        else
            return third;
    }
}