#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int n) {
    vector<vector<int>> vec(n);
    for (int i = 0; i < n; i++) vec[i].resize(i+1);
    int r = 0, c = 0, curr = 1, total = n * (n + 1) / 2;
    while (curr <= total) {
        while (r < n) {
            if (vec[r][c] != 0) break;
            vec[r++][c] = curr++;
        }
        cout << curr << " / " << total << endl;
        if (curr > total) break;
        r--;
        c++;
        while (c <= r) {
            if (vec[r][c] != 0) break;
            vec[r][c++] = curr++;
        }
        if (curr > total) break;
        r--;
        c -= 2;
        while (true) {
            if (vec[r][c] != 0) break;
            vec[r--][c--] = curr++;
        }
        r += 2;
        c++;
    }
    vector<int> res;
    for (int i = 0; i < vec.size(); i++)
        for (auto v : vec[i]) res.push_back(v);
    return res;
}