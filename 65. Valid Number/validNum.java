class Solution {
    /*
      We split the processed string by "e", the maximum amount of split results should no higher than 2.
      Since e can't appear in neither the beginning or end, we add one white spaces to the original string s in both sides.
      For each substring:
      Before judging, we need to trim white spaces in both side.
        we allow "+/-" symbol attending in the first index.
        for the processed string, we will return true when it meet the following formats.
            The string can only have at least one digit character and at most one dot (.).
            
    */
    public boolean isNumber(String s) {
        s = " " + s + " ";
        String[] help = s.split("e");
        if (help.length > 2)
            return false;
        if(help.length == 2){
            if(help[0].charAt(help[0].length()-1) == ' ' || help[1].charAt(0) == ' ')
                return false;
            return validate1(help[0])&&validate2(help[1]);
        }
        else
            return validate1(help[0]);
    }
    
    public boolean validate1(String s){
        int start = 0, end = s.length() - 1;
        
        //trim
        while(start < end && s.charAt(start) == ' ')
            start++;
        while(end >= start && s.charAt(end) == ' ')
            end--;
        
        if (s.charAt(start) == '+' || s.charAt(start) == '-'){
            start += 1;
        }
        
        s = s.substring(start, end+1);
        if(s.length() == 0 || s.equals(".")){
            return false;
        }
        else{
            boolean hasDot = false;
            //verify whether the processed string belongs one of the above defined legal format.
            for(int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);
                if(temp >= '0' && temp <= '9')
                    continue;
                else if (temp == '.'){
                    if(!hasDot)
                        hasDot = true;
                    else
                        return false;
                }
                else
                    return false;
            }
            
            return true;
        }
    }
    
    public boolean validate2(String s){
        int start = 0, end = s.length() - 1;
        
        //trim
        while(start < end && s.charAt(start) == ' ')
            start++;
        while(end >= start && s.charAt(end) == ' ')
            end--;
        
        if (s.charAt(start) == '+' || s.charAt(start) == '-'){
            start += 1;
        }
        
        s = s.substring(start, end+1);
        if(s.length() == 0 || s.equals(".")){
            return false;
        }
        else{
            //verify whether the processed string belongs one of the above defined legal format.
            for(int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);
                if(temp >= '0' && temp <= '9')
                    continue;
                else if (temp == '.'){
                    return false;
                }
                else
                    return false;
            }
            
            return true;
        }
    }
}