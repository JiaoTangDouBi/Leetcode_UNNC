/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (head!= null) {
        	array.add(head.val);
        	head =head.next;
		}
		if (array.size() == 0){
		    return null;
		}
        ArrayList<ListNode> array1 = new ArrayList<ListNode>();
        for (int i = array.size()-1; i >= 0 ; i--) {
			array1.add(new ListNode(array.get(i)));
		}
        for (int i = 0; i < array1.size()-1; i++){
            array1.get(i).next = array1.get(i+1);
        }
        return array1.get(0);
    }
}