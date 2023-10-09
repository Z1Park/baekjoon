#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<vector<int>> coms) {
    int cnt = 0;
    deque<int> dq;
    for (int i = 0; i < n; i++) {
        if (accumulate(coms[i].begin(), coms[i].end(), 0) == 0) continue;
        cnt++;
        dq.push_back(i);
        while (!dq.empty()) {
            int curr = dq.front();
            dq.pop_front();
            coms[curr][curr] = 0;
            for (int i = 0; i < n; i++) {
                if (curr == i) continue;
                if (coms[curr][i] == 1) {
                    coms[curr][i] = 0;
                    coms[i][curr] = 0;
                    dq.push_back(i);
                }
            }
        }
    }
    return cnt;
}