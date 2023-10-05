#include <string>
#include <vector>
#include <algorithm>

using namespace std;

char words[5] = {'A', 'E', 'I', 'O', 'U'};
vector<string> dic;

void comb(string& res, int lim, int next) {
    res.push_back(words[next]);
    if (lim == res.size()) {
        dic.push_back(res);
        res.pop_back();
        return;
    }
    for (int i = 0; i < 5; i++)
        comb(res, lim, i);
    res.pop_back();
}

#include <iostream>
int solution(string word) {
    string tmp;
    for (int i = 1; i <= 5; i++) {
        for (int j = 0; j < 5; j++)
            comb(tmp, i, j);
    }
    sort(dic.begin(), dic.end());
    for (int i = 0; i < dic.size(); i++)
        if (dic[i] == word) return i+1;
    return 0;
}