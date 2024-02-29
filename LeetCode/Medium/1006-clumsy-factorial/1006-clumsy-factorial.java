class Solution {
    
    private long calculate(char oper, long value, int n) {
        switch(oper) {
            case '*': return value * n;
            case '/': return value / n;
            case '+': return value + n;
            case '-': return value - n;
            default: return -1;
        }
    }
    
    public int clumsy(int n) {
        if (n == 1) return 1;
        List<Long> values = new ArrayList<>();
        long value = n--;
        int idx = 0;
        String opers = "*/+-";
        
        while (n > 0) {
            if (idx < 2) {
                value = calculate(opers.charAt(idx), value, n--);
            }
            else {
                values.add(value);
                value = n--;
            }
            if (n == 0) values.add(value);
            idx = (idx + 1) % 4;
        }
        
        value = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            if (i%2 == 1) value += values.get(i);
            else value -= values.get(i);
        }
        return (int)value;
    }
}