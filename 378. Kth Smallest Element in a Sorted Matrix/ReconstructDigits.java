public class Solution {
    /*We find the num whose english name has at least one unique word: for example tWo has "W".
    */
    public String originalDigits(String s) {
        int[] storage = new int[10];
        //first round
        //for tWo
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ('w'))
                storage[2]++;
            if(s.charAt(i) == ('z'))
                storage[0]++;
            if(s.charAt(i) == ('u'))
                storage[4]++;
            if(s.charAt(i) == ('g'))
                storage[8]++;
            if(s.charAt(i) == ('x'))
                storage[6]++;
            if(s.charAt(i) == ('r') )
                storage[3]++;
            if(s.charAt(i) == ('o') )
                storage[1]++;
            if(s.charAt(i) == ('f') )
                storage[5]++;
            if(s.charAt(i) == ('s') )
                storage[7]++;
            if(s.charAt(i) == ('i') )
                storage[9]++;
        }
        storage[1] = storage[1] - storage[0]-storage[2]-storage[4];
        storage[3] = storage[3] - storage[0]-storage[4];
        storage[5] = storage[5] - storage[4];
        storage[7] = storage[7] - storage[6];
        storage[9] = storage[9] - storage[5]-storage[6]-storage[8];
        String put = "";
        for(int i = 0; i < storage.length; i++){
            String temp = String.valueOf(i);
            for(int j = 1; j <= storage[i]; j++)
                put += temp;
        }
        return put;
    }
}