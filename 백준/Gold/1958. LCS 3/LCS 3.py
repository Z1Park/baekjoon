a = [' '] + list(input().rstrip())
b = [' '] + list(input().rstrip())
c = [' '] + list(input().rstrip())
dp = [[[0 for _ in range(len(c))] for _ in range(len(b))] for _ in range(len(a))]
for i in range(1, len(a)):
    for j in range(1, len(b)):
        for k in range(1, len(c)):
            if a[i] == b[j] and b[j] == c[k]:
                dp[i][j][k] = dp[i-1][j-1][k-1] + 1
            else:
                dp[i][j][k] = max(dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1])
print(dp[-1][-1][-1])