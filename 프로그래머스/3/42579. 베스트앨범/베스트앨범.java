import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (genreMap.containsKey(genres[i])) {
                List<int[]> currGenre = genreMap.get(genres[i]);
                currGenre.add(new int[]{plays[i], i});
            }
            else {
                List<int[]> currGenre = new ArrayList<>();
                currGenre.add(new int[]{plays[i], i});
                genreMap.put(genres[i], currGenre);
            }
        }
        return genreMap.values().stream()
            .sorted(Comparator.comparing(list -> -list.stream().mapToInt(arr -> arr[0]).sum()))
            .flatMapToInt(list -> list.stream()
                          .sorted(Comparator.comparing(arr -> -arr[0]))
                          .mapToInt(arr -> arr[1]).limit(2))
            .toArray();
    }
}