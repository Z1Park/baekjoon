import java.util.*;

class Solution {
    
    private int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    
    private boolean isBlocked(String[] place, int[] p1, int[] p2) {
        if (p1[0] == p2[0] || p1[1] == p2[1]) {
            if (place[(p1[0]+p2[0]) / 2].charAt((p1[1]+p2[1]) / 2) != 'X')
                return false;
            return true;
        }
        if (place[p1[0]].charAt(p2[1]) != 'X' || place[p2[0]].charAt(p1[1]) != 'X')
            return false;
        return true;
    }
    
    private int checkPlace(String[] place) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P')
                    list.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                int[] p1 = list.get(i), p2 = list.get(j);
                int dist = getDistance(p1, p2);
                if (dist > 2) continue;
                if (dist <= 1 || !isBlocked(place, p1, p2))
                    return 0;
            }
        }
        return 1;
    }
    
    public int[] solution(String[][] places) {
        List<Integer> res = new ArrayList<>();
        for (String[] place : places)
            res.add(checkPlace(place));
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}