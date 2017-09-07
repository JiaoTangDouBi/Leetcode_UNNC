/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //Recursion solution
    public ListNode reverseListRec(ListNode head) {
        if(head == null){
            return null;
        }
        else if(head.next == null){
            return head;
        }
        else{
            ListNode help = reverseList(head.next);
            ListNode iterator = help;
            ListNode end = new ListNode(head.val);
            while(iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next = end;
            return help;
        }
    }
    
    //iteration solution
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode help = new ListNode(head.val);
        ListNode iterator = head.next;
        while(iterator != null){
            ListNode temp = new ListNode(iterator.val);
            iterator = iterator.next;
            temp.next = help;
            help = temp;
        }
        
        return help;
    }
}