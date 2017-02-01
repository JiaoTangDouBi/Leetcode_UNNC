public class Solution {
    /*
    sum every digit from right to left, 
    if both of them are 1, then pay attention to carrier.
    */
    public String addBinary(String a, String b) {
        if (a.length() < b.length()){
            String hold = a;
            a = b;
            b = hold;
        }
        StringBuilder strb = new StringBuilder(a);
        int length = b.length();
        for (int i = 0; i < length; i++){
            if (a.charAt(a.length()-1-i) == '1' && b.charAt(b.length()-1-i) == '1'){
                strb.replace(a.length()-1-i, a.length()-i, "0");
                int j = i+1;
                while (j<a.length() && a.charAt(a.length()-1-j) == '1'){
                    strb.replace(a.length()-1-j, a.length()-j, "0");
                    j++;
                }
                a = strb.toString();
                if (j == a.length()){
                    a = "1" + a;
                    strb = new StringBuilder(a);
                }
                else{
                    strb.replace(a.length()-1-j, a.length()-j, "1");
                    a = strb.toString();
                }
            }
            else if (a.charAt(a.length()-1-i) == '1' || b.charAt(b.length()-1-i) == '1'){
                strb.replace(a.length()-1-i, a.length()-i, "1");
                a = strb.toString();
            }
        }
        return a;
    }
}