class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> indexes = new ArrayDeque<>();
        int count = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
                sb.append(c);
                indexes.add(i - tmp);
            }
            else if (c == ')') {
                if (count > 0) {
                    count--;
                    sb.append(c);
                    indexes.pollLast();
                }
                else tmp++;
            }
            else sb.append(c);
        }
        tmp = 0;
        while (count > 0) {
            int idx = indexes.poll() - tmp;
            sb.deleteCharAt(idx);
            count--;
            tmp++;
        }
        return sb.toString();
    }
}