import java.util.*;

class Solution {
    
    private int[][] users;
    private int[] emoticons;
    private int[] discounts;
    private int[] res = new int[2];
    
    private void dfs(int depth) {
        if (depth >= emoticons.length) {
            int[] purchase = new int[users.length];
            for (int i = 0; i < discounts.length; i++) {
                for (int j = 0; j < users.length; j++) {
                    if (users[j][0] <= discounts[i])
                        purchase[j] += emoticons[i] * (100 - discounts[i])/100;
                }
            }
            int cnt = 0, sum = 0;
            for (int i = 0; i < users.length; i++) {
                if (purchase[i] >= users[i][1]) {
                    purchase[i] = 0;
                    cnt++;
                }
                sum += purchase[i];
            }
            if (res[0] < cnt) {
                res[0] = cnt;
                res[1] = sum;
            }
            else if (res[0] == cnt && res[1] < sum) {
                res[1] = sum;
            }
            return;
        }
        for (int discount = 10; discount <= 40; discount += 10) {
            discounts[depth] = discount;
            dfs(depth + 1);
        }
    }
    
    public int[] solution(int[][] u, int[] e) {
        users = u;
        emoticons = e;
        discounts = new int[e.length];
        dfs(0);
        return res;
    }
}