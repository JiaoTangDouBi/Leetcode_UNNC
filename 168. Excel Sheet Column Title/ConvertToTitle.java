public class Solution {
    //recursion, in each stage, there r 2 different part:
    //one is the result of current digit,
    //one is the result of left digits (0 or more).
    //if n <= 26, then the current digit is the most significant digit, string add it in the left-most place,
    //else run the function again in which the parameter is the outcome of n/26 and current digit is the remainder.
    //After finishing the function for left parameters, append the remainder at the tail of left result.
    public String convertToTitle(int n) {
        String output = "";
        if(n <= 26){
            char current = (char)(n+'A'-1);
            output += String.valueOf(current);
        }
        else{
            int div = n/26;
            int rem = n%26;
            if(rem == 0){
                div -= 1;
                rem = 26;
            }
            output += convertToTitle(div);
            output += convertToTitle(rem);
        }
        
        return output;
    }
}