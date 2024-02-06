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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (head != null) {
            pq.add(head.val);
            head = head.next;
        }
        ListNode curr = new ListNode(pq.poll());
        while (!pq.isEmpty()) {
            curr = new ListNode(pq.poll(), curr);
        }
        return curr;
    }
}