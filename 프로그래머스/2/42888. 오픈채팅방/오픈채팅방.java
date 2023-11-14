import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = Arrays.stream(record)
            .map(str -> str.split(" "))
            .filter(arr -> arr.length > 2)
            .collect(Collectors.toMap(arr -> arr[1], arr -> arr[2], 
                                     (oldValue, newValue) -> newValue));
        return Arrays.stream(record)
            .map(str -> str.split(" "))
            .filter(arr -> !arr[0].equals("Change"))
            .map(arr -> {
                if (arr[0].equals("Enter"))
                    return (map.get(arr[1]) + "님이 들어왔습니다.");
                else return (map.get(arr[1]) + "님이 나갔습니다.");
            }).toArray(String[]::new);
    }
}