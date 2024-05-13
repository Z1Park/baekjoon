class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] split = path.split("/");
        int[] lengthStack = new int[split.length];
        int idx = -1;
        for (String s : split) {
            if (s.length() == 0 || s.equals(".")) continue;
            if (s.equals("..")) {
                if (sb.length() != 0)
                    sb.delete(sb.length() - lengthStack[idx--], sb.length());
                continue;
            }
            sb.append("/");
            sb.append(s);
            lengthStack[++idx] = s.length() + 1;
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}