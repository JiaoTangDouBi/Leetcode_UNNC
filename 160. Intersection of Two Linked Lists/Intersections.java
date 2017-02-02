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
    //if the lengthes of two lists are same, just compare one by one.
    //if the lengthes are diff, we can divide process into two steps:
    //first: pass though the longer list until the distance from the current point to the end of this list is the same as another.
    //second: operate the comparison one by one. Since if they have intersection, they must end in the same point. Y style.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int diff = lengthList(headA) - lengthList(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        if (diff > 0){
            for (int i = 0; i < diff; i++){
                tempA = tempA.next;
            }
        }
        else if (diff < 0){
            for (int i = 0; i < -diff; i++){
                tempB = tempB.next;
            }
        }
        if (tempA == tempB){
            return tempA;
        }
        else{
            while(tempA != null){
                tempA = tempA.next;
                tempB = tempB.next;
                if (tempA == tempB){
                    return tempA;
                }
            }
            return null;
        }
    }
    
    public int lengthList(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}