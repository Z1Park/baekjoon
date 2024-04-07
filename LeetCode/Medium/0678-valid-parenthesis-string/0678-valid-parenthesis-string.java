class Solution {
    public boolean checkValidString(String s) {
        int omin = 0, omax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                omin++;
                omax++;
            }
            else if (c == ')') {
                omin--;
                omax--;
            }
            else {
                omin--;
                omax++;
            }
            
            if (omax < 0) return false;
            if (omin < 0) omin = 0;
        }
        return omin == 0;
    }
}