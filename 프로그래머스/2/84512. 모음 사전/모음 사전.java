class Solution {
    public int solution(String word) {
        int[] cnts = new int[]{781, 156, 31, 6, 1};
        int res = word.length();
        for (int i = 0; i < word.length(); i++)
            res += "AEIOU".indexOf(word.charAt(i)) * cnts[i];
        return res;
    }
}