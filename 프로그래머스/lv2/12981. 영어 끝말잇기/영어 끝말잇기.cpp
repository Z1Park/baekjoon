#include <string>
#include <vector>
#include <set>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    set<string> s;
    s.insert(words[0]);
    for (int i = 1; i < words.size(); i++) {
        if (words[i-1].back() != words[i][0] || s.find(words[i]) != s.end())
            return {i % n + 1, i / n + 1};
        s.insert(words[i]);
    }
    return {0, 0};
}