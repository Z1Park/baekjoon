class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        boolean[] revealed = new boolean[n];
        Arrays.sort(deck);
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            result[idx] = deck[i];
            revealed[idx] = true;
            boolean moveBottom = false;
            if (i == n-1) break;
            while (revealed[idx] || !moveBottom) {
                if (!revealed[idx]) 
                    moveBottom = true;
                if (++idx >= n)
                    idx = 0;
            }
        }
        return result;
    }
}