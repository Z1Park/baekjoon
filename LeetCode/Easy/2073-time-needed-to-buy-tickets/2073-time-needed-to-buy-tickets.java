class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int target = tickets[k], count = 0;
        for (int i = 0; i <= k; i++)
            count += Math.min(tickets[i], target);
        target--;
        for (int i = k+1; i < tickets.length; i++)
            count += Math.min(tickets[i], target);
        return count;
    }
}