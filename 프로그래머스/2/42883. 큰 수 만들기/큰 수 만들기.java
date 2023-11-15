import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    public String solution(String number, int k) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            while (!stk.isEmpty() && stk.peek() < number.charAt(i) && k > 0) {
                stk.pop();
                k--;
            }
            if (number.length() - k > stk.size()) stk.push(number.charAt(i));
        }
        return stk.stream().map(String::valueOf).collect(joining());
    }
}