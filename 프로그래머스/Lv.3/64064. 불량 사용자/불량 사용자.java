import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class Solution {
    
    private List<List<String>> matchList = new ArrayList<>();
    private Set<Set<String>> res = new HashSet<>();
    
    private void dfs(int idx, Set<String> used) {
        if (idx >= matchList.size()) {
            res.add(Set.copyOf(used));
            return;
        }
        List<String> tmp = matchList.get(idx);
        for (String e : tmp) {
            if (used.contains(e)) continue;
            used.add(e);
            dfs(idx+1, used);
            used.remove(e);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        for (String ban : banned_id) {
            Pattern pattern = Pattern.compile("^"+ban.replace("*", ".")+"$");
            Set<String> tmp = Arrays.stream(user_id)
                .filter(pattern.asPredicate())
                .collect(Collectors.toSet());
            matchList.add(tmp.stream().collect(Collectors.toList()));
        }
        dfs(0, new HashSet<>());
        return res.size();
    }
}