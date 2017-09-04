/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //Use a heap with size k to store the smallest k elements.
    //Every time we pop the first element from heap O(logn) and add a new one inside O(logn).
    public ListNode mergeKLists(ListNode[] lists) {
        //Special case for avoiding exception of PQ.
        if(lists.length == 0)   return null;
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                if(l1.val < l2.val){
                    return -1;
                }
                else if(l1.val==l2.val)
                    return 0;
                else
                    return 1;
            }
        });
        
        ListNode out = new ListNode(1);
        ListNode iter= out;
        for(ListNode l : lists){
            if(l != null){
                pq.add(l);
            }
        }
        
        while(pq.size()!=0){
            iter.next = pq.poll();
            iter = iter.next;
            if (iter.next != null)  pq.add(iter.next);
        }
        
        return out.next;
    }
}