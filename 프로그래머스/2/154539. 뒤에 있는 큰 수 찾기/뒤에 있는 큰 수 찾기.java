import java.util.*;
import javafx.util.Pair;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Pair<Integer, Integer>> stk = new Stack<>();
        int[] res = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) res[i] = -1;
        for (int i = 0; i < numbers.length; i++) {
            while (!stk.isEmpty() && stk.peek().getKey() < numbers[i]) {
                Pair<Integer, Integer> p = stk.pop();
                res[p.getValue()] = numbers[i];
            }
            stk.push(new Pair(numbers[i], i));
        }
        return res;
    }
}