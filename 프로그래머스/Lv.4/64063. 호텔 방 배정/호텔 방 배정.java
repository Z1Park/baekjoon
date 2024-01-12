import java.util.*;

class Solution {
    
    private Map<Long, Long> parent = new HashMap<>();
    
    private long find(long x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            return x;
        }
        if (x == parent.get(x)) return x;
        long p = find(parent.get(x));
        parent.put(x, p);
        return p;
    }
    
    private boolean union(long x, long y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return false;
        if (x < y) parent.put(x, y);
        else parent.put(y, x);
        return true;
    }
    
    public long[] solution(long k, long[] room_number) {
        List<Long> res = new ArrayList<>();
        for (long room : room_number) {
            long root = find(room);
            res.add(root);
            union(root, root+1);
        }
        return res.stream().mapToLong(Long::longValue).toArray();
    }
}