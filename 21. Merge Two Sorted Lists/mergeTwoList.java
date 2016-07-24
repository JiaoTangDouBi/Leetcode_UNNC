/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       if (l1 == null){
           return l2;
       }
       else if (l2 == null){
           return l1;
       }
       else{
            ListNode output = new ListNode(1);
            ListNode head = output;
            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    output.next = new ListNode(l1.val);
                    output = output.next;
                    l1 = l1.next;
                }
                else{
                    output.next = new ListNode(l2.val);
                    output = output.next;
                    l2 = l2.next;
                }
            }
            while (l1 == null && l2!=null){
                output.next = new ListNode(l2.val);
                    output = output.next;
                l2 = l2.next;
            }
            while (l1 != null && l2==null){
                output.next = new ListNode(l1.val);
                output = output.next;
                l1 = l1.next;
            }
            return head.next;
       }
       
    }
}