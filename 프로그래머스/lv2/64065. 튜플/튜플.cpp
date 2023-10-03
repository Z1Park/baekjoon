#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

bool cmp(vector<int>& a, vector<int>& b) {
    return a.size() < b.size();
}

#include <iostream>
vector<int> solution(string s) {
    vector<vector<int>> vec;
    int idx = 0;
    while (idx < s.size()) {
        while (s[idx] == '{') {
            idx++;
            continue;
        }
        vector<int> elem;
        while (idx < s.size() && s[idx] != '}') {
            string temp;
            while (idx < s.size() && s[idx] != ',' && s[idx] != '}') {
                temp.push_back(s[idx]);
                idx++;
            }
            if (s[idx] == ',') idx++;
            elem.push_back(stoi(temp));
        }
        vec.push_back(elem);
        while (s[idx] == '}') idx++;
        if (idx < s.size() && s[idx] == ',') idx++;
    }
    sort(vec.begin(), vec.end(), cmp);
    unordered_map<int, int> m;
    for (int i = 0; i < vec.size(); i++) {
        for (auto v : vec[i]) {
            auto it = m.find(v);
            if (it == m.end()) m.insert({v, i});
        }
    }
    vector<int> res(m.size());
    for (auto e : m) res[e.second] = e.first;
    return res;
}