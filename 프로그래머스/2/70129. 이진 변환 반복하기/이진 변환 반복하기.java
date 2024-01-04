class Solution {
    public int[] solution(String s) {
        int transCount = 0, removeCount = 0;
        for (; s.length() > 1; transCount++) {
            int tmp = s.length();
            s = s.replace("0", "");
            removeCount += tmp - s.length();
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{transCount, removeCount};
    }
}