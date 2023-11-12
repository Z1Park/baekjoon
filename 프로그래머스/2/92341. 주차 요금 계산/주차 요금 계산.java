import java.util.*;
import java.util.stream.*;
import javafx.util.Pair;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingMap = new HashMap<>();
        Map<String, Integer> feeMap = new TreeMap<>();
        for (String record : records) {
            String[] arr = record.split(" ");
            String[] timeStr = arr[0].split(":");
            int time = Integer.parseInt(timeStr[0]) * 60 + 
                Integer.parseInt(timeStr[1]);
            if (arr[2].equals("IN")) parkingMap.put(arr[1], time);
            else {
                int inTime = parkingMap.get(arr[1]);
                parkingMap.remove(arr[1]);
                feeMap.put(arr[1], feeMap.getOrDefault(arr[1], 0)+time-inTime);
            }
        }
        for (Map.Entry<String, Integer> entry : parkingMap.entrySet()) {
            String key = entry.getKey();
            feeMap.put(
                key, feeMap.getOrDefault(key, 0) + 1439 - entry.getValue());
        }
        return feeMap.values().stream()
            .mapToInt(Integer::intValue)
            .map(time -> {
                if (time <= fees[0]) return fees[1];
                else
                    return (fees[1] + (int)Math.ceil(
                        (double)(time - fees[0]) / fees[2]) * fees[3]);
            }).toArray();
    }
}