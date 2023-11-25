import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private Set<Set<String>> res = new HashSet<>();
    
    private void dfs(List<Set<String>> list, int depth, Set<String> buf) {
        if (depth >= list.size()) {
            res.add(new HashSet<>(buf));
            return;
        }
        List<String> elemList = list.get(depth).stream().collect(toList());
        for (int i = 0; i < elemList.size(); i++) {
            if (buf.contains(elemList.get(i))) continue;
            buf.add(elemList.get(i));
            dfs(list, depth+1, buf);
            buf.remove(elemList.get(i));
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        List<Set<String>> list = new ArrayList<>();
        Set<Set<String>> contain = new HashSet<>();
        for (String ban : banned_id) {
            String regex = ban.replace('*', '.');
            Pattern pattern = Pattern.compile("^" + regex + "$");
            Set<String> tmp = Arrays.stream(user_id)
                .filter(pattern.asPredicate()).collect(toSet());
            list.add(tmp);
        }
        Set<String> tmp = new HashSet<>();
        dfs(list, 0, tmp);
        return res.size();
    }
}