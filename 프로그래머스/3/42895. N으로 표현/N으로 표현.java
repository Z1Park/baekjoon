import java.util.*;
import java.util.concurrent.*;

class Solution {
    private Map<Integer, Integer> map = new ConcurrentHashMap<>();
    private PriorityQueue<int[]> pq = 
        new PriorityQueue<>(Comparator.comparing(arr -> arr[0]));
    
    private void operation(int value, int next) {
        if (map.containsKey(next)) {
            if (map.get(next) > value) {
                map.put(next, value);
                pq.add(new int[]{value, next});
            }
        }
        else {
            map.put(next, value);
            pq.add(new int[]{value, next});
        }
    }
    
    public int solution(int N, int number) { 
        for (int num = N, i = 1; num <= 99999999; i++, num = num * 10 + N) {
            map.put(num, i);
            pq.add(new int[]{i, num});
        }
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int num = tmp[1], cnt = tmp[0];
            if (cnt > 8) break;
            final int value = map.get(num);
            operation(value+1, num + N);
            operation(value+1, num - N);
            operation(value+1, num * N);
            operation(value+1, num / N);
            map.entrySet().stream()
                .filter(e -> e.getValue() + value < 8)
                .forEach(e -> {
                    operation(e.getValue() + value, e.getKey() + num);
                    operation(e.getValue() + value, e.getKey() - num);
                    operation(e.getValue() + value, e.getKey() * num);
                    if (num != 0)
                        operation(e.getValue() + value, e.getKey() / num);
                });
        }
        if (!map.containsKey(number) || map.get(number) > 8) 
            return -1;
        return map.get(number);
    }
}