class Solution {
    //use a hashmap to store <Character, frequency> pairs.
    //We transfer the given string s to map and check each element in t.
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        
        //build map from s
        for(int i = 0; i < charS.length; i++){
            if(map.containsKey(charS[i])){
                int temp = map.get(charS[i]);
                temp += 1;
                map.put(charS[i], temp);
            }
            else{
                map.put(charS[i], 1);
            }
        }
        
        //check t
        for(int i = 0; i < charT.length; i++){
            //if t has any char that not occurs in s, return false;
            if(!map.containsKey(charT[i]))
                return false;
            else if(map.get(charT[i]) == 0){
                return false;
            }
            else{
                int temp = map.get(charT[i]);
                temp -= 1;
                map.put(charT[i], temp);
            }
        }
        
        return true;
    }
}