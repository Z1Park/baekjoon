class Solution {
    
    private List<List<Integer>> combinations = new ArrayList<>(); 
    private Deque<Integer> buffer = new ArrayDeque<>();
    
    
    private boolean isPalindrome(String str, int l, int r) {
        for (; l < r; l++, r--) {
            if (str.charAt(l) != str.charAt(r))
                return false;
        }
        return true;
    }
    
    private void makeCombination(String s, int idx) {
        if (idx >= s.length()) {
            combinations.add(new ArrayList<>(buffer));
            return;
        }
        
        for (int i = idx+1; i <= s.length(); i++) {
            if (isPalindrome(s, idx, i-1)) {
                buffer.add(i);
                makeCombination(s, i);
                buffer.pollLast();
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        makeCombination(s, 0);
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> combination : combinations) {
            int idx = 0;
            List<String> tmp = new ArrayList<>();
            for (int i : combination) {
                tmp.add(s.substring(idx, i));
                idx = i;
            }
            result.add(tmp);
        }
        return result;
    }
}