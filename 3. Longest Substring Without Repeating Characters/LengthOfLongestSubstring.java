class Solution {
    /*For this question, we can appy a slide window. 
    The size of this window is flexible and we want to enlarge it as much as possible.
    We use an array with size 100 to record the frequencies of characters in this window.
    If any frequnecy is greater than 1 we shift the left edge of this window in right direction.
    Else, we shift the right edge in right direction.
    */
    public int lengthOfLongestSubstring(String s) {
        int[] mask = new int[200];
        int largest = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            mask[(int)temp]++;
            while(mask[(int)temp]>1){
                
                mask[(int)(s.charAt(left))]--;
                left++;
            }
            if(i-left+1>largest)
                largest = i-left+1;
        }
        return largest;
    }
}