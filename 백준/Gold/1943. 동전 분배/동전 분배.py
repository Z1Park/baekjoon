import sys
input = lambda : sys.stdin.readline().rstrip()

for t in range(3):
    n = int(input())
    coin = {}
    s = 0
    for _ in range(n):
        a, b = map(int ,input().split())
        coin[a] = b
        s += a * b
    if (s%2 == 1):
        print(0)
        continue
    s //= 2
    dp = [1] + [0 for _ in range(s)]
    for c in coin:
        for i in range(s, c-1, -1):
            if dp[i-c] == 1:
                for j in range(coin[c]):
                    if i+c*j <= s:
                        dp[i+c*j] = 1
    print(dp[s])
