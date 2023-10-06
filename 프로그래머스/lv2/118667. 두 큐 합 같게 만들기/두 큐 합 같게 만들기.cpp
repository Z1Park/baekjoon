#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> q1, vector<int> q2) {
    int cnt = 0, idx1 = 0, idx2 = 0, total = q1.size() * 3;
    long long s1 = accumulate(q1.begin(), q1.end(), 0);
    long long s2 = accumulate(q2.begin(), q2.end(), 0);
    while (idx1 < q1.size() || idx2 < q2.size()) {
        if (s1 == s2) return cnt;
        if (s1 > s2) {
            if (idx1 >= q1.size()) return -1;
            s1 -= q1[idx1];
            s2 += q1[idx1];
            q2.push_back(q1[idx1++]);
        }
        else {
            if (idx2 >= q2.size()) return -1;
            s1 += q2[idx2];
            s2 -= q2[idx2];
            q1.push_back(q2[idx2++]);
        }
        if (cnt++ > total) return -1; 
    }
}