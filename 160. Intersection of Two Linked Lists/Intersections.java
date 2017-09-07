/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*Even though the length of two lists are diff, if two given lists have any intersection,
      the nodes after this intersection point should be identical. Like Y shape.
      In other word, the intersection should occur in the same location away from the ending.
      Thus for the longer list, we don't need to scrutinize the first (l1-l2) nodes cuz no itersection occurs there.
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode iter1 = headA;
        ListNode iter2 = headB;
        while(iter1 != null){
            l1++;
            iter1 = iter1.next;
        }
        while(iter2 != null){
            l2++;
            iter2 = iter2.next;
        }
        iter1 = headA;
        iter2 = headB;
        
        //let pointers iter1 and iter2 in the same locaiton away from the ending.
        if(l1 > l2){
            int k = l1-l2;
            while(k > 0){
                iter1 = iter1.next;
                k--;
            }
        }
        else{
            int k = l2-l1;
            while(k>0){
                iter2 = iter2.next;
                k--;
            }
        }
        
        while(iter1 != null){
            if(iter1 == iter2)
                return iter1;
            iter1 = iter1.next;
            iter2 = iter2.next;
        }
        return null;
    }
}