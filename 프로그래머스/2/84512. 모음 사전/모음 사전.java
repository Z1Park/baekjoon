class Solution {
    
    private int getIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'E': return 1;
            case 'I': return 2;
            case 'O': return 3;
            case 'U': return 4;
        }
        return -1;
    }
    
    public int solution(String word) {
        int[] cnts = new int[]{781, 156, 31, 6, 1};
        int res = word.length();
        for (int i = 0; i < word.length(); i++)
            res += getIndex(word.charAt(i)) * cnts[i];
        return res;
    }
}