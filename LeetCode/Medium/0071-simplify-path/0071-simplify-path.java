class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        String[] stack = new String[split.length];
        int idx = -1;
        for (String s : split) {
            if (s.length() == 0 || s.equals(".")) continue;
            if (s.equals("..")) {
                if (idx >= 0) idx--;
                continue;
            }
            stack[++idx] = s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= idx; i++)
            sb.append("/" + stack[i]);
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}