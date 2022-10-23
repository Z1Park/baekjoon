a, b = [' '] + list(input().rstrip()), [''] + list(input().rstrip())
if len(a) < len(b):
    a, b = b, a
dp = [[0 for _ in range(len(b))] for _ in range(len(a))]
strn = [["" for _ in range(len(b))] for _ in range(len(a))]
for i in range(1, len(a)):
    for j in range(1, len(b)):
        if a[i] == b[j]:
            dp[i][j] = dp[i-1][j-1] + 1
            strn[i][j] = strn[i-1][j-1] + a[i]
        else:
            if dp[i-1][j] > dp[i][j-1]:
                dp[i][j] = dp[i-1][j]
                strn[i][j] = strn[i-1][j]
            else:
                dp[i][j] = dp[i][j-1]
                strn[i][j] = strn[i][j-1]
print(dp[-1][-1])
print(strn[-1][-1])