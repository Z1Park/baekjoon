class Solution {
    public long solution(int w, int h) {
        double lin = (double) h / w;
        long count = (long) w * h, l, r;
        for (int i = 1; i <= w; i++) {
            l = (long)Math.floor((double) h * (i-1) / w);
            r = (long)Math.ceil((double) h * i / w);
            count -= r - l;
        }
        return count;
    }
}