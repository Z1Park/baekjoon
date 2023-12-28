import java.util.*;

class Solution {
    
    private Set<Character> skillSet = new HashSet<>();
    
    private boolean checkSkillTree(String skill, String st) {
        int idx = 0;
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            if (skillSet.contains(c)) {
                if (idx >= skill.length() || skill.charAt(idx) != c) 
                    return false;
                else idx++;
            }
        }
        return true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        for (int i = 0; i < skill.length(); i++)
            skillSet.add(skill.charAt(i));
        int cnt = 0;
        for (String skillTree : skill_trees)
            if (checkSkillTree(skill, skillTree)) cnt++;
        return cnt;
    }
}