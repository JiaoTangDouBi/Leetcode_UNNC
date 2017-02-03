public class Solution {
    //use remainder of division.
    public int reverse(int x) {
        boolean isFu = false;
        if (x < 0){
            isFu = true;
        }
        //regardless of sign
        x = Math.abs(x);
        ArrayList<Integer> storage = new ArrayList<Integer>();int div;
        do{
            div = x/10;
            storage.add(x%10);
            x = div;
        }while(div>0);
        int out = 0;
        for(int i = 0; i < storage.size(); i++){
            out += storage.get(i)*Math.pow(10,storage.size()-1-i );
            //stack overflow
            if(out < 0) return 0;
        }
        //stack overflow
        if(out == 2147483647)   return 0;
        if (isFu){ out = -out;}
        return out;
    }
}