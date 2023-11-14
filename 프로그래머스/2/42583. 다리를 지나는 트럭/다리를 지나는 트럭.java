import java.util.*;
import javafx.util.Pair;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Pair<Integer, Integer>> que = new LinkedList<>();
        int time = 1;
        int totalWeight = 0;
        for (int truck : truck_weights) {
            while (!que.isEmpty() && que.peek().getKey() <= time) {
                totalWeight -= que.poll().getValue();
            }
            while (que.size() >= bridge_length || totalWeight+truck > weight) {
                Pair<Integer, Integer> p = que.poll();
                totalWeight -= p.getValue();
                time = p.getKey();
            }
            que.add(new Pair(time + bridge_length, truck));
            totalWeight += truck;
            time++;
        }
        while (!que.isEmpty()) {
            Pair<Integer, Integer> p = que.poll();
            time = p.getKey();
        }
        return time;
    }
}