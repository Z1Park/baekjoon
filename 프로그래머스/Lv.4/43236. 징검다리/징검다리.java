import java.util.*;

class Solution {
    
    private List<Integer> rockList = new ArrayList<>();
    
    private int removeCount(int distance, int value) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        for (int i = 1; i < rockList.size() - 1; i++) {
            if (rockList.get(i) - tmp.get(tmp.size()-1) < value)
                continue;
            tmp.add(rockList.get(i));
        }
        if (distance - tmp.get(tmp.size()-1) < value)
            tmp.set(tmp.size()-1, distance);
        else tmp.add(distance);
        return rockList.size() - tmp.size();
    }
    
    private int binarySearch(int distance, int n) {
        int start = 0, end = distance;
        boolean flag = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (removeCount(distance, mid) <= n) {
                start = mid + 1;
                flag = true;
            }
            else {
                end = mid - 1;
                flag = false;
            }
        }
        return end;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        if (rocks.length == 1 && n == 1) return distance;
        rockList.add(0);
        for (int rock : rocks)
            rockList.add(rock);
        rockList.add(distance);
        rockList.sort(Comparator.naturalOrder());
        return binarySearch(distance, n);
    }
}