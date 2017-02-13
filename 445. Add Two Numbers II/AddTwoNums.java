/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //Convert two lists to two arrayList because the number listNode represents perhaps exceeds scopes.
    //Add two list one digit by one digit and we don't care about the carry. In other word, the result of sum of every digit perhaps larger than 10 in this step.
    //Checking the result of each digit from right to left, if this digit is bigger than 10, substract it by 10 and send a carry to the left digit.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1 != null){
            arr1.add(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2 != null){
            arr2.add(temp2.val);
            temp2 = temp2.next;
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        if(arr1.size() > arr2.size()){
            for(int i = 0; i < arr1.size()- arr2.size(); i++){
                output.add(arr1.get(i));
            }
            for(int i = arr1.size() - arr2.size(); i<arr1.size(); i++){
                output.add(arr2.get(i-(arr1.size() - arr2.size()))+arr1.get(i));
            }
        }
        else{
           for(int i = 0; i < arr2.size()- arr1.size(); i++){
                output.add(arr2.get(i));
            }
            for(int i = arr2.size() - arr1.size(); i<arr2.size(); i++){
                output.add(arr1.get(i-(arr2.size() - arr1.size()))+arr2.get(i));
            }
        }
        int carry = 0;
        for(int i = output.size()-1; i >= 0; i--){
            if (carry == 1){
                output.set(i, output.get(i)+1);
                carry = 0;
            }
            if(output.get(i)/10 > 0){
                carry = 1;
                output.set(i,output.get(i)-10);
            }
        }
        if (carry == 1){
            output.add(0,1);
        }
        ListNode head = new ListNode(output.get(0));
        ListNode iteral=head;
        for(int i = 1; i < output.size(); i++){
            ListNode temp = new ListNode(output.get(i));
            iteral.next = temp;
            iteral = iteral.next;
        }
        return head;
    }
}
