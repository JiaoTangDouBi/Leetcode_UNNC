public class Solution {
    //Dynamic programming: OPT[i,j] - The longest length of palindromic substring of s.substring(i,j)
    //If s[i] == s[j], OPT[i,j] = OPT[i+1,j-1]+2
    //else,OPT[i,j] = Max(OPT[i+1,j], OPT[i, j-1])
    //Time complexity O(n^2)
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if (length == 0)    return 0;
        int[][] maxLen = new int[length][length];
        for(int i = 0; i < length; i++){
            maxLen[i][i] = 1;
        }
        for (int o = 1; o < length; o++){
            for(int i = 0; i < length-o; i++){
                int j = i + o;
                //s[i] == s[j]
                if(s.charAt(i) == s.charAt(j) ){
                    // System.out.println("i = " + i + "j = " + j);
                    maxLen[i][j] = maxLen[i+1][j-1]+2;
                }
                //s[i] != s[j]
                else{
                    maxLen[i][j] = Math.max(maxLen[i+1][j], maxLen[i][j-1] );
                }
            }
        }
        
        return maxLen[0][length-1];
    }
}