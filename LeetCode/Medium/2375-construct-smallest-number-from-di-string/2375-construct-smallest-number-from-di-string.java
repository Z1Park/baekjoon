class Solution {
    
    private int result = Integer.MAX_VALUE;
    
    private void dfs(String pattern, Set<Integer> buffer, int last, int idx) {
        if (idx >= pattern.length()) {
            int tmp = 0;
            for (int e : buffer)
                tmp = tmp * 10 + e;
            if (result > tmp)
                result = tmp;
            return;
        }
        
        if (pattern.charAt(idx) == 'I') {
            for (int i = last+1; i < 10; i++) {
                if (buffer.contains(i)) continue;
                buffer.add(i);
                dfs(pattern, buffer, i, idx+1);
                buffer.remove(i);
            }
        }
        else {
            for (int i = 1; i < last; i++) {
                if (buffer.contains(i)) continue;
                buffer.add(i);
                dfs(pattern, buffer, i, idx+1);
                buffer.remove(i);
            }
        }
    }
    
    public String smallestNumber(String pattern) {
        Set<Integer> buffer = new LinkedHashSet<>();
        for (int i = 1; i < 10; i++) {
            buffer.add(i);
            dfs(pattern, buffer, i, 0);
            buffer.remove(i);
        }
        return Integer.toString(result);
    }
}