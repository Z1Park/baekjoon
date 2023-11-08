#include <bits/stdc++.h>

using namespace std;

int getCount(vector<vector<int>>& wires, vector<bool>& visit, int n, int cutEdge) {
    int cnt = 0;
    deque<int> dq;
    for (int i = 1; i <= n; i++) {
        if (!visit[i]) {
            visit[i] = true;
            dq.push_back(i);
            cnt++;
            break;
        }
    }
    while (!dq.empty()) {
        int curr = dq.front();
        dq.pop_front();
        for (int i = 0; i < wires.size(); i++) {
            if (i == cutEdge) continue;
            if (!visit[wires[i][0]] && visit[wires[i][1]]) {
                visit[wires[i][0]] = true;
                dq.push_back(wires[i][0]);
                cnt++;
            }
            if (!visit[wires[i][1]] && visit[wires[i][0]]) {
                visit[wires[i][1]] = true;
                dq.push_back(wires[i][1]);
                cnt++;
            }
        }
    }
    return cnt;
}

int bfs(int n, vector<vector<int>>& wires, int cutEdge) {
    vector<bool> visit(n+1);
    int cnt1 = getCount(wires, visit, n, cutEdge);
    int cnt2 = getCount(wires, visit, n, cutEdge);
    return abs(cnt1 - cnt2);
}

int solution(int n, vector<vector<int>> wires) {
    int minVal = 101;
    for (int i = 0; i < wires.size(); i++) {
        int cnt = bfs(n, wires, i);
        if (minVal > cnt) minVal = cnt;
    }
    return minVal;
}