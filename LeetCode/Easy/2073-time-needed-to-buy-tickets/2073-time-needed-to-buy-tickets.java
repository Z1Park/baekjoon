class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++)
            que.add(new int[]{tickets[i], i});
        
        int count = 0;
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            count++;
            
            if (curr[0] > 1) {
                curr[0]--;
                que.add(curr);
            }
            else if (curr[1] == k) break;
        }
        return count;
    }
}