public class Solution {
    /*Iterate the whole matrix. During iteration, We use a pointer points to the current smallest element in the given array.
    We use a set to store all accessible elements from current pointer and previous ones. Open the first element in set and remove it as well as inserting its adjacents. Continue doing it until we find the first k elments.
    */
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int target = matrix[0][0] - 1;
        int[][] visited = new int[length][length]; //use another matrix to show whether the given element was visited before.
        int[] index={0,0};
        ArrayList<int[]> candidateIndex = new ArrayList<int[]>();
        candidateIndex.add(index);
        while(k!=0){
            //for every iteration, we need to do the following jobs.
            int[] temp = candidateIndex.get(0);
            candidateIndex.remove(0);
            target = matrix[temp[0]][temp[1]];
            // System.out.println("index = " + temp[0] + temp[1]);
            k -= 1;
            
            //add the adjacent of the smallest value from a given arraylist to it.
            if(temp[0] + 1 < length && visited[temp[0]+1][temp[1]] == 0){
                visited[temp[0]+1][temp[1] ] = 1;
                int[] tempIndex = {temp[0]+1, temp[1]};
                int newFirst = matrix[temp[0]+1][temp[1]];
                int size = candidateIndex.size();
                for(int i = 0; i < size; i++){
                    int[] tempIndex1 = candidateIndex.get(i);
                    if(newFirst <= matrix[tempIndex1[0] ][tempIndex1[1] ]){
                        candidateIndex.add(i,tempIndex);
                        break;
                    }
                }
                if(candidateIndex.size() == size){
                    candidateIndex.add(tempIndex);
                }
            }
            if(temp[1] + 1 < length && visited[temp[0]][temp[1]+1] == 0){
                visited[temp[0]][temp[1]+1] = 1;
                int[] tempIndex = {temp[0], temp[1]+1};
                int newSecond = matrix[temp[0]][temp[1]+1];
                int size = candidateIndex.size();
                for(int i = 0; i < size; i++){
                    int[] tempIndex1 = candidateIndex.get(i);
                    if(newSecond <= matrix[tempIndex1[0] ][tempIndex1[1] ]){
                        candidateIndex.add(i,tempIndex);
                        break;
                    }
                }
                if(candidateIndex.size() == size){
                    candidateIndex.add(tempIndex);
                }
            }
        }
        return target;
    }
}