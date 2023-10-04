#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

typedef long long ll;

int countPrime(vector<ll>& vec) {
    int count = 0;
    for (auto v : vec) {
        bool flag = true;
        for (int i = 2; i <= sqrt(v); i++) {
            if (v % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag) count++;
    }
    return count;
}

int solution(int n, int k) {
    vector<ll> vec;
    string s;
    while (true) {
        int mod = n % k;
        if (mod != 0) s.push_back(mod + '0');
        else if (!s.empty()) {
            reverse(s.begin(), s.end());
            ll tmp = stoll(s);
            if (tmp != 0 && tmp != 1) vec.push_back(tmp);
            s.clear();
        }
        if (n == 0) break;
        n /= k;
    }
    return countPrime(vec);
}