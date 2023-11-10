import java.util.*;

class Solution {
    
    private int gcd(int n1, int n2) {
        int a = n1, b = n2;
        while (a % b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return n1 * n2 / b;
    }
    
    public int solution(int[] arr) {
        Integer[] newArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(newArr, Collections.reverseOrder());
        int res = newArr[0];
        for (int i = 1; i < newArr.length; i++)
            res = gcd(res, newArr[i]);
        return res;
    }
}