class Solution {
    
    private List<List<String>> result = new ArrayList<>(); 
    private Deque<String> buffer = new ArrayDeque<>();
    
    
    private boolean isPalindrome(String str, int l, int r) {
        for (; l < r; l++, r--) {
            if (str.charAt(l) != str.charAt(r))
                return false;
        }
        return true;
    }
    
    private void makeCombination(String s, int idx) {
        if (idx >= s.length()) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        
        for (int i = idx+1; i <= s.length(); i++) {
            if (isPalindrome(s, idx, i-1)) {
                if (idx == i-1) buffer.add(Character.toString(s.charAt(idx)));
                else buffer.add(s.substring(idx, i));
                makeCombination(s, i);
                buffer.pollLast();
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        makeCombination(s, 0);
        return result;
    }
}