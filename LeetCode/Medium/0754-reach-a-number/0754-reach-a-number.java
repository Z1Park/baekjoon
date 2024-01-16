class Solution {
    public int reachNumber(int target) {
        if (target < 0) target *= -1;
        int start = 1, end = target;
        long sum = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            sum = (long)mid * (mid + 1) / 2;
            if (sum >= target) end = mid - 1;
            else start = mid + 1;
        }
        sum = (long)start * (start + 1) / 2;
        // 어떤 step을 음수로 계산 시 sum에서 step * 2만큼 빠짐 -> target을 넘는 가장 작은 sum을 구하고 pos와 target의 차가 짝수가 되도록 만들면 원하는 값을 만들 수 있다.
        while ((sum - target) % 2 != 0)
            sum += ++start;
        return start;
    }
}