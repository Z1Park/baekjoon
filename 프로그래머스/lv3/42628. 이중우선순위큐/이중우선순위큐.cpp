#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> oper) {
    priority_queue<int> pq;
    int cnt = 0;
    for (auto op : oper) {
        if (op[0] == 'I') pq.push(stoi(op.substr(2)));
        else {
            if (pq.empty()) continue;
            if (op[2] == '1') pq.pop();
            else cnt++;
        }
    }
    int maxVal = 0, minVal = 0;
    if (pq.size() >= cnt + 1) {
        maxVal = pq.top();
        while (pq.size() > cnt + 1) pq.pop();
        minVal = pq.top();
    }
    return {maxVal, minVal};
}