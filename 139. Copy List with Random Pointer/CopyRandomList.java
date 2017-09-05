/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    //Split deep copy to 2 steps
    /*1. deep copy every node w/o any pointers.
      2. deep copy the links in each node.
      Use a hashmap to store the <node, copiedNode> pair, thus in order to add links, we can:
        map.get(node).random = map.get(node.random);
        map.get(node).next   = map.get(node.next  );
    */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(iter != null){
            map.put(iter, new RandomListNode(iter.label));
            iter = iter.next;
        }
        map.put(null, null);
        iter = head;
        while(iter != null){
            map.get(iter).next = map.get(iter.next);
            map.get(iter).random = map.get(iter.random);
            iter = iter.next;
        }
        return map.get(head);
    }
}