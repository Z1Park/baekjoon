import java.util.*;

class Solution {
    
    private int getTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60
            + Integer.parseInt(time.substring(3, 5));
    }
    
    private int getFee(int[] fees, int time) {
        if (time <= fees[0]) return fees[1];
        return fees[1] + 
            (int)Math.ceil(((double)time - fees[0]) / fees[2]) * fees[3];
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Integer>> map = new TreeMap<>();
        for (String record : records) {
            String[] tmp = record.split(" ");
            int time = getTime(tmp[0]);
            map.computeIfAbsent(tmp[1], k -> new ArrayList<>())
                .add(time);
        }
        List<Integer> res = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            if (list.size() % 2 != 0)
                list.add(1439);
            int totalTime = 0;
            for (int i = 0; i < list.size(); i += 2)
                totalTime += list.get(i+1) - list.get(i);
            res.add(getFee(fees, totalTime));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}