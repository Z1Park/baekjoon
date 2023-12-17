class Solution {
    
    private int getCountFromMidNight(double h, double m, double s) {
        double sec = s * 6, min = m * 6 + s * 0.1;
        double hour = (h * 30 + m * 0.5 + s / 120) % 360;
        int cnt = -1;
        cnt += (int)((h * 60 + m) * 2 - h);
        if (min <= sec) cnt++;
        if (hour <= sec) cnt++;
        if (12 <= h) cnt -= 2;
        return cnt;
    }
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int cnt = getCountFromMidNight(h2, m2, s2) - getCountFromMidNight(h1, m1, s1);
        if ((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0)
            cnt++;
        return cnt;
    }
}