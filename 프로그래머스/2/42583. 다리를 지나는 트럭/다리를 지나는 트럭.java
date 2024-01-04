import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> que = new ArrayDeque<>();
        int weightSum = 0, time = 1;
        for (int truck : truck_weights) {
            while (!que.isEmpty() && que.peek()[0] < time)
                weightSum -= que.poll()[1];
            while (que.size() >= bridge_length || weightSum + truck > weight) {
                int[] tmp = que.poll();
                time = tmp[0];
                weightSum -= tmp[1];
            }
            que.add(new int[]{time + bridge_length, truck});
            weightSum += truck;
            time++;
        }
        while (!que.isEmpty())
            time = que.poll()[0];
        return time;
    }
}