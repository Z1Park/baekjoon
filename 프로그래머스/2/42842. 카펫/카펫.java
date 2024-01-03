// brown = 2 * (width + height) - 4
// yellow = (width - 2) * (heigth - 2)

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            int height = i + 2, width = yellow / i + 2;
            if (2 * (width + height) - 4 == brown)
                return new int[]{width, height};
        }
        return new int[]{-1, -1};
    }
}