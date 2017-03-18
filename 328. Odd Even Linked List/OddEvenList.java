/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode oddEvenList(ListNode head) {
        if(head == null)    return head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        int i = 2;
        while(pointer2.next != null){
            if(i % 2 != 0){
                ListNode temp = pointer2.next;
                pointer2.next = pointer2.next.next;
                ListNode temp1= pointer1.next;
                pointer1.next = temp;
                temp.next = temp1;
                pointer1 = pointer1.next;
            }
            else{
                pointer2 = pointer2.next;
            }
            i++;
        }
        return head;
    }
}