class Solution
{
    public int solution(int n, int a, int b)
    {
        a -= 1;
        b -= 1;
        int answer = 1;
        while (a != b) {
            n /= 2;
            a /= 2;
            b /= 2;
            answer++;
        }
        return answer-1;
    }
}