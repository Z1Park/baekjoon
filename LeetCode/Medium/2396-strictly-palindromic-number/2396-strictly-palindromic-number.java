class Solution {

    private boolean checkPalindromic(int n, int base) {
        List<Integer> transList = new ArrayList<>();
        while (n > 0) {
            transList.add(n % base);
            n /= base;
        }
        int limit = transList.size() / 2, last = transList.size() - 1;
        for (int i = 0; i < limit; i++) {
            if (transList.get(i) != transList.get(last - i))
                return false;
        }
        return true;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            if (!checkPalindromic(n, i))
                return false;
        }
        return checkPalindromic(n, n);
    }
}