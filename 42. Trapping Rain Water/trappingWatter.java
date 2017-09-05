class Solution {
    //Dynamic programming.
    //for a given index i, we need to find the location j of closest elevation in wich height[j]>=height[i] in its left hand side
    //OPT[i] = OPT[i-1] + new_water_between_i_and_j.
    /*if height[k] > height[k-1], 
    //then the addtional water volumn between i and k is |i-k-1| * (height[k]-highest_elevation_between_i_and_k)
    */
    public int trap(int[] height) {
        int[] OPT = new int[height.length];
        if(height.length == 0)  return 0;
        Arrays.fill(OPT, 0);
        for(int i = 1; i < OPT.length; i++){
            OPT[i] = OPT[i-1];
            int k = i - 1;
            int largest = 0;
            while(k >= 0 && height[k] <= height[i]){
                if(height[k] > height[k+1] && height[k] > largest){
                    OPT[i] += (i-k-1) * (height[k]-largest);
                }
                largest = Math.max(largest, height[k]);
                k--;
            }
            if(k>=0 && height[k] > height[i]){
                OPT[i] += (i-k-1) * (height[i] - largest);
            }
        }
        return OPT[OPT.length-1];
    }
}