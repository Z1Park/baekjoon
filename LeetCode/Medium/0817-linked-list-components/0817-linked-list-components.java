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
    public int numComponents(ListNode head, int[] nums) {
        boolean[] check = new boolean[10001];
        for (int i : nums) check[i] = true;
        int res = 0;
        boolean flag = false;
        while (head != null) {
            if (!check[head.val]) {
                if (flag) res++;
                flag = false;
            }
            else if (!flag) flag = true;
            head = head.next;
        }
        if (flag) res++;
        return res;
    }
}