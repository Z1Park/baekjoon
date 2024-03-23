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
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        if (n == 0 || n == 1) return;
        
        node = head;
        ListNode[] nodes = new ListNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = node;
            node = node.next;
        }
        
        node = head;
        boolean flag = true;
        int l = 1, r = n-1;
        while (l <= r) {
            if (flag) node.next = nodes[r--];
            else node.next = nodes[l++];
            flag ^= true;
            node = node.next;
            node.next = null;
        }
    }
}