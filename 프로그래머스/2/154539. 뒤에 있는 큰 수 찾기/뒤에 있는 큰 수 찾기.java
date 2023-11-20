import java.util.*;
import javafx.util.Pair;

class Solution {
    public int[] solution(int[] numbers) {
        Deque<Pair<Integer, Integer>> stk = new ArrayDeque<>();
        int[] res = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) res[i] = -1;
        for (int i = 0; i < numbers.length; i++) {
            while (!stk.isEmpty() && stk.peekLast().getKey() < numbers[i]) {
                Pair<Integer, Integer> p = stk.pollLast();
                res[p.getValue()] = numbers[i];
            }
            stk.addLast(new Pair(numbers[i], i));
        }
        return res;
    }
}