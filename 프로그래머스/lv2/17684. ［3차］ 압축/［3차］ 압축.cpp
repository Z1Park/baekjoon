#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

#include <iostream>
vector<int> solution(string msg) {
    unordered_map<string, int> m;
    for (int i = 0; i < 26; i++) {
        string tmp;
        tmp.push_back('A' + i);
        m.insert({tmp, i + 1});
    }
    int maxIdx = 27;
    vector<int> res;
    for (int i = 0; i < msg.size(); i++) {
        int prev = 0;
        string tmp;
        for (int j = i; j < msg.size(); j++) {
            tmp.push_back(msg[j]);
            auto it  = m.find(tmp);
            if (it == m.end()) {
                m.insert({tmp, maxIdx++});
                i = j - 1;
                break;
            }
            prev = it->second;
            if (j == msg.size()-1) i = j;
        }
        if (i < msg.size()) res.push_back(prev);
    }
    return res;
}