public class Solution {
    //greedy algorithm. In this task, we check the character in s in sequence.
    //For a given char, We always tend to find the left-most eligible position in t.
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for(int i = 0; i < t.length(); i++ ){
            if (index == s.length() ){
                return true;
            }
            //O(s+t) //sizes of s and t
            if(t.charAt(i) == s.charAt(index) )
                index++;
        }
        if(index == s.length() ){
            return true;
        }
        else{
            return false;
        }
    }
}