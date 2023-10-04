#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

bool checkSkillTree(unordered_map<char, int>& m, string& st) {
    int idx = 0;
    for (auto c : st) {
        auto it = m.find(c);
        if (it != m.end()) {
            if (it->second == idx) {
                idx++;
                if (idx == m.size() - 1) return true;
            }
            else return false;
        }
    }
    return true;
}

int solution(string skill, vector<string> skill_trees) {
    unordered_map<char, int> m;
    for (int i = 0; i < skill.size(); i++) m.insert({skill[i], i});
    int cnt = 0;
    for (auto st : skill_trees) {
        if (checkSkillTree(m, st)) cnt++;
    }
    return cnt;
}