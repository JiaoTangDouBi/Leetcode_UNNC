/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*reservoir sampling
    How the make sure the probability of every number be equal without knowing total size?
    for the first 1/1
    second: 1/2 and first is 1/1 * 1/2
    third:  1/3 and the first two are 1/2 * 2/3 and 1/1 * 1/2 * 2/3 respectively
    forth:  1/4 and the first three are 1/3 * 3/4 and 1/2 * 2/3 * 3/4 and 1/1 * 1/2 * 2/3 * 3/4 respectively
    for nth: every node is 1/n
    */

    ListNode list;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        list = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = list;
        int counter = 1;
        int result=0;
        while(temp != null){
            int k = (int)(Math.random()*counter);
            if(k == 0){
                result=temp.val;
            }
            temp = temp.next;
            counter ++;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
