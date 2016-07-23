public class Solution {
    public boolean isUgly(int num) {
        if (num == 1){
            return true;
        }
        else if (num == 0){
            return false;
        }
        else{
            
            int result_2 = num / 2;
            while (result_2 * 2 == num){
                num = result_2;
                result_2 = num / 2;
            }
            int result_3 = num / 3;
            while (result_3 * 3 == num){
                num = result_3;
                result_3 = num / 3;
            }
            int result_5 = num / 5;
            while (result_5 * 5 == num){
                num = result_5;
                result_5 = num / 5;
            }
            if (num == 1){
                return true;
            }
            else{
                return false;
            }
        }
    }
}