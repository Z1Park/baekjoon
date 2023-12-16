class Solution {
    public long solution(int w, int h) {
        if (w == h) return (long)w * (w - 1);
        long answer = (long)w * h;
        for (int i = 1; i <= w; i++)
            answer -= (long)(Math.ceil((double)i * h / w) 
                             - Math.floor((double)(i - 1) * h / w));
        return answer;
    }
}