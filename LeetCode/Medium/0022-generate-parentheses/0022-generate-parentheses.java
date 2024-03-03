class Solution {
    
    private List<String> result = new ArrayList<>();
    private List<Boolean> buffer = new ArrayList<>();
    
    
    private void makeParentheses(int n, int left, int right) {
        if (left == n && right == n) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : buffer)
                sb.append(b ? '(' : ')');
            result.add(sb.toString());
            return;
        }
        if (left < n) {
            buffer.add(true);
            makeParentheses(n, left+1, right);
            buffer.remove(buffer.size()-1);
        }
        if (right < left) {
            buffer.add(false);
            makeParentheses(n, left, right+1);
            buffer.remove(buffer.size()-1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        makeParentheses(n, 0, 0);
        return result;
    }
}