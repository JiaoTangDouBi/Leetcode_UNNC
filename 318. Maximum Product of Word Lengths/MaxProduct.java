public class Solution {
    /*use a num to represent every word.
    Then, if array[i] & array[j] == 0, there would be no overlapping character in words[i] and words[j].
    */
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }
        int[] represent = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                represent[i] = represent[i]|(1<<words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if((represent[i] & represent[j]) == 0) {
                    if (words[i].length() * words[j].length()> max){
                        max = words[i].length() * words[j].length();
                    }
                }  //no overlapping
            }
        }
        return max;
    }
}