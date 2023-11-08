#include <bits/stdc++.h>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    if (k >= enemy.size()) return enemy.size();
    priority_queue<int, vector<int>, greater<int>> pq;
    int total = 0, queSum = 0;
    for (int i = 0; i < enemy.size(); i++) {
        pq.push(enemy[i]);
        total += enemy[i];
        queSum += enemy[i];
        if (pq.size() > k) {
            queSum -= pq.top();
            pq.pop();
        }
        if (total - queSum > n) return i;
    }
    return enemy.size();
}