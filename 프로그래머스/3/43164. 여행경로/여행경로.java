import java.util.*;

class Solution {
    
    private Map<String, List<String>> ticketMap = new HashMap<>();
    private Map<String, boolean[]> usedMap = new HashMap<>();
    private Deque<String> tmp = new ArrayDeque<>();
    private List<String> res;
    
    private boolean checkUsed(String curr, boolean[] used) {
        for (boolean u : used) {
            if (!u) return false;
        }
        return true;
    }
    
    private boolean checkAllUsed(String curr) {
        for (boolean[] used : usedMap.values()) {
            for (boolean u : used) {
                if (!u) return false;
            }
        }
        return true;
    }
    
    private boolean compare() {
        int idx = 0;
        for (String o1 : tmp) {
            String o2 = res.get(idx++);
            if (o1.compareTo(o2) < 0) return true;
            else if (o1.compareTo(o2) > 0) return false;
        }
        return false;
    }
    
    private void dfs(String curr) {
        boolean[] used = usedMap.get(curr);
        if (checkUsed(curr, used) && checkAllUsed(curr)) {
            if (res == null || tmp.size() >= res.size() && compare())
                res = new ArrayList<>(tmp);
            return;
        }
        
        List<String> ticketList = ticketMap.get(curr);
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            String next = ticketList.get(i);
            tmp.addLast(next);
            dfs(next);
            tmp.pollLast();
            used[i] = false;
        }
    }
    
    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            ticketMap.computeIfAbsent(ticket[0], k -> new ArrayList<>())
                .add(ticket[1]);
            ticketMap.computeIfAbsent(ticket[1], k -> new ArrayList<>());
        }
        ticketMap.entrySet().stream()
            .forEach(e -> usedMap.computeIfAbsent(
                    e.getKey(), k -> new boolean[e.getValue().size()]));
        tmp.add("ICN");
        dfs("ICN");
        return res.stream().toArray(String[]::new);
    }
}