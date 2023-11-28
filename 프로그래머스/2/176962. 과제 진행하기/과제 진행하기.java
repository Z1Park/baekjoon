import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private class Data {
        private String language;
        private int startTime;
        private int playTime;
        
        Data(String[] arr) {
            language = arr[0];
            String[] tmp = arr[1].split(":");
            startTime = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
            playTime = Integer.parseInt(arr[2]);
        }
        
        public String toString() {
            return String.format("[language: %s, start: %d, end: %d]",
                                language, startTime, playTime);
        }
    }
    
    public String[] solution(String[][] plans) {
        List<Data> dataList = Arrays.stream(plans).map(Data::new)
            .sorted(new Comparator<Data>(){
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.startTime - o2.startTime;
                }
            })
            .collect(toList());
        Deque<Data> waitQueue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        Data curr = dataList.get(0);
        for (int i = 1; i < dataList.size(); i++) {
            Data next = dataList.get(i);
            if (curr.startTime + curr.playTime <= next.startTime) {
                res.add(curr.language);
                int currTime = curr.startTime + curr.playTime;
                while (!waitQueue.isEmpty()) {
                    Data tmp = waitQueue.pollLast();
                    if (currTime + tmp.playTime <= next.startTime) {
                        currTime += tmp.playTime;
                        res.add(tmp.language);
                    }
                    else {
                        tmp.playTime -= next.startTime - currTime;
                        waitQueue.addLast(tmp);
                        break;
                    }
                }
            }
            else {
                curr.playTime -= next.startTime - curr.startTime;
                waitQueue.addLast(curr);
            }
            if (i != dataList.size() - 1) curr = next;
            else res.add(next.language);
        }
        while (!waitQueue.isEmpty())
            res.add(waitQueue.pollLast().language);
        return res.stream().toArray(String[]::new);
    }
}