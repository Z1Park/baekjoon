#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string transNum(int num, int base) {
    string tmp;
    while (num > 0) {
        int mod = num % base;
        if (mod < 10) tmp.push_back(mod + '0');
        else tmp.push_back(mod - 10 + 'A');
        num /= base;
    }
    reverse(tmp.begin(), tmp.end());
    return tmp;
}

string solution(int n, int t, int m, int p) {
    string answer = "";
    int num = 0, strIdx = 0, personIdx = 1;
    string currStr = "0";
    while (answer.size() < t) {
        if (personIdx++ == p) answer.push_back(currStr[strIdx]);
        if (personIdx > m) personIdx = 1;
        if (++strIdx >= currStr.size()) {
            currStr = transNum(++num, n);
            strIdx = 0;
        }
    }
    return answer;
}