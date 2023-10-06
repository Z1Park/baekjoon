#include <bits/stdc++.h>

using namespace std;

string solution(string number, int k) {
    string stk;
    for (int i = 0; i < number.size(); i++) {
        while (!stk.empty() && stk.back() < number[i] && k > i - stk.size())
            stk.pop_back();
        if (stk.size() < number.size() - k) stk.push_back(number[i]);
    }
    return stk;
}