public class Solution {
    //we use a function to generate a substring of S ranged from 0 to N-1. (use arraylist to store this string owing to speed)
    //each number in the concatenating arraylist stands for the length of a continuous sequence (1 or 2).
    //Since there r only 2 diff values, use a boolean to check current value is 1 or 2.
    public int magicalString(int n) {
        if (n == 0)
            return 0;
        else if (n <=3)
            return 1;
        ArrayList<Integer> ori = new ArrayList<Integer>();
        ori.add(1);
        ori.add(2);
        ori.add(3);
        ArrayList<Integer> con = new ArrayList<Integer>();
        con.add(1);
        con.add(2);
        con.add(2);
        int conInd = 2;
        int count = 1;
        boolean isOne = true;
        while(ori.size()<n){
            for(int i = 0; i < con.get(conInd); i++){
                //update
                if(isOne){
                    ori.add(1);
                    con.add(1);
                    count++;
                }
                else{
                    ori.add(2);
                    con.add(2);
                }
            }
            conInd++;
            isOne = !isOne;
        }
        if(ori.size() > n && !isOne){
            return count-1;
        }
        else{
            return count;
        }
    }
}