class Solution {
    
    public String decodeString(String str) {
        StringBuilder sb = new StringBuilder();
        int idx = 0, repeat;
        while (Character.isDigit(str.charAt(idx)))
            idx++;
        if (idx == 0) repeat = 1;
        else repeat = Integer.parseInt(str.substring(0, idx++));
        
        int start = idx;
        while (idx < str.length() && Character.isLetter(str.charAt(idx)))
            idx++;
        String newString = str.substring(start, idx);
        
        if (idx == str.length()) return newString;
        if (str.charAt(idx) != ']') {
            int count = 1, end = idx+1;
            while (end < str.length()) {
                if (str.charAt(end) == '[') count++;
                else if (str.charAt(end) == ']') count--;
                if (count == 0) break;
                end++;
            }
            newString += decodeString(str.substring(idx, end));
            idx = end;
        }
        for (int i = 0; i < repeat; i++)
            sb.append(newString);
        
        idx++;
        if (idx <= str.length() - 1)
            sb.append(decodeString(str.substring(idx)));
        return sb.toString();
    }
}