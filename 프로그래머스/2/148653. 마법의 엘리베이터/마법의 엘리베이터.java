class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int mod = storey % 10;
            if (mod < 5 || (mod == 5 && (storey % 100 / 10) < 5)) {
                answer += mod;
                storey /= 10;
            }
            else {
                answer += 10 - mod;
                storey = storey / 10 + 1;
            }
        }
        return answer;
    }
}