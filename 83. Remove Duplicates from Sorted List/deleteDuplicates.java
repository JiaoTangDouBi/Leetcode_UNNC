/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        else{
            ListNode help = head;
            while (help.next != null){
                if (help.val == help.next.val){
                    help.next = help.next.next;
                }
                else{
                    help = help.next;
                }
            }
            return head;
        }
    }
}