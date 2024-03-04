class Solution {
    
    private List<List<String>> result = new ArrayList<>(); 
    private Deque<String> buffer = new ArrayDeque<>();
    
    
    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length()-1; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
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
            String partition = s.substring(idx, i);
            if (isPalindrome(partition)) {
                buffer.add(partition);
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