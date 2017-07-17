public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] first = (a.substring(0,a.length()-1)).split("\\+");
        String[] second= (b.substring(0,b.length()-1)).split("\\+");
        int m1 = Integer.parseInt(first[0]), m2 = Integer.parseInt(second[0]);
        int n1 = Integer.parseInt(first[1]), n2 = Integer.parseInt(second[1]);
        return String.valueOf(m1*m2-n1*n2) + "+" + String.valueOf(m1*n2+m2*n1) + "i";
    }
}