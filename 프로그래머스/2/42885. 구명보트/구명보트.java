import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length-1, move = 0;
        while (left <= right) {
            int boat = people[right--];
            if (limit - boat >= people[left]) left++;
            move++;
        }
        return move;
    }
}