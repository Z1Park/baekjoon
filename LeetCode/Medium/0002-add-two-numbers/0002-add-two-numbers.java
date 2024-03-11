/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        int sum;
        ListNode head = null, curr = null;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) sum = l2.val;
            else if (l2 == null) sum = l1.val;
            else sum = l1.val + l2.val;
            if (carry) {
                sum++;
                carry = false;
            }
            if (sum >= 10) {
                carry = true;
                sum -= 10;
            }
            
            if (curr == null) {
                head = new ListNode(sum);
                curr = head;
            }
            else {
                curr.next = new ListNode(sum);
                curr = curr.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry) curr.next = new ListNode(1);
        return head;
    }
}