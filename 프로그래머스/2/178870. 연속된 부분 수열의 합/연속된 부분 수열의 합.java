class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] res = new int[]{0, sequence.length - 1};
        int left = 0, right = 0, totalSum = sequence[0];
        while (right < sequence.length) {
            if (totalSum == k) {
                if (res[1] - res[0] > right - left)
                    res = new int[]{left, right};
                totalSum -= sequence[left++];
            }
            else if (totalSum < k) {
                right++;
                if (right < sequence.length)
                    totalSum += sequence[right];
            }
            else {
                totalSum -= sequence[left++];
            }
        }
        return res;
    }
}