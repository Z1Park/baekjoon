import java.util.*;

class Solution {
    
    private int[] cnts;
    
    private int getCount(int tp) {
        int end = tp + 1;
        while (end < cnts.length && cnts[end] == 0)
            end++;
        if (end == cnts.length) return tp;
        else {
            int forward = tp * 2 + cnts.length - end;
            int backward = (cnts.length - end) * 2 + tp;
            return Math.min(forward, backward);
        }
    }
    
    public int solution(String name) {
        cnts = new int[name.length()];
        List<Integer> turningPoints = new ArrayList<>();
        boolean flag = false;
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            cnts[i] = (c < 'N') ? c - 'A' : 'Z' - c + 1;
            sum += cnts[i];
            if (flag && cnts[i] == 0) {
                turningPoints.add(i-1);
                flag = false;
            }
            if (cnts[i] != 0) flag = true;
        }
        turningPoints.add(cnts.length-1);
        
        if (sum == 0) return 0;
        int minValue = 41;
        for (int tp : turningPoints) {
            int cnt = getCount(tp);
            if (cnt < minValue) minValue = cnt;
        }
        return sum + minValue;
    }
}