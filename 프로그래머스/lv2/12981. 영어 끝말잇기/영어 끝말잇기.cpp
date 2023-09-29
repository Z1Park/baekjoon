#include <string>
#include <vector>
#include <set>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    set<string> s;
    s.insert(words[0]);
    int idx = 2;
    int round = 1;
    for (int i = 1; i < words.size(); i++) {
        auto it = s.find(words[i]);
        if (words[i-1].back() != words[i][0] || it != s.end()) {
            answer.push_back(idx);
            answer.push_back(round);
            break;
        }
        s.insert(words[i]);
        if (++idx > n) {
            idx = 1;
            round++;
        }
    }
    if (answer.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    }
    return answer;
}