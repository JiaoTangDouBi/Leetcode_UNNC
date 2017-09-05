class Solution {
    //Bfs but has two end.
    /*We has two sets, one is the begin set and another is end set.
      we alwasy go from the begin set and get a new begin set (layer by layer);
      If there is any directed link from begin set to end set, we are done.
      If not we do the next implementation.
      The end condition is begin and end are both empty, which means we visited every words before and no solution exists. 0
      The reason to use two sets is to improve efficient.
      Like two-end search, we hopefully can reduce the time by half in desired model. For most complex circumstance.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words  = new HashSet<>();
        for(String s : wordList)    words.add(s);
        if(!words.contains(endWord))    return 0;
        HashSet<String> visited= new HashSet<>();    
        HashSet<String> begin  = new HashSet<>();
        HashSet<String> end    = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        int length = 1;
        while(begin.size() != 0 || end.size() != 0){
            //We only implement the set with smaller size.
            if(begin.size() < end.size()){
                HashSet<String> hold = begin;
                begin = end;
                end = hold;
            }
            HashSet<String> temp = new HashSet<>();
            for(String s : begin){
                char[] tempChar = s.toCharArray();
                for(int i = 0; i < tempChar.length; i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char hold = tempChar[i];
                        tempChar[i] = c;
                        String newStr = new String(tempChar);
                        if(end.contains(newStr))
                            return length+1;
                        if(!visited.contains(newStr) && words.contains(newStr)){
                            temp.add(newStr);
                            visited.add(newStr);
                        }
                        tempChar[i] = hold;
                    }
                }
            }
            // System.out.println(temp.size());
            begin = temp;
            length++;
        }
        return 0;
    }
}