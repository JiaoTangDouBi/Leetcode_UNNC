import java.util.Map.Entry;

public class Solution {
    
    //Use a hashmap to store <Character, frequency> pairs, and with the help of buckets, 
    //we can sort those entries in decending order
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char tempChar = s.charAt(i);
            if(freq.containsKey(tempChar)){
                int temp = freq.get(tempChar);
                temp += 1;
                freq.put(tempChar, temp);
            }
            else{
                int temp = 0;
                temp += 1;
                freq.put(tempChar, temp);
            }
        }
        
        List<Character>[] buckets = new List[s.length() + 1];
        for(char key : freq.keySet()){
            if(buckets[freq.get(key)] == null){
                List<Character> temp = new ArrayList<Character>();
                temp.add(key);
                buckets[freq.get(key)] = temp;
            }
            else{
                buckets[freq.get(key)].add(key);
            }
        }
        
        
        StringBuilder output = new StringBuilder();
        for(int i = buckets.length-1; i > 0; i--){
            List<Character> temp = buckets[i];
            if(temp != null){
            for(char c : temp){
                int k = i;
                while(k > 0){
                    output.append(c);
                    k--;
                }
            }
            }
        }
        
        return output.toString();
    }
}