public class Solution {
    /*A reasonable way to rearrange those people is starting from highest items.
    The new coming items whose hight is lower than already arranged ones doesn't affect value k of those already settled.
    Sort them by their height in decending order and get a new array a1.
    put each item in a1 from left to right into corresponding k-th place.
    */
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0)  return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                if(entry1[0] < entry2[0]){
                    return 1;
                }
                else if(entry1[0] > entry2[0]){
                    return -1;
                }
                else{
                    return Integer.compare(entry1[1],entry2[1]);
                }
            }
        });
        // return people;
        ArrayList<int[]> temp = new ArrayList<int[]>();
        for(int i = 0; i < people.length; i++){
            temp.add(people[i][1], people[i]);
        }
        int[][] output = new int[temp.size()][2];
        for(int i = 0; i < temp.size(); i++){
            output[i][0] = temp.get(i)[0];
            output[i][1] = temp.get(i)[1];
        }
        return output;
    }
}