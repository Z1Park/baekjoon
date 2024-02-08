import java.util.*;

class Solution {
    
    private List<Set<Character>> orderSet = new ArrayList<>();
    private Set<Set<Character>> allCourse = new HashSet<>();
    private Set<Character> buffer = new HashSet<>();
    
    
    private void combination(String order, int limit, int start) {
        if (buffer.size() >= limit) {
            allCourse.add(new TreeSet<>(buffer));
            return;
        }
        for (int i = start; i < order.length(); i++) {
            buffer.add(order.charAt(i));
            combination(order, limit, i + 1);
            buffer.remove(order.charAt(i));
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        Set<Integer> courseSet = new HashSet<>();
        for (int c : course) courseSet.add(c);
        for (String order : orders) {
            Set<Character> set = new TreeSet<>();
            for (int i = 0; i < order.length(); i++)
                set.add(order.charAt(i));
            orderSet.add(set);
            for (int i = order.length(); i >= 2; i--) {
                combination(order, i, 0);
            }
        }
        
        Map<Integer, Integer> maxCount = new HashMap<>();
        Map<Integer, List<Set<Character>>> newCourse = new HashMap<>();
        for (Set<Character> set : allCourse) {
            if (!courseSet.contains(set.size())) continue;
            int count = 0;
            for (Set<Character> order : orderSet) {
                if (order.containsAll(set)) count++;
            }
            if (count <= 1) continue;
            if (maxCount.containsKey(set.size())) {
                if (count < maxCount.get(set.size())) continue;
                else if (count > maxCount.get(set.size())) {
                    maxCount.put(set.size(), count);
                    List<Set<Character>> list = newCourse.get(set.size());
                    list.clear();
                    list.add(set);
                }
                else newCourse.get(set.size()).add(set);
            }
            else {
                maxCount.put(set.size(), count);
                List<Set<Character>> list = new ArrayList<>();
                list.add(set);
                newCourse.put(set.size(), list);
            }
        }
        
        return newCourse.values().stream()
            .flatMap(List::stream)
            .map(set -> {
                StringBuilder sb = new StringBuilder();
                for (char c : set) sb.append(c);
                return sb.toString();
            }).sorted().toArray(String[]::new);
    }
}