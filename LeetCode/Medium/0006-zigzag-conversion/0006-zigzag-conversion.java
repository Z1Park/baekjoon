class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        int mod = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int diff = mod - i * 2;
            for (int j = i; j < s.length(); j += mod) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows-1 && j + diff < s.length())
                    sb.append(s.charAt(j + diff));
            }
        }
        return sb.toString();
    }
}