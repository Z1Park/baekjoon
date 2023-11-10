class Solution {
    public int[] solution(String s) {
        int transCount = 0;
        int removeCount = 0;
        while (s.length() > 1) {
            transCount += 1;
            int tmp = s.length();
            s = s.replace("0", "");
            removeCount += tmp - s.length();
            tmp = s.length();
            s = Integer.toBinaryString(tmp);
        }
        int[] res = {transCount, removeCount};
        return res;
    }
}