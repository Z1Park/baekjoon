#include <string>
#include <vector>

using namespace std;

string intToBin(int n) {
    string s;
    while (n > 0) {
        s.append(1, n % 2 + '0');
        n /= 2;
    }
    return s;
}

vector<int> solution(string s) {
    int cnt = 0;
    int zero = 0;
    while (s.length() != 1) {
        cnt++;
        int tmp = 0;
        for (auto c : s) (c == '0') ? zero++ : tmp++;
        s = intToBin(tmp);
    }
    return {cnt, zero};
}