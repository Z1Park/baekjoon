from sys import stdin

input = stdin.readline
tc = int(input())
for t in range(tc):
    n = int(input())
    sticker = list(zip(*(list(map(int, input().split())) for b in range(2))))
    if n == 1:
        print(max(sticker[0]))
        continue
    dp = [[0 for a in range(2)] for b in range(n)]
    dp[0][0] = sticker[0][0]
    dp[0][1] = sticker[0][1]
    dp[1][0] = dp[0][1] + sticker[1][0]
    dp[1][1] = dp[0][0] + sticker[1][1]
    for i in range(2, n):
        dp[i][0] = max(dp[i-1][1], dp[i-2][1]) + sticker[i][0]
        dp[i][1] = max(dp[i-1][0], dp[i-2][0]) + sticker[i][1]
    print(max(dp[n-1]))