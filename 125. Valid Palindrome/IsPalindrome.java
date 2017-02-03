import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Solution {
    /*
    The process of checking whether a string is palindormic is comparing 1st and last element
    2nd and second last element, so on and so forth.
    we merely go through this process from 0 to length/2 since comparing 1st and last is the same as  comparing last and 1st.
    */
    public boolean isPalindrome(String s) {
        //we just consider about alphanumeric characters.
        String alpha = s.replaceAll("[^0-9a-zA-Z]", "");
        alpha = alpha.toLowerCase();
        if (alpha.length() == 0 )
            return true;
        else {
            for (int i = 0; i < (int)(alpha.length()/2); i++){
                if (alpha.charAt(i) != alpha.charAt(alpha.length()-i-1))
                
                    return false;
            }
            return true;
        }
    }
}