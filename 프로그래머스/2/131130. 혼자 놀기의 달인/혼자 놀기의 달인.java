import java.util.*;

class Solution {
    
    private int getCheckCard(boolean[] check) {
        int cnt = 0;
        for (boolean c : check) {
            if (c) cnt++;
        }
        return 0;
    }
    
    private int getScore(int[] cards, int idx) {
        boolean[] check = new boolean[cards.length];
        int firstGroup = 0;
        while (!check[idx]) {
            check[idx] = true;
            firstGroup++;
            idx = cards[idx]-1;
        }
        if (firstGroup == cards.length) return 0;
        int maxValue = 0;
        for (int i = 0; i < cards.length; i++) {
            if (check[i]) continue;
            boolean[] secondCheck = Arrays.copyOf(check, check.length);
            int secondGroup = 0;
            int secondIdx = i;
            while (!check[secondIdx]) {
                check[secondIdx] = true;
                secondGroup++;
                secondIdx = cards[secondIdx]-1;
            }
            if (maxValue < secondGroup)
                maxValue = secondGroup;
        }
        return firstGroup * maxValue;
    }
    
    public int solution(int[] cards) {
        int res = 0;
        for (int i = 0; i < cards.length; i++) {
            int score = getScore(cards, i);
            if (res < score) res = score;
        }
        return res;
    }
}