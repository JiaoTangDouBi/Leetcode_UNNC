/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode former = head;
        ListNode latter = former.next;
        while (former != null && latter != null){
            int a = former.val;
            former.val = latter.val;
            latter.val = a;
            former = former.next.next;
            if (latter.next != null){
                latter = latter.next.next;
            }
            else{
                return head;
            }
        }
        return head;
    }
}