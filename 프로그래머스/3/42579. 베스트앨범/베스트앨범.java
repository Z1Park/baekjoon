import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++)
            genreMap.computeIfAbsent(genres[i], e -> new ArrayList<>())
                .add(new int[]{i, plays[i]});
        return genreMap.values().stream()
            .sorted(Comparator.comparing(
                e -> -e.stream().mapToInt(arr -> arr[1]).sum()))
            .flatMapToInt(e -> e.stream()
                          .sorted(Comparator.comparing(arr -> -arr[1]))
                          .mapToInt(arr -> arr[0]).limit(2))
            .toArray();
    }
}