class Solution {
    
    private int zeroCount(String bin) {
        int cnt = 0;
        for (int i = 0; i < bin.length(); i++)
            if (bin.charAt(i) == '1') cnt++;
        return cnt;
    }
    
    public int solution(int n) {
        String origin = Integer.toBinaryString(n);
        int cnt = zeroCount(origin);
        for (int i = 1; i < 1000; i++) {
            String tmp = Integer.toBinaryString(n + i);
            if (cnt == zeroCount(tmp)) return n + i;
        }
        return n;
    }
}