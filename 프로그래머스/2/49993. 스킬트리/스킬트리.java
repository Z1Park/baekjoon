import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) s.add(skill.charAt(i));
        int res = skill_trees.length;
        for (String skillTree : skill_trees) {
            int idx = 0;
            for (int i = 0; i < skillTree.length(); i++) {
                if (s.contains(skillTree.charAt(i))) {
                    if (skill.charAt(idx) == skillTree.charAt(i)) idx++;
                    else {
                        res--;
                        break;
                    }
                }
            }
        }
        return res;
    }
}