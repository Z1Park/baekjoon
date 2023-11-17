class Solution {
    
    private int getGreatestDivisor(long n) {
        if (n <= 1) return 0;
        int max = (int)Math.sqrt(n);
        int res = 1;
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                if (n / i <= 10000000) return (int)(n / i);
                else res = i;
            }
        }
        return res;
    }
    
    public int[] solution(long begin, long end) {
        int[] res = new int[(int)(end - begin + 1)];
        for (long i = begin; i <= end; i++) {
            res[(int)(i-begin)] = getGreatestDivisor(i);
        }
        return res;
    }
}