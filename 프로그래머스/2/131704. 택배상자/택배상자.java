import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stk = new ArrayDeque<>();
        int idx = 0, cnt = 0;
        for (int i = 1; i <= order.length; i++) {
            if (idx < order.length && i == order[idx]) {
                cnt++;
                idx++;
            }
            else if (idx < order.length && order[idx] > i) {
                stk.addFirst(i);
            }
            else if (!stk.isEmpty() && stk.peek() == order[idx]) {
                stk.poll();
                cnt++;
                idx++;
                i--;
            }
            // System.out.println(stk);
        }
        // System.out.println(idx);
        while (!stk.isEmpty() && stk.peek() == order[idx]) {
            stk.poll();
            cnt++;
            idx++;
        }
        return cnt;
    }
}