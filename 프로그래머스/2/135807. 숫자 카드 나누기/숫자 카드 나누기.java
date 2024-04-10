class Solution {
    
    private int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        int tmp = a % b;
        while (tmp != 0) {
            a = b;
            b = tmp;
            tmp = a % b;
        }
        return b;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0], gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayB[i] % gcdA == 0) gcdA = 1;
            if (arrayA[i] % gcdB == 0) gcdB = 1;
        }
        if (gcdA == 1 && gcdB == 1) return 0;
        return Math.max(gcdA, gcdB);
    }
}