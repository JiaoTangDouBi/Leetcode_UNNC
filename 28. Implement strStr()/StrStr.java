public class Solution {
    //compare the content of needle with haystack's substrings iteratively.
    public int strStr(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }
        for (int i = 0; i <= haystack.length()-needle.length(); i++){
            String temp = haystack.substring(i, i+needle.length());
            if(temp.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}