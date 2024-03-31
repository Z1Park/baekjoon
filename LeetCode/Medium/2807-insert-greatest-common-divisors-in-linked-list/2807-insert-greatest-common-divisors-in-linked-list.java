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
    
    private int gcd(int a, int b) {
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) return head;
        ListNode node = head;
        while (node.next != null) {
            int val = gcd(node.val, node.next.val);
            ListNode insertNode = new ListNode(val, node.next);
            node.next = insertNode;
            node = insertNode.next;
        }
        return head;
    }
}