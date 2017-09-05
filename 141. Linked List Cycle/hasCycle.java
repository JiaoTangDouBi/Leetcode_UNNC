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
    //Use two pointers to iterate the list, where one shift 2 steps in each iteration and another shift 1 in every iteration.
    //If there exists a cycle in the linkedlist, those two pointers must meet in some node.
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)   return false;
        ListNode iter1 = head;
        ListNode iter2 = head.next;
        while(iter2.next != null && iter2.next.next != null){
            iter1 = iter1.next;
            iter2 = iter2.next.next;
            if(iter1 == iter2){
                return true;
            }
        }
        return false;
    }
}