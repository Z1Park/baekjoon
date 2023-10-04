#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

bool solution(vector<string> pb) {
    unordered_set<string> s;
    for (auto num : pb) s.insert(num);
    for (auto num : pb) {
        for (int i = 1; i < num.size(); i++) {
            auto it = s.find(num.substr(0, i));
            if (it != s.end()) return false;
        }
    }
    return true;
}