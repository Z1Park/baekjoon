import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = Arrays.stream(gems).collect(toSet());
        Map<String, Integer> rangeMap = new HashMap<>();
        rangeMap.put(gems[0], 1);
        int[] res = new int[]{1, gems.length};
        int left = 0, right = 0;
        System.out.println(gemSet.size());
        while (right < gems.length) {
            if (rangeMap.size() == gemSet.size()) {
                if (res[1] - res[0] > right - left) {
                    res[1] = right+1;
                    res[0] = left+1;
                }
                if (rangeMap.get(gems[left]) == 1) rangeMap.remove(gems[left]);
                else rangeMap.put(gems[left], rangeMap.get(gems[left]) - 1);
                left++;
            }
            else if (rangeMap.size() < gemSet.size()) {
                right++;
                if (right >= gems.length) break;
                rangeMap.put(gems[right], rangeMap.getOrDefault(gems[right], 0) + 1);
            }
            else {
                if (rangeMap.get(gems[left]) == 1) rangeMap.remove(gems[left]);
                else rangeMap.put(gems[left], rangeMap.get(gems[left]) - 1);
                left++;
            }
            if (left == right) {
                right++;
                if (right >= gems.length) break;
                rangeMap.put(gems[right], rangeMap.getOrDefault(gems[right], 0) + 1);
            }
        }
        return res;
    }
}