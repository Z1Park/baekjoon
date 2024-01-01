import java.util.*;
import java.util.stream.*;

class Solution {
    
    private class Data {
        public int remainTime;
        public String name;
        
        public Data(int remainTime, String name) {
            this.remainTime = remainTime;
            this.name = name;
        }
    }
    
    private int getTime(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, Comparator.comparing(arr -> arr[1]));
        Deque<Data> dq = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        int curr = 0;
        for (String[] plan : plans) {
            String name = plan[0];
            int startTime = getTime(plan[1]);
            int duration = Integer.parseInt(plan[2]);
            while (!dq.isEmpty() && curr < startTime) {
                Data work = dq.pollLast();
                int end = curr + work.remainTime;
                if (end <= startTime) {
                    curr = end;
                    res.add(work.name);
                }
                else {
                    work.remainTime = end - startTime;
                    dq.addLast(work);
                    curr =  startTime;
                }
            }
            if (curr != startTime) curr = startTime;
            dq.addLast(new Data(duration, name));
        }
        while (!dq.isEmpty())
            res.add(dq.pollLast().name);
        return res.stream().toArray(String[]::new);
    }
}