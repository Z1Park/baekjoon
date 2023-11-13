import java.util.*;
import javafx.util.Pair;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Pair<Integer, Integer>> stk = new Stack<>();
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stk.isEmpty() && stk.peek().getKey() > prices[i]) {
                Pair<Integer, Integer> p = stk.pop();
                res[p.getValue()] = i - p.getValue();
            }
            stk.push(new Pair(prices[i], i));
        }
        while (!stk.isEmpty()) {
            Pair<Integer, Integer> p = stk.pop();
            res[p.getValue()] = prices.length - 1 - p.getValue();
        }
        return res;
    }
}