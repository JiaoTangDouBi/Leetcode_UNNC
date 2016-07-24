/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        else {
            ListNode test1 = head;
            ListNode test2 = head.next;
            while (test1 != null && test2 != null){
                if (test1 == test2){
                    return true;
                }
                else{
                    test1 = test1.next;
                    test2 = test2.next;
                    if(test2 == null || test2.next == null){
                        return false;
                    }
                    else{
                        test2 = test2.next;
                    }
                }
            }
            return false;
        }
    }
}