public class Solution {
    /*
    This prefix must be a substring of common prefix of any two given strings.
    Compare common prefix of first two strings and update prefix by comparing it
    with left items iteratively.
    */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        String output = strs[0];
        for (int i = 1; i < strs.length; i++){
            output = commonPrefix(output, strs[i]);
        }
        return output;
    }
    
    public String commonPrefix(String s1, String s2){
        int length = Math.min(s1.length(), s2.length());
        String output = "";
        for (int i = 0; i < length; i++){
            if (s1.charAt(i) == s2.charAt(i)){
                output += s1.charAt(i);
            }
            else{
                break;
            }
        }
        
        return output;
    }
}