#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> topping) {
    unordered_map<int, int> left;
    unordered_map<int, int> right;
    for (int t : topping) right[t]++;
    int count = 0;
    for (int t : topping) {
        left[t]++;
        if (--right[t] == 0) right.erase(t);
        if (left.size() == right.size()) count++;
    }
    return count;
}