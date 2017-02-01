public class Solution {
    /*
    3 diff cases:
        1. i can be divided by 3
        2. i can be divided by 5
        3. i can be divided by both 3 & 5
    */
    public List<String> fizzBuzz(int n) {
        List<String> out = new ArrayList<String>();
        for(int i = 1; i < n+1; i++){
            if(i % 3 == 0){
                if(i % 5 == 0)
                    out.add("FizzBuzz");
                else
                    out.add("Fizz");
            }
            else{
                if(i % 5 == 0)
                    out.add("Buzz");
                else
                    out.add(String.valueOf(i));
            }
        }
        return out;
    }
}