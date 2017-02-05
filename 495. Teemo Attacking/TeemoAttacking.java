public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        //we use a variable to record the recover time of Ashe from last attacking time.
        //remove the overlapping time period and count the total poisoned during.
        int sum = 0;
        if (timeSeries.length == 0){
            return sum;
        }
        int start = timeSeries[0];
        int stop = timeSeries[0] + duration;
        for(int i = 1; i < timeSeries.length; i++){
            if(stop<timeSeries[i]){
                sum += stop-start;
                start=timeSeries[i];
            }
            stop = timeSeries[i] + duration;
        }
        if(stop-start != 0){
            sum += stop-start;
        }
        return sum;
    }
}