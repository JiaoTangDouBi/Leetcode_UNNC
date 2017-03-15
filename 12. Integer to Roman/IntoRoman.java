public class Solution {
    /*
    For this question, we need to divide a number into 7 parts:
    1. bigger than 1000
    2. bigger than 500
    3. bigger than 100
    4. bigger than 50
    5. bigger than 10
    6. bigger than 5
    7. the left.
    */
    String s = "";
    public String intToRoman(int num) {
        int remainder = num%1000;
        int divide = num/1000;
        num = remainder;
        for(int i = 1; i <=divide; i++){
            s += "M";
        }
        int k = 100;
        num = help(num, k, 9, "C","D","M");
        k = 10;
        num = help(num, k, 9, "X","L","C");
        k = 1;
        num = help(num, k, 9, "I","V","X");
        return s;
    }
    
    public int help(int num, int k, int j, String a, String b, String c){
        int remainder = num%k;
        int divide = num/k;
        if (divide == j)
            s += a+c;
        else if (divide == j-1)
            s += b+a+a+a;
        else if (divide == j-2)
            s += b+a+a;
        else if (divide == j-3)
            s += b+a;
        else if (divide == j-4)
            s += b;
        else if (divide == j-5)
            s += a+b;
        else if (divide == j-6)
            s += a+a+a;
        else if (divide == j-7)
            s += a+a;
        else if (divide == j-8)
            s += a;
        return remainder;
    }
}