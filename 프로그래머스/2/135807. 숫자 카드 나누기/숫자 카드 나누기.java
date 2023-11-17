import java.util.*;

class Solution {
    
    private int gcd(int a, int b) {
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) gcdA = gcd(gcdA, arrayA[i]);
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) gcdB = gcd(gcdB, arrayB[i]);
        System.out.println(gcdA + " " + gcdB);
        for (int a : arrayA) if (a % gcdB == 0) {gcdB = 0;break;}
        for (int b : arrayB) if (b % gcdA == 0) {gcdA = 0;break;}
        if (gcdA == 0 && gcdB == 0) return 0;
        return Math.max(gcdA, gcdB);
    }
}