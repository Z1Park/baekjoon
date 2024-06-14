import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            indexMap.put(friends[i], i);
        int[] exp = new int[n];
        int[][] count = new int[n][n];
        for (String gift : gifts) {
            int i = gift.indexOf(" ");
            int send = indexMap.get(gift.substring(0, i));
            int receive = indexMap.get(gift.substring(i+1));
            exp[send]++;
            exp[receive]--;
            count[send][receive]++;
        }
        
        int result = 0;
        int[] present = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (count[i][j] == count[j][i]) {
                    if (exp[i] > exp[j]) present[i]++;
                }
                else {
                    if (count[i][j] > count[j][i]) present[i]++;
                }
            }
            result = Math.max(result, present[i]);
        }
        return result;
    }
}