class Solution {
    //Dynamic programming
    //OPT[i] refers to whether the substring of s from 1 to i can be segmented successfully or not.
    //OPT[i] = 1 means it can be segmented, and OPT[i] = 0 means it cannot.
    //OPT[i] = max(OPT[j])[0<= j < i, s(i,j) is in dict]
    //Time complexity is O(n^2)
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return false;   //Because only non-empty strings are in wordDict
        HashSet set = new HashSet(wordDict);
        int[] OPT = new int[s.length()+1];
        OPT[0] = 1;
        for(int i = 1; i < OPT.length; i++){
            for(int j = 0; j < i; j++){
                if(set.contains(s.substring(j,i))){
                    OPT[i] = Math.max(OPT[i], OPT[j]);
                }
            }
        }
        if(OPT[OPT.length-1] == 1)  return true;
        else    return false;
    }
}