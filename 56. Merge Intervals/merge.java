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
    //Greedy Algorithm
    //Sort intervals by the start time..
    //Check each interval with its successor.
    //If there exist overlapping between two given itervals, merge them and compare it with the following one.
    //If not, move to the next interval and compare it with the itervals behind it. O(n^2)
    public List<Interval> merge(List<Interval> intervals) {
        mergeSort(intervals);
        
        for(int i = 0; i < intervals.size(); i++){
            while(i+1<intervals.size()&&intervals.get(i).end>=intervals.get(i+1).start){
                intervals.get(i).end = Math.max(intervals.get(i+1).end, intervals.get(i).end);
                intervals.remove(i+1);
            }
        }
        return intervals;
    }
    
    public void mergeSort(List<Interval> intervals){
        if(intervals.size() <= 1){
            return;
        }
        int mid = intervals.size()/2;
        List<Interval> l1 = new ArrayList<>();
        List<Interval> l2 = new ArrayList<>();
        for(int i = 0; i < mid; i++){
            l1.add(intervals.get(i));
        }
        for(int i = mid; i < intervals.size(); i++)
            l2.add(intervals.get(i));
        intervals.clear();
        mergeSort(l1);mergeSort(l2);
        //trick part -- recursion.
        int m = 0;
        int n = 0;
        while(m < l1.size() || n < l2.size()){
            if(m < l1.size() && n < l2.size()){
                if(l1.get(m).start < l2.get(n).start){
                    intervals.add(l1.get(m));
                    m++;
                }
                else{
                    intervals.add(l2.get(n));
                    n++;
                }
            }
            else if (m < l1.size() && n == l2.size()){
                intervals.add(l1.get(m));
                m++;
            }
            else if (m ==l1.size() && n <  l2.size()){
                intervals.add(l2.get(n));
                n++;
            }
        }
    }
}