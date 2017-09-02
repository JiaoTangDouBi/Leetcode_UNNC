import java.math.BigInteger;

class Solution {
    public int myAtoi(String str) {
        int output = 0;
        int k = 0; //Use k to record the location of first non-whilespace character.
        while(k < str.length() && str.charAt(k) == ' '){
            k++;
        }
        if(k == str.length())   return output;
        else{
            boolean pos = true;
            if(str.charAt(k) == '+' || str.charAt(k) == '-'){
                if (str.charAt(k) == '-'){
                    pos = false;
                    if(k+1 == str.length()){
                        return 0;
                    }
                }   
                k++;
            }
            int e = k; //use another integer to record the end location of the first valid sequence.
            while(e<str.length() && (int)str.charAt(e) >= (int)'0' && (int)str.charAt(e) <= (int)'9'){
                e++;
            }
            String intStr = str.substring(k,e);
            if(intStr.length()==0)  return 0;
            if(!pos)    intStr = "-" + intStr;
            try{
                output = Integer.parseInt(intStr);
                return output;
            }
            catch(NumberFormatException e1){
                if (pos)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
        }
    }
}