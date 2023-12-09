import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> aQue = new PriorityQueue<>();
        for (int a : A) aQue.add(a);
        PriorityQueue<Integer> bQue = new PriorityQueue<>();
        for (int b : B) bQue.add(b);
        int score = 0;
        while (!bQue.isEmpty()) {
            if (aQue.peek() >= bQue.poll()) continue;
            score++;
            aQue.poll();
        }
        return score;
    }
}