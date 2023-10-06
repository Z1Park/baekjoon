#include <string>
#include <bits/stdc++.h>

using namespace std;

long long f(long long number) {
    string str;
    bool firstZero = false;
    while (number > 0) {
        str.push_back(number % 2 + '0');
        if (!firstZero && str[str.size()-1] == '0') {
            firstZero = true;
            str[str.size()-1] = '1';
            if (str.size() > 1) str[str.size()-2] = '0';
        }
        number /= 2;
    }
    reverse(str.begin(), str.end());
    if (!firstZero) {
        str[0] = '0';
        str = '1' + str;
    }
    long long res = 0;
    for (char c : str) res = res * 2 + c - '0';
    return res;
}

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    for (auto number : numbers) answer.push_back(f(number));
    return answer;
}