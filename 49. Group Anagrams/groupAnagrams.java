class Solution {
    /*Sort every string in alphabetical order.
      Apply a hashmap to group anagrams together,
      The structure of hashmap objects is <String, Arraylist>. 
      The second elements record all indices of which the string is same as the first element.
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] helpStrs = new String[strs.length];
        int count = 0;
        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            helpStrs[count] = new String(temp);
            count++;
        }
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < helpStrs.length; i++){
            if(!map.containsKey(helpStrs[i])){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(helpStrs[i], temp);
            }
            else{
                ArrayList<Integer> temp = map.get(helpStrs[i]);
                temp.add(i);
                map.put(helpStrs[i], temp);
            }
        }
        List<List<String>> output = new ArrayList<List<String>>();
        for(String key : map.keySet()){
            ArrayList<Integer> temp = map.get(key);
            List<String> strTemp    = new ArrayList<>();
            for(int i : temp){
                strTemp.add(strs[i]);
            }
            output.add(strTemp);
        }
        return output;
    }
}