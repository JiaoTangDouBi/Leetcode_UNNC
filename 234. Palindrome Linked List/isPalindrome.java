/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //We can split the given list to two parts in the middle point.
    //Reverse the second part and compare whether the reversed version is same as first part or not.
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode iter1 = head;
        while(iter1 != null){
            length++;
            iter1 = iter1.next;
        }
        if(length <= 1) return true;
        iter1 = head;
        ListNode iter2 = head;
        if(length % 2 == 0){
            int k = length/2;
            while(k > 0){
                iter2 = iter2.next;
                k--;
            }
        }
        else{
            int k = length/2 + 1;
            while(k > 0){
                iter2 = iter2.next;
                k--;
            }
        }
        
        //reverse the second part
        ListNode help = null;
        while(iter2 != null && iter2.next != null){
            ListNode temp = iter2.next;
            iter2.next = help;
            help = iter2;
            iter2 = temp;
        }
        iter2.next = help;
        //check
        while(iter2 != null){
            if(iter2.val != iter1.val)  return false;
            iter2 = iter2.next;
            iter1 = iter1.next;
        }
        return true;
    }
}