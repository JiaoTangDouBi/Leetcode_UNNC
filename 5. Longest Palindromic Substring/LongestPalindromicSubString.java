class Solution {
    //Brute Force
    public String longestPalindrome(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++){
            int left = i;
            int right= i;
            while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1 >= output.length()){
                output = s.substring(left+1, right);
            }
            
            left = i-1;
            right= i;
            while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1 >= output.length()){
                output = s.substring(left+1, right);
            }
        }
        return output;
    }
}