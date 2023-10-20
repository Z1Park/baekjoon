#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> pii;

int solution(vector<vector<string>> book_time) {
    vector<pii> times;
    for (auto bt : book_time) {
        int start = stoi(bt[0].substr(0, 2)) * 60 + stoi(bt[0].substr(3, 2));
        int end = stoi(bt[1].substr(0, 2)) * 60 + stoi(bt[1].substr(3, 2)) + 10;
        times.push_back({start, end});
    }
    sort(times.begin(), times.end());
    priority_queue<int, vector<int>, greater<int>> pq;
    pq.push(times[0].second);
    for (int i = 1; i < times.size(); i++) {
        if (times[i].first >= pq.top()) pq.pop();
        pq.push(times[i].second);
    }
    return pq.size();
}