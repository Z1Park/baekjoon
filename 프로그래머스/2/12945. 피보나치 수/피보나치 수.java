class Solution {
    public int solution(int n) {
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int tmp = (a + b) % 1234567;
            a = b;
            b = tmp;
        }
        return b;
    }
}