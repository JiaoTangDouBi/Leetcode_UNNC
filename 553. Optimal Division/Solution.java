public class Solution {
    /*There is a trick of this question: the biggest arrangement must be a[0]/(a[1]/a[2]/.../a[n])
    Because this could be alterd to a[0]*a[2]*a[3]*...*a[n]/a[1].
    Every num is bigger than 2 and a[1] must be a part of denominator, so this formular is smallest denominator
    and the largest numerator.
    */
    public String optimalDivision(int[] nums) {
        String output = String.valueOf(nums[0]);
        if(nums.length>=2){
            output += "/";
            if(nums.length >= 3){
                output+="(";
                output+=String.valueOf(nums[1]);
                for(int i = 2; i < nums.length; i++){
                    output += "/"+String.valueOf(nums[i]);
                }
                output+=")";
            }
            else{
                output+=String.valueOf(nums[1]);
            }
        }
        return output;
    }
}