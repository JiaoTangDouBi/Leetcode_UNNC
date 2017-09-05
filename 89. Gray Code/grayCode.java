class Solution {
    /*Given n = 3, the first 4 elements in the sequence should be the same as n =2.
      Then start from 5th element, the sequence of last 2 binary digits should be the reversed (Symmetric) sequence of 2
      and the only difference is the most significant digit is 1 rather than 0.
      Then for n = 4, the sequence of last 3 binary digits should bethe reversed version of 3 
      and the only difference is also the same (most- significant). and So on so forth
    */
    public List<Integer> grayCode(int n) {
        List<Integer> out = new ArrayList<Integer>();
        out.add(0);
        if(n == 0)  return out;
        out.add(1);
        int i = 2;
        while(i <= n){
            int size = out.size();
            for(int j = size-1; j>=0; j--){
                out.add(out.get(j)+(int)(Math.pow(2,i-1)));
            }
            i++;
        }
        return out;
    }
}