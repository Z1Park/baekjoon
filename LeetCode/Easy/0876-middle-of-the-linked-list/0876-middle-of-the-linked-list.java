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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) return head.next;
        ListNode middle = head.next;
        head = head.next;
        boolean flag = false;
        while (head.next != null) {
            if (flag) {
                flag = false;
                middle = middle.next;
            }
            else flag = true;
            head = head.next;
        }
        return middle;
    }
}