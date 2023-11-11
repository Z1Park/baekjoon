import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> que = new LinkedList<>();
        for (int p : priorities) que.add(p);
        Arrays.sort(priorities);
        for (int i = priorities.length - 1; i >= 0; i--) {
            while (que.peek() != priorities[i]) {
                que.add(que.poll());
                location--;
                if (location < 0) location = que.size() - 1;
            }
            que.poll();
            if (location == 0) return priorities.length - i;
            location--;
        }
        return priorities.length -1;
    }
}