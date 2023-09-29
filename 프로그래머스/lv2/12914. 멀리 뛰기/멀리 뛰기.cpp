#include <string>
#include <vector>

using namespace std;

typedef long long ll;

ll dp[2001];

ll solution(int n) {
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
    }
    return dp[n];
}