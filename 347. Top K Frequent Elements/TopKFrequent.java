public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        Use a map to store the integer with its corresponding appearance times.
        Convert the map to a sequence of buckets to store the integers.
        the appearence times of an int is same as (the index of a bucket in which it located)-1.
        */
        ArrayList<Integer>[] buckets = new ArrayList[nums.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums){
            if (map.containsKey(i)){
                int temp = map.get(i);      //get the emergence times of i before.
                map.remove(i);
                map.put(i,temp+1);
            }
            else{
                map.put(i,1);
            }
        }
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList<Integer>();
        }
        for(int key : map.keySet()){
            buckets[map.get(key)-1].add(key);
        }
        List<Integer> output = new ArrayList<Integer>();
        for(int i = nums.length-1; i >= 0; i--){
            for(int temp: buckets[i]){
                output.add(temp);
                if(output.size() >= k){
                    return output;
                }
            }
        }
        return output;
    }
}