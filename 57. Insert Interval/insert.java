/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    //Greedy Algorith,We first insert the new interval in the corresponding place based on the start time.
    //Then check each pair of intervals. (n with n+1);
    //If there exist an overlap, merge them and compare this new merged one with its successor.
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        insertIntoSortedIntervals(intervals, newInterval);
        
        //inside this compare pace, the tricky thing is the intervals length is dynamic.
        for(int i = 0; i < intervals.size(); i++){
            while(i+1 < intervals.size() && intervals.get(i+1).start <= intervals.get(i).end){
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
                intervals.remove(i+1);
            }
        }
        
        return intervals;
    }
    
    public void insertIntoSortedIntervals(List<Interval> intervals, Interval newInterval){
        for(int i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start >= newInterval.start){
                intervals.add(i, newInterval);
                return ;
            }
        }
        //If this beginning time is larger than any existing intervals, add it to the end.
        intervals.add(newInterval);
        return;
    }
}