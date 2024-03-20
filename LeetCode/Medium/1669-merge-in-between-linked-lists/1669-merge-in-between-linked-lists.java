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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1, prev = null;
        for (int i = 0; i < a; i++) {
            prev = node;
            node = node.next;
        }
        prev.next = list2;
        
        for (int i = a; i < b; i++)
            node = node.next;
        while (prev.next != null)
            prev = prev.next;
        prev.next = node.next;
        return list1;
    }
}