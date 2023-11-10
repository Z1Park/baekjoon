// brown = 2 * (a + b) - 4
// yellow = (a - 2) * (b - 2)
class Solution {
    public int[] solution(int brown, int yellow) {
        int apb = (brown + 4) / 2;
        int ab = yellow + 2 * apb - 4;
        int h = 3, w = apb - h;
        while (w >= h) {
            if (w*h == ab) {
                int[] res = new int[]{w, h};
                return res;
            }
            h++;
            w = apb - h;
        }
        return new int[]{1, 1};
    }
}