import java.util.*;

class Solution {
    
    private Map<String, Integer> indexMap = new HashMap<>();
    private int[] parent;
    private int[] incomes;
    
    private void distributeIncome(int idx, int income) {
        int tmp = income / 10;
        incomes[idx] += income - tmp;
        if (tmp != 0 && parent[idx] != -1) 
            distributeIncome(parent[idx], tmp);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parent = new int[enroll.length];
        incomes = new int[enroll.length];
        indexMap.put("-", -1);
        for (int i = 0; i < enroll.length; i++) {
            indexMap.put(enroll[i], i);
            parent[i] = indexMap.get(referral[i]);
        }
        for (int i = 0; i < seller.length; i++)
            distributeIncome(indexMap.get(seller[i]), amount[i] * 100);
        return incomes;
    }
}